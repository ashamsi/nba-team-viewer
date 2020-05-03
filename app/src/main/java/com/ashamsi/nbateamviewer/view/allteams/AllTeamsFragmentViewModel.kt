package com.ashamsi.nbateamviewer.view.allteams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashamsi.domain.LogUtils
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.teams.usecase.*
import com.ashamsi.domain.util.ResultUtil
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "AllTeamsFragmentViewModel"

class AllTeamsFragmentViewModel @Inject constructor(
        private val getTeamsUseCase: GetTeamsUseCase,
        private val getTeamsSortedByNameAscUseCase: GetTeamsSortedByNameAscUseCase,
        private val getTeamsSortedByNameDescUseCase: GetTeamsSortedByNameDescUseCase,
        private val getTeamsSortedByWinsUseCase: GetTeamsSortedByWinsUseCase,
        private val getTeamsSortedByLossesUseCase: GetTeamsSortedByLossesUseCase,
        private val log: LogUtils
) : ViewModel() {

    private val liveData = MutableLiveData<List<TeamEntity>>()
    private val _teams by lazy {
        getTeams()
        return@lazy liveData
    }

    fun teams(): LiveData<List<TeamEntity>> = _teams

    // Can be used for refresh as well
    private fun getTeams() {
        viewModelScope.launch {
            onLoadStarted()

            when (val result = getTeamsUseCase.execute()) {
                is ResultUtil.Success -> {
                    liveData.value = result.data
                    log.d(TAG, "Done fetching and setting teams info.")
                    onLoadFinished()
                }
                is ResultUtil.Error -> {
                    log.e(TAG, "Failed to fetch and set teams info.")
                    onLoadFinishedWithError(result.t)
                }
            }
        }
    }

    // region sort
    fun sort(position: Int) {
        when (position) {
            0 -> sortByNameAscending()
            1 -> sortByNameDescending()
            2 -> sortByWins()
            3 -> sortByLosses()
            else -> throw IndexOutOfBoundsException("Sort failed - invalid position.")
        }
    }

    private fun sortByNameAscending() {
        log.d(TAG, "sortByNameAscending called.")
        viewModelScope.launch {
            onLoadStarted()

            try {
                liveData.value = getTeamsSortedByNameAscUseCase.execute(liveData.value!!)
                log.d(TAG, "Done sorting by name ascending.")
                onLoadFinished()
            } catch (throwable: Throwable) {
                log.e(TAG, "Failed sorting by name ascending.")
                onLoadFinishedWithError(throwable)
            }
        }
    }

    private fun sortByNameDescending() {
        log.d(TAG, "sortByNameDescending called.")
        viewModelScope.launch {
            onLoadStarted()

            try {
                liveData.value = getTeamsSortedByNameDescUseCase.execute(liveData.value!!)
                log.d(TAG, "Done sorting by name descending.")
                onLoadFinished()
            } catch (throwable: Throwable) {
                log.e(TAG, "Failed sorting by name descending.")
                onLoadFinishedWithError(throwable)
            }
        }
    }

    private fun sortByWins() {
        log.d(TAG, "sortByWins called.")
        viewModelScope.launch {
            onLoadStarted()

            try {
                liveData.value = getTeamsSortedByWinsUseCase.execute(liveData.value!!)
                log.d(TAG, "Done sorting by wins descending.")
                onLoadFinished()
            } catch (throwable: Throwable) {
                log.e(TAG, "Failed sorting by wins descending.")
                onLoadFinishedWithError(throwable)
            }
        }
    }

    private fun sortByLosses() {
        log.d(TAG, "sortByLosses called.")
        viewModelScope.launch {
            onLoadStarted()

            try {
                liveData.value = getTeamsSortedByLossesUseCase.execute(liveData.value!!)
                log.d(TAG, "Done sorting by losses ascending.")
                onLoadFinished()
            } catch (throwable: Throwable) {
                log.e(TAG, "Failed sorting by losses ascending.")
                onLoadFinishedWithError(throwable)
            }
        }
    }
    // endregion sort

    // region navigation
    private val _navigateToTeamFragment = MutableLiveData<Boolean>()
    val navigateToTeamFragment: LiveData<Boolean>
        get() = _navigateToTeamFragment

    fun onNavigateClicked() {
        _navigateToTeamFragment.value = true
    }

    fun onNavigateComplete() {
        _navigateToTeamFragment.value = false
    }
    // endregion navigation

    // region loading
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error


    private fun onLoadStarted() {
        log.d(TAG, "onLoadStarted called.")
        _isLoading.postValue(true)
        _error.postValue(null)
    }

    private fun onLoadFinished() {
        log.d(TAG, "onLoadFinished called.")
        _isLoading.postValue(false)
        _error.postValue(null)
    }

    private fun onLoadFinishedWithError(throwable: Throwable) {
        log.d(TAG, "onLoadFinishedWithError called with: $throwable", throwable)
        _isLoading.postValue(false)
        _error.postValue(throwable.message)
    }
    // endregion loading
}