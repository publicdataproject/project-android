package com.song2.publicdata_project.network

import retrofit2.Call
import retrofit2.http.GET

interface ServerInterface {

    @GET("/api/main")
    fun homeList(): Call<Network>

}