package com.appdevpwl.rickyandmortyapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appdevpwl.rickyandmortyapp.ui.characters.CharactersViewModel
import com.appdevpwl.rickyandmortyapp.ui.episodes.EpisodesViewModel
import com.appdevpwl.rickyandmortyapp.ui.locations.LocationsViewModel
import com.appdevpwl.spacex.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    abstract fun bindCharactersViewModel(charactersViewModel: CharactersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EpisodesViewModel::class)
    abstract fun bindDashboardViewModel(episodesViewModel: EpisodesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LocationsViewModel::class)
    abstract fun bindNotificationsViewModel(locationsViewModel: LocationsViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}
