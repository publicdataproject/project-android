package com.song2.publicdata_project.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song2.publicdata_project.R
import com.song2.publicdata_project.adapter.Home.CommentAdapter
import com.song2.publicdata_project.adapter.Home.SeasonAdapter
import com.song2.publicdata_project.model.Banner
import com.song2.publicdata_project.model.FarmerWords
import com.song2.publicdata_project.model.SeasonFruits
import com.song2.publicdata_project.network.Network
import com.song2.publicdata_project.network.ServerInterface
import kotlinx.android.synthetic.main.fragment_home.view.*
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val convertView = inflater.inflate(R.layout.fragment_home, container, false)
        var api : ServerInterface? = null
        var bannerList : ArrayList<Banner>?= null
        var farmerList : ArrayList<FarmerWords>?= null
        var seasonList : ArrayList<SeasonFruits>?= null

        with(convertView){
            val commentAdapter =  CommentAdapter(context)
            val seasonAdapter = SeasonAdapter(context)
            val bannerAdapter =  ViewPagerAdapter(childFragmentManager)

            val llm1  = LinearLayoutManager(context)
            llm1.orientation = LinearLayoutManager.HORIZONTAL
            rv_home_fra_comment.layoutManager = llm1
            rv_home_fra_comment.adapter = commentAdapter

            val llm2  = LinearLayoutManager(context)
            rv_home_fra_season.layoutManager = llm2
            rv_home_fra_season.adapter = seasonAdapter

            vp_home_fra_banner.adapter = bannerAdapter

            var messagesCall = api?.homeList()
            messagesCall?.enqueue(object : retrofit2.Callback<Network> {
                override fun onResponse(call: Call<Network>?, response: Response<Network>?) {
                    var network = response!!.body()
                    if (network?.message.equals("ok")) {
                       network.data?.get(0)?.MainDto?.let{
                          if(it.size != 0) {
                              bannerList = it.get(0).bannerDtos
                              farmerList = it.get(0).farmerDtos
                              seasonList = it.get(0).SeasonDtos
                          }
                       }
                    }
                }
                override fun onFailure(call: Call<Network>?, t: Throwable?) {
                    Log.v("test error : ", t.toString())
                }
            })

            if(bannerList?.size != 0){

            }
            if(farmerList?.size != 0){
                farmerList?.let{
                    commentAdapter.addAll(it)
                    commentAdapter.notifyDataSetChanged()
                }
            }
            if(seasonList?.size != 0){
                seasonList?.let{
                    seasonAdapter.addAll(it)
                    seasonAdapter.notifyDataSetChanged()
                }
            }

//            var scrollFlag = 0
//            var page= 1
//
//            sv_home_fra.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
//                override fun onScrollChange(v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
//
//                }
//            })

        }

        return convertView
    }
    override fun onResume() {
        super.onResume()
    }

    inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){
        private val mFragmentList = ArrayList<Fragment>()


        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment) {
            mFragmentList.add(fragment)
        }
    }

}
