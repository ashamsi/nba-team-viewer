package com.ashamsi.nbateamviewer.di

import com.ashamsi.nbateamviewer.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [ActivityModule::class, FragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}