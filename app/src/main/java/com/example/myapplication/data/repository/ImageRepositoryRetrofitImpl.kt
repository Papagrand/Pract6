package com.example.myapplication.data.repository

import com.example.myapplication.data.domain.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ImageRepositoryRetrofitImpl {
    @GET
    suspend fun downloadImage(@Url imageUrl: String): Response<ImageResponse>
}