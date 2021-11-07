package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {
    private val mSharedPreferences = context.getSharedPreferences(MotivationConstants.KEY.PERSON_NAME, Context.MODE_PRIVATE)

    //armazena uma chave valor: String
    fun storeString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    // recupera os dados
    fun getString(key: String) : String{
        return mSharedPreferences.getString(key, "") ?: ""
    }
}