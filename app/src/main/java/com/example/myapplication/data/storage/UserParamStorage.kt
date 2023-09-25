package com.example.myapplication.data.storage

import com.example.myapplication.data.SaveUserParamsParam
import com.example.myapplication.data.UserParams

interface UserParamStorage {

    fun save(user: User): Boolean
    fun get(): User

}