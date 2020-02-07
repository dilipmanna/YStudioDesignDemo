package com.example.ystudio.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ystudio.R
import kotlinx.android.synthetic.main.notifcaion_header_item.view.*

class NotificationListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1 || viewType == 6 || viewType == 12)
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.notifcaion_header_item,parent,false)
            return MyViewHolderHeader(view)
        }
        else
        {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_comment_item,parent,false)
            return MyViewHolder(view)
        }
    }

    override fun getItemCount(): Int = 18

    override fun getItemViewType(position: Int): Int {
        if(position == 0 || position == 6 || position == 12)
            return 1
        else
            return 2

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == 0 || position == 6  || position == 12 )
        {
            val myViewHolderHeader: MyViewHolderHeader = holder as MyViewHolderHeader
            when(position){
                0->myViewHolderHeader.tv_notification_header.setText("Today")
                6->myViewHolderHeader.tv_notification_header.setText("Yesterday")
                11->myViewHolderHeader.tv_notification_header.setText("This Month")
            }
        }
        else
        {
            val myViewHolder: MyViewHolder = holder as MyViewHolder
        }
    }

    inner class MyViewHolderHeader(itemView:View): RecyclerView.ViewHolder(itemView) {
        val tv_notification_header : TextView = itemView.tv_notification_header
    }
    inner class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    }
}