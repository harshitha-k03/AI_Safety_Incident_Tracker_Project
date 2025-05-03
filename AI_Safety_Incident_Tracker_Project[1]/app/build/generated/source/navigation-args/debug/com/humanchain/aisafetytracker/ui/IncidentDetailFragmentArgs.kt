package com.humanchain.aisafetytracker.ui

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class IncidentDetailFragmentArgs(
  public val incidentId: Int = 0,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("incidentId", this.incidentId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("incidentId", this.incidentId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): IncidentDetailFragmentArgs {
      bundle.setClassLoader(IncidentDetailFragmentArgs::class.java.classLoader)
      val __incidentId : Int
      if (bundle.containsKey("incidentId")) {
        __incidentId = bundle.getInt("incidentId")
      } else {
        __incidentId = 0
      }
      return IncidentDetailFragmentArgs(__incidentId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        IncidentDetailFragmentArgs {
      val __incidentId : Int?
      if (savedStateHandle.contains("incidentId")) {
        __incidentId = savedStateHandle["incidentId"]
        if (__incidentId == null) {
          throw IllegalArgumentException("Argument \"incidentId\" of type integer does not support null values")
        }
      } else {
        __incidentId = 0
      }
      return IncidentDetailFragmentArgs(__incidentId)
    }
  }
}
