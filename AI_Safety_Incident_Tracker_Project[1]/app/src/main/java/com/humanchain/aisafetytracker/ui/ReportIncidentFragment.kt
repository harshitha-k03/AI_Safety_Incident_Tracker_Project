package com.humanchain.aisafetytracker.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.humanchain.aisafetytracker.R
import com.humanchain.aisafetytracker.databinding.FragmentReportIncidentBinding
import com.humanchain.aisafetytracker.model.Incident
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ReportIncidentFragment : Fragment() {
    private var _binding: FragmentReportIncidentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: IncidentViewModel by viewModels({ requireActivity() }) // Shared ViewModel with activity scope

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportIncidentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSubmit.setOnClickListener {
            // Get the input values
            val title = binding.editTextTitle.text.toString().trim()
            val severity = binding.editTextSeverity.text.toString().trim()
            val description = binding.editTextDescription.text.toString().trim()

            // Validate input
            if (title.isEmpty() || severity.isEmpty() || description.isEmpty()) {
                // You can add a Toast or error message here if fields are empty
                return@setOnClickListener
            }

            // Validate severity
            val validSeverities = listOf("Low", "Medium", "High")
            if (!validSeverities.contains(severity, ignoreCase = true)) {
                // You can add a Toast or error message here if severity is invalid
                return@setOnClickListener
            }

            // Generate a timestamp in the correct format
            val timestamp = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).format(Date())

            // Create a new Incident
            val newIncident = Incident(
                id = (viewModel.incidents.value?.size ?: 0) + 1, // Generate a new ID
                title = title,
                severity = severity,
                reported = timestamp,
                description = description
            )

            // Add the incident to the ViewModel
            viewModel.addIncident(newIncident)

            // Hide the keyboard
            hideKeyboard(binding.buttonSubmit)

            // Navigate back to IncidentListFragment
            findNavController().navigate(R.id.action_reportIncidentFragment_to_incidentListFragment)
        }
    }

    private fun hideKeyboard(view: View) {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun List<String>.contains(element: String, ignoreCase: Boolean): Boolean {
    return any { it.equals(element, ignoreCase) }
}