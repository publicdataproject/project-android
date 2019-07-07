package com.song2.publicdata_project.network

import android.net.Network
import com.song2.publicdata_project.model.Home.Home
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ServerInterface {

    @Headers("Content-Type: application/json")
    @GET("/api/main/")
    fun homeList(): Call<Home>


    @Headers("Content-Type: application/json")
    @GET("/api/mypage/{id}")
    fun mypageList() : Call<Network>

}