package com.song2.publicdata_project.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.Data.ShopProductData
import com.song2.publicdata_project.R
import com.song2.publicdata_project.ShopIntroActivity

class ProductListRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<ShopProductData>) : RecyclerView.Adapter<ProductListRecyclerViewAdapter.Holder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.item_product_list, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        Glide.with(ctx)
            .load(dataList[position].product_img)
            .into(holder.product_img)
        holder.product_name.text = dataList[position].product_name
        holder.product_price.text = dataList[position].product_price
        holder.product_cnt.text = dataList[position].product_cnt.toString()

        var intent = Intent(ctx, ShopIntroActivity::class.java)
        holder.container.setOnClickListener {
            ctx.startActivity(intent)
        }

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.rl_product_container) as RelativeLayout
        var product_img  = itemView.findViewById(R.id.iv_product_list_item_img) as ImageView
        var product_name = itemView.findViewById(R.id.tv_product_list_item_name) as TextView
        var product_price = itemView.findViewById(R.id.tv_product_list_item_price) as TextView
        var product_cnt = itemView.findViewById(R.id.tv_product_list_item_cnt) as TextView
    }
}