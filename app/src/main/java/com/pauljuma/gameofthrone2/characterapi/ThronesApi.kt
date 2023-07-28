package com.pauljuma.gameofthrone2.characterapi

import com.pauljuma.gameofthrone2.characterapi.data.ContinentsData
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import retrofit2.http.GET

interface ThronesApi {

    @GET("v2/Characters")
    suspend fun getCharacters(): List<ThronesCharacterDataItem>

    @GET("v2/continents")
    suspend fun getContinents(): List<ContinentsData>
}