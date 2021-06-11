package com.ayan.unittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import retrofit2.Response
import retrofit2.Retrofit


class AndroidTestTest{

//    @Rule
//    val activityRule=ActivityTestRule
//    fun init(){
//
//        //retrofitApi=RetrofitClient.getInstance()
//    }

//    @After
//    fun trash(){
//        androidTest=null
//    }
//    @Test
//    fun checkWrongName(){
//        val context=ApplicationProvider.getApplicationContext<Context>()
//        val result= androidTest?.checkName(context, "Hello")
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun checkCorrectName(){
//        val context=ApplicationProvider.getApplicationContext<Context>()
//        val result= androidTest?.checkName(context, "app_name")
//        assertThat(result).isFalse()
//    }


//    @Test
//    fun connectToInternet(){
//
//        val mockWebServer= MockWebServer()
//        mockWebServer.start()
//        val retrofit=Retrofit.Builder()
//            .baseUrl(mockWebServer.url("").toString())
//            .build()
//        mockWebServer.enqueue(MockResponse().setBody("true"))
//        retrofitApi=retrofit.create(RetrofitApi::class.java)
//        val temp=retrofitApi.getData()
//        assertThat(temp!=null)
//        //`when`(retrofitApi.getData().execute()).thenReturn(Response.success(temp))
//        //verify(retrofitApi.getData().isExecuted)
//    }
}