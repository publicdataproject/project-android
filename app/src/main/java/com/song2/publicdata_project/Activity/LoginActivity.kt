package com.song2.publicdata_project.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kakao.auth.ISessionCallback
import com.song2.publicdata_project.R
import java.lang.reflect.Modifier

class LoginActivity : AppCompatActivity() {

    private val call : SessionCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    inner class SessionCallbaack : ISessionCallback{
        override fun onSessionOpened() {
            r
        }

    fun redirectSignupActivity(){
        val intent : Intent = Intent(this.)
    }
}