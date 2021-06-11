package com.ayan.unittesting

import android.content.Intent
import android.util.Log
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import okio.Buffer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.w3c.dom.Text

@RunWith(AndroidJUnit4::class)
class NonAndroidTest  {

    @get: Rule
    val activityRule= ActivityTestRule(MainActivity::class.java, true, false)
    lateinit var server: MockWebServer

    @Before
    fun setup(){
        server= MockWebServer()
        server.start()
        Constants.url=server.url("/").toString()
    }

    @After
    fun trash(){
        server.shutdown()
        activityRule.finishActivity()
    }

    @Test
    fun checkCorrectData(){
        server.enqueue(
                MockResponse()
                        .setResponseCode(200)
                        .setBody("true")
        )
        val intent=Intent()
        activityRule.launchActivity(intent)
        val value= activityRule.activity.findViewById<TextView>(R.id.tv).text.toString()
        Log.i("Valueis",value)
        assertThat(value == "Hi").isTrue()
        //activityRule.finishActivity()

    }


    fun byteArrayOfInts(vararg ints: Int) = ByteArray(ints.size) { pos -> ints[pos].toByte() }
    @Test
    fun checkWrongData(){
        server.enqueue(MockResponse()
                .setBody(Buffer().write(byteArrayOfInts(0xA1, 0x2E, 0x38, 0xD4, 0x89, 0xC3)))
                .setSocketPolicy(SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY))
        val intent=Intent()
        activityRule.launchActivity(intent)
        val value= activityRule.activity.findViewById<TextView>(R.id.tv).text.toString()
       // Log.i("Valueis",value)
        assertThat(value == "Error").isTrue()
    }


//
//    @Test
//    fun checkEmptyInputs(){
//        var result=NonAndroid.login("", "", "")
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun checkPasswordAndConfirmPassword(){
//        var result=NonAndroid.login("Ayan", "asda", "as")
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun checkDigitsInPassword(){
//        var result=NonAndroid.login("Ayan", "assd", "assd")
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun checkLogin(){
//        var result=NonAndroid.login("Ayan", "Password123", "Password123")
//        assertThat(result).isTrue()
//    }
//
//
//    @Test
//    fun checkRetrofit(){
//
//    }
}