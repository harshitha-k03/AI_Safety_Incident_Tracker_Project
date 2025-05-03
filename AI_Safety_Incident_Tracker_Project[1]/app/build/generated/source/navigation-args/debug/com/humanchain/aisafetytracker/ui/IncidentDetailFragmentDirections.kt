package com.humanchain.aisafetytracker.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.humanchain.aisafetytracker.R

public class IncidentDetailFragmentDirections private constructor() {
  public companion object {
    public fun actionIncidentDetailFragmentToIncidentListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_incidentDetailFragment_to_incidentListFragment)
  }
}
