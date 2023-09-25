package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Controller {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.fragment_container,firstFragment)
//            .commit()
    }

    override fun navigate(view: View) {
//        when(view.id){
//            R.id.firstFragmentButton ->supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container, firstFragment)
//                .addToBackStack(null)
//                .commit()
//            R.id.secondFragmentButton ->supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container, secFragment)
//                .addToBackStack(null)
//                .commit()
//        }
    }

}