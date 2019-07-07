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

class CommentAdapter(val _context: Context, var items: ArrayList<FarmerWords>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val convertView = LayoutInflater.from(_context).inflate(R.layout.row_home_comment, parent, false)
        return CommentViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder?.bind(items[position],_context)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun RecyclerView.ViewHolder.bind(comment: FarmerWords, _context: Context) {
        itemView?.tv_home_comment.text = comment.content
        val img : ImageView = itemView?.iv_home_comment
        Glide.with(_context).load(comment.farmerImage).into(img)
    }

    inner class CommentViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        fun bind (comment : FarmerWords, context : Context){
            itemView?.tv_home_comment.text = comment.content
            val img : ImageView = itemView?.iv_home_comment
            Glide.with(_context).load(comment.farmerImage).into(img)
        }

    }
}


