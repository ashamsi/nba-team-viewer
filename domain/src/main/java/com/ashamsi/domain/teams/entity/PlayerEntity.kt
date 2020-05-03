package com.ashamsi.domain.teams.entity

/**
 * Entity to hold an NBA team player data.
 */
data class PlayerEntity(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val position: String,
        val number: Int
)