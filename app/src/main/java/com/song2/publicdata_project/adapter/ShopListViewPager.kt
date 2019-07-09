package com.song2.publicdata_project.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.Data.ShopListData
import com.song2.publicdata_project.R
import com.song2.publicdata_project.ShopIntroActivity

class ShopListViewPager(private val ctx: Context, private val shopListDataList: ArrayList<ShopListData>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.rv_item_shop_list, null)

        var shop_img : ImageView = view.findViewById(R.id.iv_item_shop_img)
        var shop_name : TextView = view.findViewById(R.id.tv_item_shop_name)
        var shop_location : TextView = view.findViewById(R.id.tv_item_shop_location)
        var shop_container : RelativeLayout = view.findViewById(R.id.rl_item_container)

        Glide.with(ctx).load(shopListDataList[position].shop_img).into(shop_img)

        shop_name.text = shopListDataList[position].shop_name
        shop_location.text = shopListDataList[position].shop_location

        var intent = Intent(ctx, ShopIntroActivity::class.java)
        shop_container.setOnClickListener {
            ctx.startActivity(intent)
        }

        container.addView(view)

        return view
    }

    override fun getCount() = shopListDataList.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o as View
    }

    fun transformPage(page: View, position: Float) {
        var normalizedposition = Math.abs(Math.abs(position) - 1)


        page.setScaleX(normalizedposition / 2 + 0.5f)
        page.setScaleY(normalizedposition / 2 + 0.5f)
    }
}