package com.pauljuma.gameofthrone2.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem

@Database(entities = [ThronesCharacterDataItem::class], version = 2, exportSchema = false)

abstract class ThronesDatabase : RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao

    companion object {
        @Volatile
        private var INSTANCE: ThronesDatabase? = null

        private val LOCK = Any()   // Ensures there is only a single instance of our database

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            // Everything happening here can't be accessed by other threads at the same time

            INSTANCE?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ThronesDatabase::class.java,
                "thronesdatabase.db"
            ).build()
    }
}