package com.song2.publicdata_project.adapter.Home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Home.FarmerWords

class CommentAdapter(val _context: Context, val dataList : ArrayList<FarmerWords>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val convertView = LayoutInflater.from(_context).inflate(R.layout.row_home_comment, parent, false)
        return CommentViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(dataList[position].farmerImage)
            .into(holder.commentImage)

        holder.commentText.text = dataList[position].content
    }

    override fun getItemCount(): Int = dataList.size


    inner class CommentViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        var commentImage: ImageView = view?.findViewById(R.id.iv_home_comment) as ImageView
        var commentText: TextView = view?.findViewById(R.id.tv_home_comment) as TextView


    }

}

