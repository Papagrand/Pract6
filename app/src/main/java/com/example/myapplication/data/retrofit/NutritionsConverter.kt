package com.example.myapplication.data.retrofit

import androidx.room.TypeConverter
import com.example.myapplication.model.Nutritions
import com.google.gson.Gson

class NutritionsConverter {
    @TypeConverter
    fun fromNutritions(nutritions: Nutritions): String {
        return Gson().toJson(nutritions)
    }

    @TypeConverter
    fun toNutritions(nutritionsString: String): Nutritions {
        return Gson().fromJson(nutritionsString, Nutritions::class.java)
    }
}