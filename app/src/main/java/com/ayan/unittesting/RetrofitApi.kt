package com.ayan.unittesting

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET(".")
    fun getValue() : Call<Boolean>
}