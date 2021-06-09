package com.ayan.unittesting

import android.content.Context

class AndroidTest {

    fun checkName(context: Context, name:String):Boolean{
        if(name.equals(R.string.app_name))
            return true
        return false
    }
}