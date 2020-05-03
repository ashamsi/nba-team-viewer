package com.ashamsi.data.teams.source

import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.util.ResultUtil

interface TeamsDataSource {
    suspend fun getTeams(): ResultUtil<List<TeamEntity>>

    interface TeamsRemoteDataSource : TeamsDataSource
    interface TeamsLocalDataSource : TeamsDataSource
}