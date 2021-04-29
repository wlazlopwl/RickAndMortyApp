package com.appdevpwl.rickyandmortyapp.api

import com.appdevpwl.rickyandmortyapp.data.characters.CharacterItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

 interface Service {

     @GET("character")
     suspend fun getCharacters(@Query("page") page: Int): Response<CharacterItem>
}