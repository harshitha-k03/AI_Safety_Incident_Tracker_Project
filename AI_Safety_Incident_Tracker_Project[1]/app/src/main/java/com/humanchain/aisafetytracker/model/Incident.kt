package com.humanchain.aisafetytracker.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Incident(
    val id: Int,
    val title: String,
    val severity: String,
    val reported: String,
    val description: String
) : Parcelable