package com.humanchain.aisafetytracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.humanchain.aisafetytracker.R
import com.humanchain.aisafetytracker.databinding.FragmentIncidentDetailBinding

class IncidentDetailFragment : Fragment() {
    private var _binding: FragmentIncidentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: IncidentViewModel by viewModels({ requireActivity() })
    private val args: IncidentDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncidentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val incidentId = args.incidentId
        val incident = viewModel.incidents.value?.find { it.id == incidentId }

        if (incident != null) {
            binding.textViewTitle.text = incident.title
            binding.textViewSeverity.text = incident.severity
            binding.textViewTimestamp.text = incident.reported
            binding.textViewDescription.text = incident.description
        } else {
            binding.textViewTitle.text = "Incident Not Found" // This causes the string literal warning
        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_incidentDetailFragment_to_incidentListFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}