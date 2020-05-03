package com.ashamsi.nbateamviewer.view.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashamsi.domain.LogUtils
import com.ashamsi.domain.teams.entity.TeamEntity
import javax.inject.Inject

private const val TAG = "AllTeamsFragmentViewModel"

class TeamFragmentViewModel @Inject constructor(
        private val log: LogUtils
) : ViewModel() {
    private val _team = MutableLiveData<TeamEntity>()
    val team: LiveData<TeamEntity>
        get() = _team

    fun setTeam(teamEntity: TeamEntity) {
        log.d(TAG, "setTeam called.")
        _team.value = teamEntity
    }
}
