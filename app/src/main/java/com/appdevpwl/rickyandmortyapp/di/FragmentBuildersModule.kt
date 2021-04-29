package com.appdevpwl.rickyandmortyapp.di


import com.appdevpwl.rickyandmortyapp.ui.characters.CharactersFragment
import com.appdevpwl.rickyandmortyapp.ui.episodes.EpisodesFragment
import com.appdevpwl.rickyandmortyapp.ui.locations.LocationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeCharactersFragment(): CharactersFragment

    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): EpisodesFragment

    @ContributesAndroidInjector
    abstract fun contributeNotificationsFragment(): LocationsFragment


}