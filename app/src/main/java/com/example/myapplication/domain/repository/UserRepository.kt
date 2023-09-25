package com.example.myapplication.domain.repository

import com.example.myapplication.data.SaveUserParamsParam
import com.example.myapplication.data.UserParams

interface UserRepository {
    fun saveParams(saveParam: SaveUserParamsParam):Boolean
    fun getParams(): UserParams
}