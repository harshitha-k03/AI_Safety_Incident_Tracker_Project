package com.humanchain.aisafetytracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.humanchain.aisafetytracker.R
import com.humanchain.aisafetytracker.databinding.FragmentIncidentListBinding

class IncidentListFragment : Fragment() {
    private var _binding: FragmentIncidentListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: IncidentViewModel by viewModels({ requireActivity() })
    private lateinit var incidentAdapter: IncidentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncidentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        incidentAdapter = IncidentAdapter(
            onIncidentClick = { incident ->
                val action = IncidentListFragmentDirections.actionIncidentListFragmentToIncidentDetailFragment(incident.id)
                findNavController().navigate(action)
            },
            onDeleteClick = { incident ->
                // Show confirmation dialog before deleting
                AlertDialog.Builder(requireContext())
                    .setTitle("Delete Incident")
                    .setMessage("Are you sure you want to delete this incident?")
                    .setPositiveButton("Yes") { _, _ ->
                        viewModel.deleteIncident(incident)
                    }
                    .setNegativeButton("No", null)
                    .show()
            }
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = incidentAdapter
        }

        binding.buttonAll.setOnClickListener { viewModel.applyFilter("All") }
        binding.buttonLow.setOnClickListener { viewModel.applyFilter("Low") }
        binding.buttonMedium.setOnClickListener { viewModel.applyFilter("Medium") }
        binding.buttonHigh.setOnClickListener { viewModel.applyFilter("High") }

        viewModel.filteredIncidents.observe(viewLifecycleOwner) { incidents ->
            incidentAdapter.submitList(incidents)
        }

        setUpFab()
    }

    private fun setUpFab() {
        binding.fabReportIncident.setOnClickListener {
            findNavController().navigate(R.id.action_incidentListFragment_to_reportIncidentFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}