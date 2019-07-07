package com.song2.publicdata_project.adapter.Home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.song2.publicdata_project.R
import com.song2.publicdata_project.model.Home.FarmerWords
import kotlinx.android.synthetic.main.row_home_comment.view.*

class CommentAdapter(val _context: Context) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    var items = ArrayList<FarmerWords>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val convertView = LayoutInflater.from(_context).inflate(R.layout.row_home_comment, parent, false)
        return CommentViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder?.bind(items,position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addAll(comment : java.util.ArrayList<FarmerWords>){
        this.addAll(comment)
    }

    inner class CommentViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        fun bind (comment : ArrayList<FarmerWords>, position: Int){
            itemView?.tv_home_comment.text = comment[position].content
            val img : ImageView = itemView?.iv_home_comment
            Glide.with(_context).load(comment[position].farmerImage).into(img)
        }

    }
}


