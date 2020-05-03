package com.ashamsi.domain.teams.usecase

import com.ashamsi.domain.teams.entity.TeamEntityFixture
import com.ashamsi.domain.teams.repository.TeamsRepository
import com.ashamsi.domain.util.ResultUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.io.IOException

@ExperimentalCoroutinesApi
class GetTeamsUseCaseTest {

    private val teamsRepository = mock(TeamsRepository::class.java)
    private val getTeamsUseCase by lazy { GetTeamsUseCase(teamsRepository) }
    private val getTeamsSortedByNameAscUseCase by lazy { GetTeamsSortedByNameAscUseCase() }
    private val getTeamsSortedByNameDescUseCase by lazy { GetTeamsSortedByNameDescUseCase() }
    private val getTeamsSortedByWinsUseCase by lazy { GetTeamsSortedByWinsUseCase() }
    private val getTeamsSortedByLossesUseCase by lazy { GetTeamsSortedByLossesUseCase() }

    @Test
    fun `get teams list with success empty list`() = runBlockingTest {
        `when`(teamsRepository.getTeams()).thenReturn(ResultUtil.Success(emptyList()))

        val result = getTeamsUseCase.execute() as ResultUtil.Success
        Assert.assertEquals(0, result.data.size)
    }

    @Test
    fun `get teams list with error IOException`() = runBlockingTest {
        `when`(teamsRepository.getTeams()).thenReturn(ResultUtil.Error(IOException()))

        val result = getTeamsUseCase.execute() as ResultUtil.Error
        Assert.assertTrue(result.t is IOException)
    }

    @Test
    fun `sort teams list by name ascending with initial list and return sorted list`() {
        runBlocking {
            val result = getTeamsSortedByNameAscUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertEquals(TeamEntityFixture.sortedByNameAsc, result)
        }
    }

    @Test
    fun `sort teams list by name ascending with initial list and return non-sorted list`() {
        runBlocking {
            val result = getTeamsSortedByNameAscUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertNotEquals(TeamEntityFixture.sortedByNameAsc, TeamEntityFixture.initialTeams)
        }
    }

    @Test
    fun `sort teams list by name descending with initial list and return sorted list`() {
        runBlocking {
            val result = getTeamsSortedByNameDescUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertEquals(TeamEntityFixture.sortedByNameDesc, result)
        }
    }

    @Test
    fun `sort teams list by name descending with initial list and return non-sorted list`() {
        runBlocking {
            val result = getTeamsSortedByNameDescUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertNotEquals(TeamEntityFixture.sortedByNameDesc, TeamEntityFixture.initialTeams)
        }
    }

    @Test
    fun `sort teams list by wins descending with initial list and return sorted list`() {
        runBlocking {
            val result = getTeamsSortedByWinsUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertEquals(TeamEntityFixture.sortedByWinsTeams, result)
        }
    }

    @Test
    fun `sort teams list by wins descending with initial list and return non-sorted list`() {
        runBlocking {
            val result = getTeamsSortedByWinsUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertNotEquals(TeamEntityFixture.sortedByWinsTeams, TeamEntityFixture.initialTeams)
        }
    }

    @Test
    fun `sort teams list by losses ascending with initial list and return sorted list`() {
        runBlocking {
            val result = getTeamsSortedByLossesUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertEquals(TeamEntityFixture.sortedByLossesTeams, result)
        }
    }

    @Test
    fun `sort teams list by losses ascending with initial list and return non-sorted list`() {
        runBlocking {
            val result = getTeamsSortedByLossesUseCase.execute(TeamEntityFixture.initialTeams)
            Assert.assertNotEquals(TeamEntityFixture.sortedByLossesTeams, TeamEntityFixture.initialTeams)
        }
    }
}