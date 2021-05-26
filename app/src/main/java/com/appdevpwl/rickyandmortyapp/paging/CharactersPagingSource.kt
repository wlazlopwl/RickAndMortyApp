package com.appdevpwl.rickyandmortyapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.appdevpwl.rickyandmortyapp.api.Service
import com.appdevpwl.rickyandmortyapp.data.characters.Result
import javax.inject.Inject

class CharactersPagingSource @Inject constructor(private val service: Service) :
    PagingSource<Int, Result>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val page = params.key ?: 1
            val response = service.getCharacters(page)
            val data = response.body()?.results

            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = if (page == 1) null else (page - 1),
                nextKey = page + 1

            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }


    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return 1
    }


}