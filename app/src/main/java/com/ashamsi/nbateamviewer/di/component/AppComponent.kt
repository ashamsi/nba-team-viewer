package com.ashamsi.nbateamviewer.di.component

import com.ashamsi.nbateamviewer.Application
import com.ashamsi.nbateamviewer.di.ActivityBindingModule
import com.ashamsi.nbateamviewer.di.AppModule
import com.ashamsi.nbateamviewer.di.module.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
        modules = [
            AndroidInjectionModule::class,
            AndroidSupportInjectionModule::class,
            ActivityBindingModule::class,
            AppModule::class,
            UseCaseModule::class,
            RepositoryModule::class,
            DataSourceModule::class,
            ApiModule::class,
            MapperModule::class,
            ViewModelModule::class,
            UtilModule::class
        ]
)
@Singleton
interface AppComponent : AndroidInjector<Application> {
    @Component.Builder
    interface Builder {
        fun applicationModule(module: AppModule): Builder
        fun build(): AppComponent
    }
}