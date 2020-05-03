package com.ashamsi.nbateamviewer.di.module

import com.ashamsi.domain.LogUtils
import com.ashamsi.domain.util.EmptyLogUtils
import com.ashamsi.nbateamviewer.BuildConfig
import com.ashamsi.nbateamviewer.util.AndroidLogUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {
    @Singleton
    @Provides
    fun provideLogUtils(): LogUtils = if (BuildConfig.DEBUG) AndroidLogUtils() else EmptyLogUtils()
}