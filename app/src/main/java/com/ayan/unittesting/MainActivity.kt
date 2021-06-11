package com.ayan.unittesting

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val androidTest=AndroidTest()
        tv=findViewById(R.id.tv)
        getData()
    }

    private fun getData() {
        val request=RetrofitClient.getInstance().getValue()
        request.enqueue(object :Callback<Boolean>{
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                tv.text="Hi"
                Log.i("Data","Received")
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                tv.text="Error"
                Log.i("Error","Received")
            }

        })
    }


}