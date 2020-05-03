package com.ashamsi.nbateamviewer.di.module

import com.ashamsi.domain.teams.repository.TeamsRepository
import com.ashamsi.domain.teams.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetTeamsUseCase(teamsRepository: TeamsRepository): GetTeamsUseCase = GetTeamsUseCase(teamsRepository)

    @Singleton
    @Provides
    fun provideGetTeamsSortedByNameAscUseCase(): GetTeamsSortedByNameAscUseCase = GetTeamsSortedByNameAscUseCase()

    @Singleton
    @Provides
    fun provideGetTeamsSortedByNameDescUseCase(): GetTeamsSortedByNameDescUseCase = GetTeamsSortedByNameDescUseCase()

    @Singleton
    @Provides
    fun provideGetTeamsSortedByWinsUseCase(): GetTeamsSortedByWinsUseCase = GetTeamsSortedByWinsUseCase()

    @Singleton
    @Provides
    fun provideGetTeamsSortedByLossesUseCase(): GetTeamsSortedByLossesUseCase = GetTeamsSortedByLossesUseCase()
}