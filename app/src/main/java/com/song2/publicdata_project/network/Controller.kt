package com.song2.publicdata_project.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Controller : Application() {

    private val baseURL = "http://52.78.161.160:8080"
    var networkService : ServerInterface = retrofit().create(ServerInterface::class.java)

    companion object {
        lateinit var instance: Controller
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun retrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


//
//    private fun buildNetwork() {
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        networkService = retrofit.create(ServerInterface::class.java)
//    }

}