package com.ashamsi.nbateamviewer

import com.ashamsi.nbateamviewer.di.AppModule
import com.ashamsi.nbateamviewer.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .applicationModule(AppModule(this))
                .build()
    }
}