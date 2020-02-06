package com.example.ystudio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ystudio.R

class CommentListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.comment_most_recent_item, parent, false)
            return MyViewHolder1(view)
        }else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
            return MyViewHolder2(view)
        }
    }

    override fun getItemCount(): Int = 10
    override fun getItemViewType(position: Int): Int {
        if(position == 0)
            return 1
        else
            return 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    inner class MyViewHolder1(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    inner class MyViewHolder2(itemView:View) : RecyclerView.ViewHolder(itemView){

    }
}