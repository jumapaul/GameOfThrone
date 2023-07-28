package com.pauljuma.gameofthrone2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterData
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem

@Dao
interface CharacterDao {
    @Query("SELECT * FROM Characters")
    fun getAllCharacters(): LiveData<List<ThronesCharacterDataItem>>

}