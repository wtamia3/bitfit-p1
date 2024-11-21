package com.example.bitfit_p1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BitFitDao {
    @Insert
    suspend fun insertEntry(entry: BitFitEntry)

    @Query("SELECT * FROM entries ORDER BY id DESC")
    suspend fun getAllEntries(): List<BitFitEntry>
}
