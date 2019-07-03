package com.song2.publicdata_project.network

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Controller : Application() {

    private var api : ServerInterface? = null

    val serverInterface: ServerInterface?
        get() {
            api = buildServerInterface()
            return api
        }

    override fun onCreate() {
        super.onCreate()
        Controller.instance = this
        Realm.init(applicationContext)
        val realmCOnfiguration = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(realmCOnfiguration)

    }

    fun buildServerInterface(): ServerInterface? {

        synchronized(Controller::class.java) {

            if (api == null) {

                val retrofit = Retrofit.Builder()
                    .baseUrl(endpoint)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                api = retrofit.create(ServerInterface::class.java)
            }
        }
        return api
    }


    companion object {

        var instance: Controller? = null
            private set
        var endpoint = String.format("http://52.78.161.160:8080")

        fun bannerUrl(Idx : Int) = "https://data-project1.s3.ap-northeast-2.amazonaws.com/img_banner_${Idx}_1280x506.png"

        fun farmerlUrl(Idx: Int) = "https://data-project1.s3.ap-northeast-2.amazonaws.com/farmer${Idx}.png\""

        fun fruitUrl(Idx: Int) = "https://data-project1.s3.ap-northeast-2.amazonaws.com/season${Idx}.png"

    }

}