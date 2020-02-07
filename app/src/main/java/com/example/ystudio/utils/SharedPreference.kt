package com.example.ystudio.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(val context: Context) {
    private val PRESS_NAME = "YStudio"
    val sharedPref: SharedPreferences = context.getSharedPreferences(PRESS_NAME,Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, stringValue:String)
    {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_NAME,stringValue)
        editor!!.commit()
    }
    fun save(KEY_NAME: String, intValue:Int)
    {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(KEY_NAME,intValue)
        editor!!.commit()
    }
    fun save(KEY_NAME: String, boolValue:Boolean)
    {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(KEY_NAME,boolValue)
        editor!!.commit()
    }
    fun getValueString(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, null)
    }

    fun getValueInt(KEY_NAME: String): Int {
        return sharedPref.getInt(KEY_NAME, 0)
    }

    fun getValueBoolien(KEY_NAME: String, defaultValue: Boolean): Boolean {
        return sharedPref.getBoolean(KEY_NAME, defaultValue)
    }
    fun clearSharedPreference() {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.commit()
    }
    fun removeValue(KEY_NAME: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.remove(KEY_NAME)
        editor.commit()
    }
}