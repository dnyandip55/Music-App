package com.example.musicappnew

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-RapidAPI-Key:4d7b6a7acdmshbd73cefca3a6a41p1d661bjsn247ec080da23",
        "X-RapidAPI-Host:deezerdevs-deezer.p.rapidapi.com")

    @GET("search")
    fun getData(@Query("q") query:String):Call<MyData>
}