package com.song2.publicdata_project.network

import com.song2.publicdata_project.model.Home.Home
import com.song2.publicdata_project.model.Mypage.Mypage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServerInterface {

//    @Headers("Content-Type: application/json")
    @GET("/api/main")
    fun homeList(): Call<Home>


//    @Headers("Content-Type: application/json")
    @GET("/api/mypage/{id}")
    fun mypageList(@Path("id") id:Int) : Call<Mypage>

}