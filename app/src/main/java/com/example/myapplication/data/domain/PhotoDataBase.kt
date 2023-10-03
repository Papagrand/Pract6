package com.example.myapplication.data.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.ImageEntity

@Database(entities = [ImageEntity::class], version = 1)
abstract class PhotoDataBase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
}
