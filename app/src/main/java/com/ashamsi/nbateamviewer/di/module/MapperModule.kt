package com.ashamsi.nbateamviewer.di.module

import com.ashamsi.data.mapper.DataToDomainMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Singleton
    @Provides
    fun provideDataToDomainMapper(): DataToDomainMapper = DataToDomainMapper()
}