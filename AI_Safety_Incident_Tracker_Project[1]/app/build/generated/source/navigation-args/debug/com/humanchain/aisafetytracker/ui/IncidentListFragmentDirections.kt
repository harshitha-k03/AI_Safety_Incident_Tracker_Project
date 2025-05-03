package com.humanchain.aisafetytracker.ui

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.humanchain.aisafetytracker.R
import kotlin.Int

public class IncidentListFragmentDirections private constructor() {
  private data class ActionIncidentListFragmentToIncidentDetailFragment(
    public val incidentId: Int = 0,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_incidentListFragment_to_incidentDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("incidentId", this.incidentId)
        return result
      }
  }

  public companion object {
    public fun actionIncidentListFragmentToReportIncidentFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_incidentListFragment_to_reportIncidentFragment)

    public fun actionIncidentListFragmentToIncidentDetailFragment(incidentId: Int = 0):
        NavDirections = ActionIncidentListFragmentToIncidentDetailFragment(incidentId)
  }
}
