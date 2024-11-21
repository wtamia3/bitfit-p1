package com.example.bitfit_p1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BitFitEntry::class], version = 1)
abstract class BitFitDatabase : RoomDatabase() {
    abstract fun bitFitDao(): BitFitDao

    companion object {
        @Volatile
        private var INSTANCE: BitFitDatabase? = null

        fun getDatabase(context: Context): BitFitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BitFitDatabase::class.java,
                    "bitfit_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
