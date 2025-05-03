package com.humanchain.aisafetytracker.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.humanchain.aisafetytracker.model.Incident

class IncidentViewModel : ViewModel() {

    private val _incidents = MutableLiveData<MutableList<Incident>>(
        mutableListOf(
            Incident(1, "Biased Recommendation Algorithm", "Medium", "2025-03-15T10:00:00Z", "Algorithm consistently favored certain demographics..."),
            Incident(2, "LLM Hallucination in Critical Info", "High", "2025-04-01T14:30:00Z", "LLM provided incorrect safety procedure information..."),
            Incident(3, "Minor Data Leak via Chatbot", "Low", "2025-03-20T09:15:00Z", "Chatbot inadvertently exposed non-sensitive user metadata...")
        )
    )

    val incidents: LiveData<MutableList<Incident>> = _incidents

    private val _filteredIncidents = MutableLiveData<List<Incident>>()
    val filteredIncidents: LiveData<List<Incident>> = _filteredIncidents

    private var currentFilter: String = "All"

    init {
        _filteredIncidents.value = _incidents.value
    }

    fun addIncident(incident: Incident) {
        val currentList = _incidents.value ?: mutableListOf()
        currentList.add(incident)
        _incidents.value = currentList
        applyFilter(currentFilter)
    }

    // Add delete function
    fun deleteIncident(incident: Incident) {
        val currentList = _incidents.value ?: mutableListOf()
        currentList.remove(incident)
        _incidents.value = currentList
        applyFilter(currentFilter)
    }

    fun applyFilter(filter: String) {
        currentFilter = filter
        _incidents.value?.let { allIncidents ->
            val filtered = if (filter == "All") {
                allIncidents
            } else {
                allIncidents.filter { it.severity.equals(filter, ignoreCase = true) }
            }
            _filteredIncidents.value = filtered
        }
    }
}