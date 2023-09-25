package com.example.myapplication.data.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.data.retrofit.NutritionsConverter
import com.example.myapplication.model.FruitListItem

@Database(entities = [FruitListItem::class], version = 1)
@TypeConverters(NutritionsConverter::class)
abstract class DataBase : RoomDatabase() {
    abstract fun fruitListItemDao(): FruitDao
}