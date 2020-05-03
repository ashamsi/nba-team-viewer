package com.ashamsi.domain.teams.usecase

import com.ashamsi.domain.UseCase
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.teams.repository.TeamsRepository
import com.ashamsi.domain.util.ResultUtil

/**
 * [UseCase] to get [TeamEntity]'s.
 */
class GetTeamsUseCase(private val teamsRepository: TeamsRepository) : UseCase<ResultUtil<List<TeamEntity>>, String> {
    override suspend fun execute(vararg args: String): ResultUtil<List<TeamEntity>> = teamsRepository.getTeams()
}