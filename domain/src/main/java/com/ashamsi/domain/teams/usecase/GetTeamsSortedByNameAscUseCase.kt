package com.ashamsi.domain.teams.usecase

import com.ashamsi.domain.UseCase
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.util.SystemLogUtils

private const val TAG = "GetTeamsSortedByNameAscendingUseCase"

/**
 * [UseCase] to get [TeamEntity]'s. sorted by [TeamEntity.name] ascending order.
 */
class GetTeamsSortedByNameAscUseCase : UseCase<List<TeamEntity>, List<TeamEntity>> {
    override suspend fun execute(vararg args: List<TeamEntity>): List<TeamEntity> {
        return try {
            if (args.size != 1) {
                throw IllegalArgumentException("Invalid number of arguments - expected 1 received  ${args.size}")
            }

            val sortedTeams = mutableListOf<TeamEntity>()
            sortedTeams.addAll(args[0])
            sortedTeams.sortBy {
                it.name
            }
            sortedTeams
        } catch (e: Exception) {
            SystemLogUtils.e(TAG, "Failed to get sorted teams.", e)
            args[0]
        }
    }

    private fun sortByWins(listToSort: MutableList<TeamEntity>) {
        SystemLogUtils.d(TAG, "sortByWins called.")
        listToSort.sortByDescending {
            it.wins
        }
    }

    private fun sortByLosses(listToSort: MutableList<TeamEntity>) {
        SystemLogUtils.d(TAG, "sortByLosses called.")
        listToSort.sortBy {
            it.losses
        }
    }
}