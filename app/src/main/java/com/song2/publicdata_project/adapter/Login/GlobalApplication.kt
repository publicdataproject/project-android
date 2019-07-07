package com.song2.publicdata_project.adapter.Login

import android.app.Application
import com.kakao.auth.KakaoSDK
import com.kakao.auth.KakaoSDK.init


class GlobalApplication : Application() {
    private var instance: GlobalApplication? = null


    fun getGlobalApplicationContext(): GlobalApplication {

        if (instance == null) {

            throw IllegalStateException("This Application does not inherit com.kakao.GlobalApplication")

        }



        return instance

    }


    override fun onCreate() {

        super.onCreate()

        instance = this


        // Kakao Sdk 초기화

        init(KakaoSDKAdapter())

    }


    override fun onTerminate() {

        super.onTerminate()

        instance = null

    }
}