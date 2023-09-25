package com.example.myapplication.di

import com.example.myapplication.data.domain.DataBase
import com.example.myapplication.data.repository.FruitItemRepository
import com.example.myapplication.data.repository.FruitItemRepositoryRetrofitImpl
import com.example.myapplication.data.repository.UserRepositoryImpl
import com.example.myapplication.domain.repository.UserRepository
import com.example.myapplication.domain.usecase.FruitUseCase
import com.example.myapplication.domain.usecase.GetParamsUseCase
import com.example.myapplication.domain.usecase.SaveParamsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetParamsUseCase(userRepository: UserRepositoryImpl): GetParamsUseCase {
        return GetParamsUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveParamsUseCase(userRepository: UserRepositoryImpl): SaveParamsUseCase {
        return SaveParamsUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideFruitUseCase(repository: FruitItemRepositoryRetrofitImpl, database: DataBase): FruitUseCase {
        return FruitUseCase(repository = repository, database = database)
    }
}