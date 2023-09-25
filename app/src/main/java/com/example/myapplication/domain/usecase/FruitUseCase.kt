package com.example.myapplication.domain.usecase

import com.example.myapplication.data.domain.DataBase
import com.example.myapplication.data.repository.FruitItemRepository
import com.example.myapplication.data.repository.FruitItemRepositoryRetrofitImpl
import com.example.myapplication.model.FruitListItem
import javax.inject.Inject

//TODO Прочесть разницу между Use Case и Interactors

class FruitUseCase @Inject constructor(private val repository: FruitItemRepository, private val database: DataBase) {

    suspend fun getFruitInfoFromApi(): List<FruitListItem> {
        return repository.getFruitInfo()
    }

    suspend fun saveFruitsToDatabase(fruitsList: List<FruitListItem>) {
        val dao = database.fruitListItemDao()
        dao.insertFruits(fruitsList)
    }

    suspend fun getAllFruitsFromDatabase(): List<FruitListItem> {
        val dao = database.fruitListItemDao()
        return dao.getAllFruits()
    }
}