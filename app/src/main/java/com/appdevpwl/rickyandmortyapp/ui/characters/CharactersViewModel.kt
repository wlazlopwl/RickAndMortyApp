package com.appdevpwl.rickyandmortyapp.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.appdevpwl.rickyandmortyapp.api.Service
import com.appdevpwl.rickyandmortyapp.data.characters.CharactersRepository
import com.appdevpwl.rickyandmortyapp.data.characters.Result
import com.appdevpwl.rickyandmortyapp.paging.CharactersPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val repository: CharactersRepository,
    private val service: Service
) :
    ViewModel() {
//    private lateinit var _charactersFlow: Flow<PagingData<Result>>
//    val charactersFlow: Flow<PagingData<Result>>
//        get() = _charactersFlow
//
//    init {
//        getCharacters()
//    }


    val flow = Pager(
        PagingConfig(pageSize = 2)
    ) {
        CharactersPagingSource(service)
    }.flow
        .cachedIn(viewModelScope)


//    private fun getCharacters() {
//        viewModelScope.launch {
//            _charactersFlow = repository.getCharacters().cachedIn(viewModelScope)
//
//
//        }
//
//    }

}