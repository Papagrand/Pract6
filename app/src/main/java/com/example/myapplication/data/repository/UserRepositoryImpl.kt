package com.example.myapplication.data.repository

import android.content.Context
import com.example.myapplication.data.SaveUserParamsParam
import com.example.myapplication.data.UserParams
import com.example.myapplication.data.storage.User
import com.example.myapplication.data.storage.UserParamStorage
import com.example.myapplication.domain.repository.UserRepository
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(private val userParamStorage: UserParamStorage) : UserRepository {


    override fun saveParams(saveParam: SaveUserParamsParam): Boolean{

        val user = User(weight = saveParam.weight, height = saveParam.height, age = saveParam.age)

        return userParamStorage.save(user)
    }
    override fun getParams(): UserParams {
        val user = userParamStorage.get()
        val userParams = UserParams(weight = user.weight, height = user.height, age = user.age)
        return userParams
    }
}