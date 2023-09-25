package com.example.myapplication.data.repository
import com.example.myapplication.model.FruitListItem
import retrofit2.http.GET

interface FruitItemRepository {
    suspend fun getFruitInfo() : List<FruitListItem>
}