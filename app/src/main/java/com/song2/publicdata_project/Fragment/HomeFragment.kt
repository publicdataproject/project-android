package com.song2.publicdata_project.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song2.publicdata_project.R
import com.song2.publicdata_project.adapter.Home.BannerAdapter
import com.song2.publicdata_project.adapter.Home.CommentAdapter
import com.song2.publicdata_project.adapter.Home.SeasonAdapter
import com.song2.publicdata_project.model.Home.Banner
import com.song2.publicdata_project.model.Home.Home
import com.song2.publicdata_project.network.Controller
import com.song2.publicdata_project.network.ServerInterface
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(R.layout.fragment_home, container, false)
        //val retrofit: Retrofit = Controller.instance!!.retrofit()
        var networkService : ServerInterface? = Controller.instance?.buildServerInterface()
        var api = networkService?.homeList()

        var bannerList : ArrayList<Banner> ?= null
//        var seasonList : ArrayList<SeasonFruits> ? = null
//        var farmerList : ArrayList<FarmerWords> ?= null

        lateinit var commentAdapter : CommentAdapter
        rv_home_fra_comment?.adapter = commentAdapter
        val lm : LinearLayoutManager = LinearLayoutManager(activity)
        lm.orientation = LinearLayoutManager.HORIZONTAL
        rv_home_fra_comment.layoutManager = lm
        rv_home_fra_comment.setHasFixedSize(true)

        lateinit var seasonAdapter : SeasonAdapter
        rv_home_fra_season?.adapter = seasonAdapter
        val lm2 : LinearLayoutManager = LinearLayoutManager(activity)
        lm2.orientation = LinearLayoutManager.HORIZONTAL
        rv_home_fra_season.layoutManager = lm2
        rv_home_fra_season.setHasFixedSize(true)

//        val banner = vp_home_fra_banner

        lateinit var bannerAdapter : BannerAdapter
        vp_home_fra_banner?.adapter = bannerAdapter


        api?.enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>?, response: Response<Home>?) {
                var network = response!!.body()
//                if(network?.status!!.equals(200)){
                    network.data.farmerDtos.let{
                        if(it.size!=0){
                            commentAdapter.addAll(it)
                            commentAdapter.notifyDataSetChanged()
                        }
                    }

                    network.data.seasonDtos.let{
                        if(it.size != 0){
                            seasonAdapter.addAll(it)
                            seasonAdapter.notifyDataSetChanged()
                        }
                    }

                    network.data.bannerDtos.let{
                        if(it.size !=0){
                            bannerList = it
                            bannerAdapter.bannerList = it

                        }
                    }
//                }
            }

            override fun onFailure(call: Call<Home>?, t: Throwable?) {
                Log.i("error","동신")
            }
        })
//
//        fun init(){
//            val handler = Handler()
//            val Update = Runnable {
//                if (currentPage == size) {
//                    currentPage = 0
//                }
//                mPager!!.setCurrentItem(currentPage++, true)
//            }
//            val swipeTimer = Timer()
//            swipeTimer.schedule(object : TimerTask() {
//                override fun run() {
//                    handler.post(Update)
//                }
//            }, 3000, 3000)
//        }

        return convertView
    }


}
