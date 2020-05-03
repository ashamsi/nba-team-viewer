package com.ashamsi.nbateamviewer.di.module

import com.ashamsi.data.teams.repository.TeamsRepositoryImpl
import com.ashamsi.data.teams.source.TeamsDataSource
import com.ashamsi.domain.teams.repository.TeamsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideTeamsRepository(remoteDataSource: TeamsDataSource.TeamsRemoteDataSource,
                               localDataSource: TeamsDataSource.TeamsLocalDataSource
    ): TeamsRepository = TeamsRepositoryImpl(remoteDataSource, localDataSource)
}