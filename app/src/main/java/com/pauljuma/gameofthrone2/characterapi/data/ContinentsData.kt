package com.pauljuma.gameofthrone2.characterapi.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "continents")
data class ContinentsData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
