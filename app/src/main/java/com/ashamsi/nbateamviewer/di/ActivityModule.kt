package com.ashamsi.nbateamviewer.di

import androidx.fragment.app.FragmentActivity
import com.ashamsi.nbateamviewer.MainActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @Provides
    fun provideFragmentActivity(activity: MainActivity): FragmentActivity = activity
}