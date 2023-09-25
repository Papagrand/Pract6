package com.example.myapplication.domain.usecase

import com.example.myapplication.data.UserParams
import com.example.myapplication.domain.repository.UserRepository
import javax.inject.Inject

class GetParamsUseCase @Inject constructor(private val userRepository: UserRepository) {
    fun execute(): UserParams {
        return userRepository.getParams()
    }
}