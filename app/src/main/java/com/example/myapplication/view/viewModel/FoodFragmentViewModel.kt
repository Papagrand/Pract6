package com.example.myapplication.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecase.FruitUseCase
import com.example.myapplication.model.FruitListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodFragmentViewModel @Inject constructor(private val useCase: FruitUseCase) : ViewModel() {

    private val _fruitsList = MutableLiveData<List<FruitListItem>>()
    val fruitsList: LiveData<List<FruitListItem>> get() = _fruitsList

    fun getFruitInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            _fruitsList.postValue(useCase.getFruitInfoFromApi())
            useCase.saveFruitsToDatabase(_fruitsList.value ?: listOf())
        }
    }

    suspend fun getAllFruitsFromDatabase(): List<FruitListItem> {
        return useCase.getAllFruitsFromDatabase()
    }
}
