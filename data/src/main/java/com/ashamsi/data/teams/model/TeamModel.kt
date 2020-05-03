package com.ashamsi.data.teams.model

import com.google.gson.annotations.SerializedName

data class TeamModel(
        @SerializedName("id") val id: Int,
        @SerializedName("full_name") val name: String,
        @SerializedName("wins") val wins: Int,
        @SerializedName("losses") val losses: Int,
        @SerializedName("players") val players: List<PlayerModel>
)