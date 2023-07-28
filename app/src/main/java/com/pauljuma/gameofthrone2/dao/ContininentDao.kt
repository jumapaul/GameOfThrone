package com.pauljuma.gameofthrone2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.pauljuma.gameofthrone2.characterapi.data.ContinentsData

@Dao
interface ContininentDao {

    @Query("Select * FROM continents")
    fun getAllContinents(): LiveData<List<ContinentsData>>
}