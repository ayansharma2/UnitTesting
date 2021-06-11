package com.ayan.unittesting

import android.content.Context
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class AndroidTest {

    fun checkName(context: Context, name:String):Boolean{
        if(name.equals(R.string.app_name))
            return true
        return false
    }

    fun getInternetData(retrofitApi: RetrofitApi){
        val request=retrofitApi.getValue()
        request.enqueue(object : retrofit2.Callback<Boolean>{
            override fun onResponse(call: Call<Boolean>?, response: Response<Boolean>?) {
                var data=response?.body()
            }

            override fun onFailure(call: Call<Boolean>?, t: Throwable?) {
                Log.i("Error connecting Server","Error")
            }

        })
    }
}