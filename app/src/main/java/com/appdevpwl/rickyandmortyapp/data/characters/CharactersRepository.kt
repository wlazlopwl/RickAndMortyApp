package com.appdevpwl.rickyandmortyapp.data.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.appdevpwl.rickyandmortyapp.api.Service
import com.appdevpwl.rickyandmortyapp.paging.CharactersPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val service: Service) {


//     fun getCharacters(): Flow<PagingData<Result>> = Pager(
//        config = PagingConfig(
//            pageSize = 20
//        ),
//        pagingSourceFactory = { CharactersPagingSource(service) }
//    ).flow


}

