package com.humanchain.aisafetytracker.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.humanchain.aisafetytracker.R

public class ReportIncidentFragmentDirections private constructor() {
  public companion object {
    public fun actionReportIncidentFragmentToIncidentListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_reportIncidentFragment_to_incidentListFragment)
  }
}
