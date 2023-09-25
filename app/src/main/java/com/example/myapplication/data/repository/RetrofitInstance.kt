package com.example.myapplication.data.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://www.fruityvice.com/"

    fun create(): FruitItemRepositoryRetrofitImpl {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitItemRepositoryRetrofitImpl::class.java)
    }

}