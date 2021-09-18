package com.patikadev.deneme1.ui.spacex.dto

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("mission_name") val missionName: String,
    @SerializedName("launch_year") val year: String,
    val details: String,
    @SerializedName("rocket") val rocket: Rocket

)

data class Rocket(
    @SerializedName("rocket_id") val id: String,
    @SerializedName("rocket_type") val type: String,
    @SerializedName("rocket_name") val name: String,
)





