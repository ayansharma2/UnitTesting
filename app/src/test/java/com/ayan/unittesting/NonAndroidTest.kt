package com.ayan.unittesting

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NonAndroidTest{

    @Test
    fun checkEmptyInputs(){
        var result=NonAndroid.login("","","")
        assertThat(result).isFalse()
    }

    @Test
    fun checkPasswordAndConfirmPassword(){
        var result=NonAndroid.login("Ayan","asda","as")
        assertThat(result).isFalse()
    }

    @Test
    fun checkDigitsInPassword(){
        var result=NonAndroid.login("Ayan","assd","assd")
        assertThat(result).isFalse()
    }

    @Test
    fun checkLogin(){
        var result=NonAndroid.login("Ayan","Password123","Password123")
        assertThat(result).isTrue()
    }
}