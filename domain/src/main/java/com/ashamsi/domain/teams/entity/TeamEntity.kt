package com.ashamsi.domain.teams.entity

/**
 * Entity to hold an NBA team data.
 */
data class TeamEntity(
        val id: Int,
        val name: String,
        val wins: Int,
        val losses: Int,
        val players: List<PlayerEntity>
)