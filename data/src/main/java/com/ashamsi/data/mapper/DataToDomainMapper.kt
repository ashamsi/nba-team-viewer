package com.ashamsi.data.mapper

import com.ashamsi.data.teams.model.TeamModel
import com.ashamsi.domain.teams.entity.PlayerEntity
import com.ashamsi.domain.teams.entity.TeamEntity

class DataToDomainMapper {
    fun fromTeamModelToTeamEntity(teams: List<TeamModel>?): List<TeamEntity> {
        return if (teams != null) {
            val mappedTeams: ArrayList<TeamEntity> = ArrayList(teams.size)
            teams.forEach { teamModel ->
                val players = teamModel.players
                val mappedPlayers: ArrayList<PlayerEntity> = ArrayList(players.size)
                players.forEach { playerModel ->
                    mappedPlayers.add(PlayerEntity(playerModel.id, playerModel.firstName, playerModel.lastName, playerModel.position, playerModel.number))
                }
                mappedTeams.add(TeamEntity(teamModel.id, teamModel.name, teamModel.wins, teamModel.losses, mappedPlayers))
            }
            mappedTeams
        } else {
            emptyList()
        }
    }
}