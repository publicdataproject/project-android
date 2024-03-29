package com.song2.publicdata_project.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Controller : Application() {


    private var api: ServerInterface? = null
    val serverInterface: ServerInterface?
        get() {
            api = buildServerInterface()
            return api
        }

    companion object {
        var instance: Controller? = null
        var baseURL =String.format("http://52.78.161.160:8080")
    }

    override fun onCreate() {
        super.onCreate()
        Controller.instance = this
    }

    fun buildServerInterface(): ServerInterface? {

        synchronized(Controller::class.java) {

            if (api == null) {

                val retrofit = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                api = retrofit.create(ServerInterface::class.java)
            }
        }
        return api
    }


//
//    private fun buildNetwork() {
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(baseURL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        networkService = retrofit.create(ServerInterface::class.java)
//    }

}