package com.ashamsi.nbateamviewer.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashamsi.nbateamviewer.di.viewmodel.ViewModelFactory
import com.ashamsi.nbateamviewer.di.viewmodel.ViewModelKey
import com.ashamsi.nbateamviewer.view.allteams.AllTeamsFragmentViewModel
import com.ashamsi.nbateamviewer.view.team.TeamFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    @Singleton
    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    /**
     * Annotating @IntoMap in a provides/binds annotated method of Dagger module class will instruct dagger to add the provided value to a map.
     */
    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(AllTeamsFragmentViewModel::class)
    abstract fun provideAllTeamsFragmentViewModel(viewModelAllTeams: AllTeamsFragmentViewModel): ViewModel

    /**
     * Annotating @IntoMap in a provides/binds annotated method of Dagger module class will instruct dagger to add the provided value to a map.
     */
    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(TeamFragmentViewModel::class)
    abstract fun provideTeamFragmentViewModel(viewModelTeam: TeamFragmentViewModel): ViewModel
}