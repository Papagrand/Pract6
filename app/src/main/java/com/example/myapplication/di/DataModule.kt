package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.data.repository.UserRepositoryImpl
import com.example.myapplication.data.storage.SharedPrefUserParamStorage
import com.example.myapplication.data.storage.UserParamStorage
import com.example.myapplication.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
//    UserRepositoryImpl(userParamStorage = SharedPrefUserParamStorage(context = context)) }

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideSharedPrefUserParamStorage(@ApplicationContext context: Context): UserParamStorage {
        return SharedPrefUserParamStorage(context = context)
    }
    @Provides
    @Singleton
    fun provideUserRepositoryImpl(userParamStorage: UserParamStorage):UserRepository{
        return UserRepositoryImpl(userParamStorage=userParamStorage)
    }
}