package com.ashamsi.nbateamviewer.util.view

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ashamsi.domain.teams.entity.PlayerEntity
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.nbateamviewer.R

@BindingAdapter("teamNameString")
fun TextView.setTeamNameString(item: TeamEntity?) {
    item?.let {
        text = context.getString(R.string.team_name, it.name)
    }
}

@BindingAdapter("teamWinsString")
fun TextView.setTeamWinsString(item: TeamEntity?) {
    item?.let {
        text = context.getString(R.string.team_wins, it.wins)
    }
}

@BindingAdapter("teamLossesString")
fun TextView.setTeamLossesString(item: TeamEntity?) {
    item?.let {
        text = context.getString(R.string.team_losses, it.losses)
    }
}

@BindingAdapter("playerNameString")
fun TextView.setPlayerName(item: PlayerEntity?) {
    item?.let {
        text = context.getString(R.string.player_name, it.firstName, it.lastName)
    }
}

@BindingAdapter("playerPosition")
fun TextView.setPlayerPosition(item: PlayerEntity?) {
    item?.let {
        text = context.getString(R.string.player_position, it.position)
    }
}

@BindingAdapter("playerNumber")
fun TextView.setPlayerNumber(item: PlayerEntity?) {
    item?.let {
        text = context.getString(R.string.player_number, it.number)
    }
}