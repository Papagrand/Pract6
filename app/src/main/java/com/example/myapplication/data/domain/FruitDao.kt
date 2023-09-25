package com.example.myapplication.data.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.FruitListItem

@Dao
interface FruitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFruits(fruits: List<FruitListItem>)

    @Query("SELECT * FROM fruits")
    suspend fun getAllFruits(): List<FruitListItem>
}