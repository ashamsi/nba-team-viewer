package com.ashamsi.data.teams.source

import com.ashamsi.data.teams.source.LocalCacheSimulator.teams
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.util.ResultUtil

class TeamsLocalDataSource : TeamsDataSource.TeamsLocalDataSource {
    override suspend fun getTeams(): ResultUtil<List<TeamEntity>> = teams
}

object LocalCacheSimulator {
    var teams = ResultUtil.Success(listOf<TeamEntity>())
}