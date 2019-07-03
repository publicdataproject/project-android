package com.song2.publicdata_project.adapter.Home

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.SeasonFruits
import kotlinx.android.synthetic.main.row_home_comment.view.*


class SeasonAdapter(internal var _context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items = ArrayList<SeasonFruits>()//수정

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val convertView = LayoutInflater.from(_context).inflate(R.layout.row_home_season, parent, false)
        return SeasonViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].let { item ->
            with((holder as SeasonAdapter.SeasonViewHolder).itemView) {
                tv_home_comment.text = items[position].fruitsName
                iv_home_comment?.setImageURI(Uri.parse(items[position].fruitImage))

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun clear(){
        this.items.clear()
    }

    fun addAll(contents: java.util.ArrayList<SeasonFruits>) {
        this.items.addAll(contents)
    }
    private inner class SeasonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}