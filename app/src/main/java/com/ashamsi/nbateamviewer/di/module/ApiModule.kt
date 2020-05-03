package com.ashamsi.nbateamviewer.di.module

import com.ashamsi.data.retrorit.ApiFactory
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideApiFactory(isConnected: Boolean, cacheDir: File): ApiFactory = ApiFactory(isConnected, cacheDir)
}