package com.ashamsi.nbateamviewer.di

import android.app.Application
import com.ashamsi.nbateamviewer.util.NetworkUtils
import com.ashamsi.nbateamviewer.util.StorageUtils
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Singleton
    @Provides
    fun provideApplication(): Application = application

    @Singleton
    @Provides
    fun provideNetworkState(): Boolean = NetworkUtils.isNetworkConnected(application)

    @Singleton
    @Provides
    fun provideCacheDir(): File = StorageUtils.getCacheDir(application)
}