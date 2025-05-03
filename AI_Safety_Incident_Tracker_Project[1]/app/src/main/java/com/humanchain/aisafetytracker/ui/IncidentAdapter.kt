package com.humanchain.aisafetytracker.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.humanchain.aisafetytracker.R
import com.humanchain.aisafetytracker.model.Incident

class IncidentAdapter(
    private val onIncidentClick: (Incident) -> Unit, // For navigating to detail
    private val onDeleteClick: (Incident) -> Unit     // For deleting an incident
) : ListAdapter<Incident, IncidentAdapter.IncidentViewHolder>(IncidentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_incident, parent, false)
        return IncidentViewHolder(view, onIncidentClick, onDeleteClick)
    }

    override fun onBindViewHolder(holder: IncidentViewHolder, position: Int) {
        val incident = getItem(position)
        holder.bind(incident)
    }

    class IncidentViewHolder(
        itemView: View,
        private val onIncidentClick: (Incident) -> Unit,
        private val onDeleteClick: (Incident) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        private val severityTextView: TextView = itemView.findViewById(R.id.textViewSeverity)
        private val timestampTextView: TextView = itemView.findViewById(R.id.textViewTimestamp)
        private val deleteButton: android.widget.Button = itemView.findViewById(R.id.buttonDelete)

        fun bind(incident: Incident) {
            titleTextView.text = incident.title
            severityTextView.text = incident.severity
            timestampTextView.text = incident.reported

            // Navigate to detail on item click
            itemView.setOnClickListener {
                onIncidentClick(incident)
            }

            // Delete the incident on delete button click
            deleteButton.setOnClickListener {
                onDeleteClick(incident)
            }
        }
    }
}

class IncidentDiffCallback : DiffUtil.ItemCallback<Incident>() {
    override fun areItemsTheSame(oldItem: Incident, newItem: Incident): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Incident, newItem: Incident): Boolean {
        return oldItem == newItem
    }
}