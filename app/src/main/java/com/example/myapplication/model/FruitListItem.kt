package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fruits")
data class FruitListItem(
    val family: String,
    val genus: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val nutritions: Nutritions,
    val order: String
)