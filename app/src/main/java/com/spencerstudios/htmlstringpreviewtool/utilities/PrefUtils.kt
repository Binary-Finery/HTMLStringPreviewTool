package com.spencerstudios.htmlstringpreviewtool.utilities

import android.content.Context
import android.preference.PreferenceManager

class PrefUtils(ctx : Context) {

    private val prefs = PreferenceManager.getDefaultSharedPreferences(ctx)

    fun setText() : String{
        return prefs.getString("html", "")!!
    }

    fun saveText(s : String){
        prefs.edit().putString("html", s).apply()
    }
}