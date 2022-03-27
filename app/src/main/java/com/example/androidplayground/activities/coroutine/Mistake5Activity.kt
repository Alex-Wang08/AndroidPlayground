package com.example.androidplayground.activities.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels

class Mistake5Activity : AppCompatActivity() {

    private val viewModel: Mistake5ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val button = findViewById<Button>(androidx.core.R.id.dialog_button)

//        button.setOnClickListener {
//            lifecycleScope.launch {
//
//                // viewModel should be expose suspending functions to the ui
//                // it will be cancelled when activity is destroyed (config change)
//                viewModel.postValueToApi()
//            }
//        }
        button.setOnClickListener {
            viewModel.postValueToApi()
        }
    }
}