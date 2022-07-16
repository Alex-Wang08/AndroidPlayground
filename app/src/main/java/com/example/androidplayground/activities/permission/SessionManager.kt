package com.example.androidplayground.activities.permission

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SessionManager(context: Context) {
    companion object {
        private const val MY_PREF = "android_playground_preference"
    }

    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor


    init {
        sharedPreferences = context.getSharedPreferences(MY_PREF, MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }


    fun firstTimeAsking(permission: String, isFirstTime: Boolean) {
        editor.putBoolean(permission, isFirstTime)
    }

    fun isFirstTimeAsking(permission: String): Boolean {
        return sharedPreferences.getBoolean(permission, true)
    }


}

