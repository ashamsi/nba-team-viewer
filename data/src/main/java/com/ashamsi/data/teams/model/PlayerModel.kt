package com.ashamsi.data.teams.model

import com.google.gson.annotations.SerializedName

data class PlayerModel(
        @SerializedName("id") val id: Int,
        @SerializedName("first_name") val firstName: String,
        @SerializedName("last_name") val lastName: String,
        @SerializedName("position") val position: String,
        @SerializedName("number") val number: Int
)