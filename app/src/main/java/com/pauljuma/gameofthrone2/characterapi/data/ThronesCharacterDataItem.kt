package com.pauljuma.gameofthrone2.characterapi.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Characters")
data class ThronesCharacterDataItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var family: String,
    var firstName: String,
    var fullName: String,
    var image: String,
    var imageUrl: String,
    var lastName: String,
    var title: String
)