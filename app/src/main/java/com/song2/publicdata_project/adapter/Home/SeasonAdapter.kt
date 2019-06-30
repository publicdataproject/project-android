package com.song2.publicdata_project.adapter.Home

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater


class SeasonAdapter(internal var _context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items = ArrayList<Content>()//수정

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val convertView = LayoutInflater.from(_context).inflate(R.layout.row_contents_simple, parent, false)
        return NowTrendViewHolder(convertView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun clear(){
        this.items.clear()
    }

    fun addAll(contents: java.util.ArrayList<Content>) {
        this.items.addAll(contents)
    }
    private inner class NowTrendViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}