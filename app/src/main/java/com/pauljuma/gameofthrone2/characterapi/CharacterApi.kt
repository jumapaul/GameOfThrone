package com.pauljuma.gameofthrone2.characterapi

import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterData
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("v2/Characters")
    suspend fun getCharacters(): List<ThronesCharacterDataItem>
}