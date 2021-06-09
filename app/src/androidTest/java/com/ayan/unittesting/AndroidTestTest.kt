package com.ayan.unittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class AndroidTestTest{

    private var androidTest: AndroidTest? =null

    @Before
    fun init(){
        androidTest= AndroidTest()
    }

    @After
    fun trash(){
        androidTest=null
    }
    @Test
    fun checkWrongName(){
        val context=ApplicationProvider.getApplicationContext<Context>()
        val result= androidTest?.checkName(context,"Hello")
        assertThat(result).isFalse()
    }

    @Test
    fun checkCorrectName(){
        val context=ApplicationProvider.getApplicationContext<Context>()
        val result= androidTest?.checkName(context,"app_name")
        assertThat(result).isFalse()
    }

}