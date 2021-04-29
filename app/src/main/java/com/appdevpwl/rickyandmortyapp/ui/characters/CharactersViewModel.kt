package com.appdevpwl.rickyandmortyapp.ui.characters

import androidx.lifecycle.ViewModel
import com.appdevpwl.rickyandmortyapp.data.characters.CharactersRepository
import javax.inject.Inject

class CharactersViewModel @Inject constructor(private val repository: CharactersRepository) :
    ViewModel()