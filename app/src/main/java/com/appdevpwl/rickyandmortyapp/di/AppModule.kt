package com.appdevpwl.spacex.di

import android.app.Application
import android.content.Context
import com.appdevpwl.rickyandmortyapp.di.ActivityBuildersModule
import com.appdevpwl.rickyandmortyapp.di.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ActivityBuildersModule::class, ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }


}