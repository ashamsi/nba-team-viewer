package com.ashamsi.domain.teams.repository

import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.util.ResultUtil

/**
 * Contract for data layer to deal with [TeamEntity]'s.
 */
interface TeamsRepository {
    suspend fun getTeams(): ResultUtil<List<TeamEntity>>
}