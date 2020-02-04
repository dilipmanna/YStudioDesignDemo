package com.example.ystudio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ystudio.R

class VideoListAdapter : RecyclerView.Adapter<VideoListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.videolist_item,parent,false)
        return MyViewHolder(view)
    }
    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }
}