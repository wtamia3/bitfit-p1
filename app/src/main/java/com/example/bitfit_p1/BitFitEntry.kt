package com.example.bitfit_p1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entries")
data class BitFitEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val metricType: String,    // e.g., "Calories", "Exercise"
    val value: String,         // e.g., "2000 kcal", "1 hour"
    val date: String           // e.g., "2024-11-13"
)
