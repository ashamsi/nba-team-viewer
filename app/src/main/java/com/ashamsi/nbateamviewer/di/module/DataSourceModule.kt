package com.ashamsi.nbateamviewer.di.module

import com.ashamsi.data.mapper.DataToDomainMapper
import com.ashamsi.data.retrorit.ApiFactory
import com.ashamsi.data.teams.source.TeamsDataSource
import com.ashamsi.data.teams.source.TeamsLocalDataSource
import com.ashamsi.data.teams.source.TeamsRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Singleton
    @Provides
    fun provideTeamsRemoteDataSource(dataToDomainMapper: DataToDomainMapper, apiFactory: ApiFactory): TeamsDataSource.TeamsRemoteDataSource =
            TeamsRemoteDataSource(dataToDomainMapper, apiFactory)

    @Singleton
    @Provides
    fun provideTeamsLocalDataSource(): TeamsDataSource.TeamsLocalDataSource = TeamsLocalDataSource()
}