package com.example.myapplication.view.viewModelFactory
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.myapplication.domain.usecase.FruitUseCase
//import com.example.myapplication.view.viewModel.FoodFragmentViewModel
//
//class FoodFragmentViewModelFactory(private val useCase: FruitUseCase) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(FoodFragmentViewModel::class.java)) {
//            return FoodFragmentViewModel(useCase) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}