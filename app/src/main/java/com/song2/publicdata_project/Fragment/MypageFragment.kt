package com.song2.publicdata_project.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Mypage.Mypage
import com.song2.publicdata_project.network.Controller
import com.song2.publicdata_project.network.ServerInterface
import kotlinx.android.synthetic.main.fragment_mypage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageFragment : Fragment() {
    var networkService: ServerInterface? = Controller.instance?.buildServerInterface()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(R.layout.fragment_mypage, container, false)

        getMypage()

        return convertView
    }

    private fun getMypage() {
        var api = networkService?.mypageList(1)

        api?.enqueue(object : Callback<Mypage> {
            override fun onResponse(call: Call<Mypage>?, response: Response<Mypage>?) {
                var network = response!!.body()

                network.data.let {
                    if (it != null) {
                        tv_mypage_name.text = it.name+"님의 포인트"
                        tv_mypage_point.text = it.point.toString()

                        if(it.visitMarketDtos == null){
                            showHide(btn_mypage_others,true)
                            showHide(rv_mypage_shoplist,false)
                            showHide(fl_mypage_empty,true)
                        }else{
                            showHide(btn_mypage_others,false)
                            showHide(rv_mypage_shoplist,true)
                            showHide(fl_mypage_empty,false)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Mypage>?, t: Throwable?) {

            }
        })
    }

    

    fun showHide(view:View,visibility : Boolean){
        if(visibility){
            view.visibility = View.VISIBLE
        }else{
            view.visibility = View.INVISIBLE
        }
    }
}
