package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.UserRepositoryImpl
import com.example.myapplication.data.SaveUserParamsParam
import com.example.myapplication.domain.repository.UserRepository
import javax.inject.Inject

class SaveParamsUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(param: SaveUserParamsParam): Boolean{
        val oldUserParams = userRepository.getParams()

        if(oldUserParams.weight == param.weight){
            return true
        }

        val result: Boolean = userRepository.saveParams(saveParam = param)
        return result

    }
}