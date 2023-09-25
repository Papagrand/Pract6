package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.data.repository.FruitItemRepository
import com.example.myapplication.data.repository.FruitItemRepositoryRetrofitImpl
import com.example.myapplication.data.repository.UserRepositoryImpl
import com.example.myapplication.data.storage.SharedPrefUserParamStorage
import com.example.myapplication.data.storage.UserParamStorage
import com.example.myapplication.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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
    fun provideUserRepositoryImpl(userParamStorage: UserParamStorage): UserRepository {
        return UserRepositoryImpl(userParamStorage = userParamStorage)
    }

    @Provides
    @Singleton
    fun provideFruitItemRepository(client: Retrofit): FruitItemRepository {
        return client.create(FruitItemRepositoryRetrofitImpl::class.java)
    }

    @Provides
    @Singleton
    fun provideFruitClientRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}