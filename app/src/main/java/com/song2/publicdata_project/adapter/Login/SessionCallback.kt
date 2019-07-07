package com.song2.publicdata_project.adapter.Login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.kakao.auth.ErrorCode
import com.kakao.auth.ISessionCallback
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.response.model.UserProfile
import com.kakao.util.exception.KakaoException
import com.song2.publicdata_project.MainActivity

open class SessionCallback(val context: Context) : ISessionCallback {
    override fun onSessionOpenFailed(exception: KakaoException?) {
        Log.d("exception", exception.toString())
    }

    override fun onSessionOpened() {
        requestMe()
    }

    fun requestMe() {
        val resCall: MeResponseCallback =
            object : MeResponseCallback() {
                override fun onSuccess(result: UserProfile?) {
                    // 로그인 성공하면 사용자 정보 리턴
                    var nickName = result!!.nickname
                    Log.d("nickName", nickName)

                    val intent = Intent(context, MainActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    context.startActivity(intent)
                    (context as Activity).finish()

                }

                override fun onSessionClosed(errorResult: ErrorResult?) {}

                override fun onNotSignedUp() {}

                override fun onFailure(errorResult: ErrorResult?) {
                    val result = ErrorCode.valueOf(errorResult!!.getErrorCode())
                    if (result === ErrorCode.CLIENT_ERROR_CODE) {
                        //에러로 인한 로그인 실패
                        Log.d("errorResult", errorResult.toString())
                    } else {
                    }
                }
            }
        UserManagement.requestMe(resCall)
    }
}