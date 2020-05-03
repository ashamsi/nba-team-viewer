package com.ashamsi.data.teams.repository

import com.ashamsi.data.teams.source.TeamsDataSource
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.teams.repository.TeamsRepository
import com.ashamsi.domain.util.ResultUtil

class TeamsRepositoryImpl(
        private val remoteDataSource: TeamsDataSource,
        private val localDataSource: TeamsDataSource
) : TeamsRepository {
    override suspend fun getTeams(): ResultUtil<List<TeamEntity>> = remoteDataSource.getTeams()
}