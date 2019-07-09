package com.song2.publicdata_project.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import java.util.*
import kotlin.collections.ArrayList




class HomeFragment : Fragment() {

    var timer = Timer()

    lateinit var commentAdapter: CommentAdapter
    lateinit var seasonAdapter: SeasonAdapter
    lateinit var bannerAdapter: BannerAdapter

    lateinit var bannerData : ArrayList<Banner>

    val commentData = ArrayList<FarmerWords>()

    val seasonData = ArrayList<SeasonFruits>()


    var networkService: ServerInterface? = Controller.instance?.buildServerInterface()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(com.song2.publicdata_project.R.layout.fragment_home, container, false)
        getHome()
        return convertView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //val retrofit: Retrofit = Controller.instance!!.retrofit()

//        val banner = vp_home_fra_banner

//        vp_home_fra_banner.adapter = bannerAdapter

        seasonAdapter = SeasonAdapter(this.context!!, seasonData)
        rv_home_fra_season.adapter = seasonAdapter
        rv_home_fra_season.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)

        commentAdapter = CommentAdapter(this.context!!, commentData)
        rv_home_fra_comment.adapter = commentAdapter
        rv_home_fra_comment.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)


        val timerTask = object : TimerTask() {
            override fun run() {
                vp_home_fra_banner.post(Runnable { vp_home_fra_banner.setCurrentItem((vp_home_fra_banner.getCurrentItem() + 1) % bannerData.size) })
            }
        }

        timer.schedule(timerTask,3000,3000)
    }


    private fun getHome() {
        var api = networkService?.homeList()
        api?.enqueue(object : Callback<Home> {
            override fun onResponse(call: Call<Home>?, response: Response<Home>?) {

                var network = response!!.body()
//                if(network?.status!!.equals(200)){
                network.data.farmerDtos.let {
                    if (it.size > 0) {
                        var position = commentAdapter.itemCount
                        commentAdapter.dataList.addAll(network.data.farmerDtos)
                        commentAdapter.notifyItemInserted(position)
                    }
                }

                network.data.seasonDtos.let {
                    if (it.size > 0) {
                        var position = seasonAdapter.itemCount
                        seasonAdapter.dataList.addAll(network.data.seasonDtos)
                        seasonAdapter.notifyItemInserted(position)
                    }
                }

                network.data.bannerDtos.let {
                    if (it.size > 0) {
                        bannerData = it
                        bannerAdapter = BannerAdapter(context!!.applicationContext, it, true)
                        vp_home_fra_banner.adapter = bannerAdapter
                        indicator_home_fra_banner.setViewPager(vp_home_fra_banner)
                        bannerAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<Home>?, t: Throwable?) {
                Log.i("error", "동신")

            }
        })
    }

}
