package com.song2.publicdata_project.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kakao.auth.Session
import com.song2.publicdata_project.R
import com.song2.publicdata_project.adapter.Login.SessionCallback

class LoginActivity : AppCompatActivity() {

    private lateinit var sessionCallback: SessionCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 카카오톡 로그인
        sessionCallback = SessionCallback(this)
        Session.getCurrentSession().addCallback(sessionCallback)
        Session.getCurrentSession().checkAndImplicitOpen()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // 추가
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}