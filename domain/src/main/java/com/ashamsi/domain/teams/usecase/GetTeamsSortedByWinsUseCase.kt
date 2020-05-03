package com.ashamsi.domain.teams.usecase

import com.ashamsi.domain.UseCase
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.util.SystemLogUtils

private const val TAG = "GetTeamsSortedByWinsUseCase"

/**
 * [UseCase] to get [TeamEntity]'s. sorted by [TeamEntity.wins] descending order.
 */
open class GetTeamsSortedByWinsUseCase : UseCase<List<TeamEntity>, List<TeamEntity>> {
    override suspend fun execute(vararg args: List<TeamEntity>): List<TeamEntity> {
        return try {
            if (args.size != 1) {
                throw IllegalArgumentException("Invalid number of arguments - expected 1 received  ${args.size}")
            }

            val sortedTeams = mutableListOf<TeamEntity>()
            sortedTeams.addAll(args[0])
            sortedTeams.sortByDescending {
                it.wins
            }
            sortedTeams
        } catch (e: Exception) {
            SystemLogUtils.e(TAG, "Failed to get sorted teams.", e)
            args[0]
        }
    }
}