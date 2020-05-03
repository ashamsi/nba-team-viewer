package com.ashamsi.nbateamviewer.di

import com.ashamsi.nbateamviewer.view.allteams.AllTeamsFragment
import com.ashamsi.nbateamviewer.view.team.TeamFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ContributesAndroidInjector
    abstract fun bindTeamsFragment(): AllTeamsFragment

    @ContributesAndroidInjector
    abstract fun bindTeamFragment(): TeamFragment
}