package com.example.myapplication.data.storage

import android.content.Context
import com.example.myapplication.data.SaveUserParamsParam
import com.example.myapplication.data.UserParams
import javax.inject.Inject

private const val SHARED_PREFS_PARAM = "shared_prefs_param"
private const val KEY_WEIGHT = "weight"
private const val KEY_HEIGHT = "height"
private const val KEY_AGE = "age"

class SharedPrefUserParamStorage @Inject constructor(context: Context) : UserParamStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_PARAM,Context.MODE_PRIVATE)


    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_WEIGHT, user.weight).apply()
        sharedPreferences.edit().putString(KEY_HEIGHT, user.height).apply()
        sharedPreferences.edit().putString(KEY_AGE,user.age).apply()
        return true
    }

    override fun get(): User {
        val weight = sharedPreferences.getString(KEY_WEIGHT, "") ?:""
        val height = sharedPreferences.getString(KEY_HEIGHT, "") ?:""
        val age = sharedPreferences.getString(KEY_AGE, "") ?:""

        return User(weight = weight, height = height, age = age)
    }
}