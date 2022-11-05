package com.pauljuma.gameofthrone2.repository

import com.pauljuma.gameofthrone2.characterapi.CharacterApiInstance
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import com.pauljuma.gameofthrone2.dao.ThronesDatabase

class ThronesRepository(val db: ThronesDatabase) {

    suspend fun getCharacter(): List<ThronesCharacterDataItem> {
        return CharacterApiInstance.api.getCharacters()
    }
}