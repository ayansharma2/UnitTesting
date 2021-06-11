package com.ayan.unittesting

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient() {

    companion object {
        private var instance:RetrofitApi?=null


        fun getInstance():RetrofitApi{
            if(instance==null){
                instance=Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(Constants.url)
                        .build().create(RetrofitApi::class.java)

            }
            return instance as RetrofitApi
        }
    }
}