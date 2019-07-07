package com.song2.publicdata_project.adapter.Login

import android.app.Activity
import android.app.Application
import com.kakao.auth.KakaoSDK


class GlobalApplication: Application() {

    companion object {
        var obj: GlobalApplication? = null
        var currentActivity: Activity? = null
    }

    override fun onCreate() {
        super.onCreate()
        obj = this
        KakaoSDK.init(KakaoSDKAdapter())
    }

    public fun getGlobalApplicationContext():GlobalApplication{
        return obj!!
    }

    public fun getCurrentActivity():Activity{
        return currentActivity!!
    }

    public fun setCurrentActivity(currentActivity:Activity){
        GlobalApplication.currentActivity = currentActivity
    }
}