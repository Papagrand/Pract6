package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.domain.DataBase
import com.example.myapplication.data.domain.FruitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "db").build()
    }

    @Provides
    @Singleton
    fun provideFruitDao(dataBase: DataBase) : FruitDao {
        return dataBase.fruitListItemDao()
    }

}