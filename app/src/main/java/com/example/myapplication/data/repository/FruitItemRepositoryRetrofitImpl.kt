package com.example.myapplication.data.repository

import com.example.myapplication.model.FruitListItem
import retrofit2.http.GET

interface FruitItemRepositoryRetrofitImpl: FruitItemRepository {
    @GET("api/fruit/all")
    override suspend fun getFruitInfo(): List<FruitListItem>
}