package com.example.myapplication.domain.usecase

import com.example.myapplication.data.SaveUserParamsParam
import com.example.myapplication.domain.repository.UserRepository
import javax.inject.Inject

class SaveParamsUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(newParam: SaveUserParamsParam) =
        if (userRepository.getParams().weight == newParam.weight) true else userRepository.saveParams(
            saveParam = newParam
        )

}