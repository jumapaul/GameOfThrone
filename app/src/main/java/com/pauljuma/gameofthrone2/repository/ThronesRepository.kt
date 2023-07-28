package com.pauljuma.gameofthrone2.repository

import com.pauljuma.gameofthrone2.characterapi.ThronesApiInstance
import com.pauljuma.gameofthrone2.characterapi.data.ContinentsData
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import com.pauljuma.gameofthrone2.dao.ThronesDatabase

class ThronesRepository(val db: ThronesDatabase) {

    suspend fun getCharacter(): List<ThronesCharacterDataItem> {
        return ThronesApiInstance.api.getCharacters()
    }

    suspend fun getContinents(): List<ContinentsData>{
        return ThronesApiInstance.api.getContinents()
    }
}