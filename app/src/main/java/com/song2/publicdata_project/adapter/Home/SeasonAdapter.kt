package com.song2.publicdata_project.adapter.Home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Home.SeasonFruits
import kotlinx.android.synthetic.main.row_home_season.view.*


class SeasonAdapter(val _context: Context, var items: ArrayList<SeasonFruits>) : RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val convertView = LayoutInflater.from(_context).inflate(R.layout.row_home_season, parent, false)
        return SeasonViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        holder?.bind(items,position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addAll(season : java.util.ArrayList<SeasonFruits>){
        this.items.addAll(season)
    }

    inner class SeasonViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        fun bind (season : ArrayList<SeasonFruits>, position: Int){
            itemView?.tv_home_season.text = season[position].fruitsName
            val img : ImageView = itemView?.iv_home_season
            Glide.with(_context).load(season[position].fruitImage).into(img)
        }

    }
}