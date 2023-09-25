package com.example.myapplication.view.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.SaveUserParamsParam
import com.example.myapplication.data.repository.UserRepositoryImpl
import com.example.myapplication.data.storage.SharedPrefUserParamStorage
import com.example.myapplication.domain.usecase.GetParamsUseCase
import com.example.myapplication.domain.usecase.SaveParamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor(private val getParamsUseCase: GetParamsUseCase, private val saveParamsUseCase: SaveParamsUseCase): ViewModel() {



    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()

    }

    fun save(textWeight: String, textHeight: String, textAge: String): Boolean{

        val params = SaveUserParamsParam(
            weight = textWeight,
            height = textHeight,
            age = textAge)
        val result: Boolean = saveParamsUseCase.execute(param = params)
        return result
    }



}