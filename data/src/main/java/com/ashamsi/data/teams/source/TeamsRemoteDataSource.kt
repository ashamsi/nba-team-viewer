package com.ashamsi.data.teams.source

import com.ashamsi.data.mapper.DataToDomainMapper
import com.ashamsi.data.retrorit.ApiFactory
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.domain.util.ResultUtil
import com.ashamsi.domain.util.SystemLogUtils
import java.io.IOException

private const val TAG = "TeamsRemoteDataSource"

class TeamsRemoteDataSource(private val dataToDomainMapper: DataToDomainMapper, private val apiFactory: ApiFactory) : TeamsDataSource.TeamsRemoteDataSource {
    override suspend fun getTeams(): ResultUtil<List<TeamEntity>> {
        val response = apiFactory.retrofitService.getTeams()
        return try {
            if (response.isSuccessful) {
                val sortedTeams = mutableListOf<TeamEntity>()
                sortedTeams.addAll(dataToDomainMapper.fromTeamModelToTeamEntity(response.body()))
                sortedTeams.sortBy {
                    it.name
                }
                ResultUtil.Success(sortedTeams)
            } else {
                SystemLogUtils.e(TAG, "Error occurred during fetching teams, ${response.errorBody().toString()}")
                ResultUtil.Error(IOException("Error occurred during fetching teams."))
            }
        } catch (e: Exception) {
            SystemLogUtils.e(TAG, "Failed to fetch teams.", e)
            ResultUtil.Error(IOException("Failed to fetch teams."))
        }
    }
}