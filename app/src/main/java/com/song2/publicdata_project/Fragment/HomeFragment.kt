package com.song2.publicdata_project.Fragment


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
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
import com.song2.publicdata_project.model.Home.FarmerWords
import com.song2.publicdata_project.model.Home.Home
import com.song2.publicdata_project.model.Home.SeasonFruits
import com.song2.publicdata_project.network.Controller
import com.song2.publicdata_project.network.ServerInterface
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(R.layout.fragment_home, container, false)

        val retrofit: Retrofit = Controller.instance!!.retrofit()
        val networkService : ServerInterface = Controller.instance!!.networkService

        var size : Int = 0

        var bannerList : ArrayList<Banner>
        var farmerList : ArrayList<FarmerWords>
        var seasonList : ArrayList<SeasonFruits>

        var commentAdapter : CommentAdapter? = null
        rv_home_fra_comment.adapter = commentAdapter
        val lm = LinearLayoutManager(context)
        rv_home_fra_comment.layoutManager = lm
        rv_home_fra_comment.setHasFixedSize(true)

        var seasonAdapter : SeasonAdapter? = null
        rv_home_fra_season.adapter = seasonAdapter
        val lm2 = LinearLayoutManager(context)
        rv_home_fra_season.layoutManager = lm2
        rv_home_fra_season.setHasFixedSize(true)

        val banner = vp_home_fra_banner
        var bannerAdapter : BannerAdapter? = null
        banner.adapter = bannerAdapter


        networkService.homeList().enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>?, response: Response<Home>?) {
                var network = response!!.body()
                if(network?.status!!.equals(200)){
                    bannerList = network.data?.bannerDtos
                    farmerList = network.data?.farmerDtos
                    seasonList = network.data?.seasonDtos

                    bannerAdapter = BannerAdapter(context!!,bannerList)
                    commentAdapter = CommentAdapter(context!!, farmerList)
                    seasonAdapter = SeasonAdapter(context!!, seasonList)

                    size = bannerList.size
                }
            }

            override fun onFailure(call: Call<Home>?, t: Throwable?) {
                Log.i("error","동신")
            }
        })

        fun init(){
            val handler = Handler()
            val Update = Runnable {
                if (currentPage == size) {
                    currentPage = 0
                }
                mPager!!.setCurrentItem(currentPage++, true)
            }
            val swipeTimer = Timer()
            swipeTimer.schedule(object : TimerTask() {
                override fun run() {
                    handler.post(Update)
                }
            }, 3000, 3000)
        }

        return convertView
    }
    companion object {

        private var mPager: ViewPager? = null
        private var currentPage = 0
    }
}
