package com.song2.publicdata_project.Fragment.Home

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Banner
import kotlinx.android.synthetic.main.home_fragment_banner.view.*

class BannerFragment : Fragment() {

    private var banner : Banner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            banner = arguments!!.getSerializable("contents") as Banner
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val convertView = inflater.inflate(R.layout.home_fragment_banner, container, false)

        with(convertView){
            Glide.with(context).load(Uri.parse(banner?.bannerImage)).into(iv_home_banner)

        }

        return convertView
    }

    companion object {

        fun newInstance(param1: Banner): BannerFragment {
            val fragment = BannerFragment()
            val args = Bundle()
            args.putSerializable("contents", param1)
            fragment.arguments = args
            return fragment
        }
    }


}