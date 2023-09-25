package com.example.myapplication.data.retrofit

import com.example.myapplication.model.FruitListItem
import retrofit2.Call

interface FruitApi {
    fun getFruitInfo() : Call<FruitListItem>
}