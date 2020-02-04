package com.example.ystudio.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.example.ystudio.R
import kotlinx.android.synthetic.main.spinner_row.view.*
import kotlinx.android.synthetic.main.spinner_title.view.*


class CustomSpinnerAdapter(context: Context, private val items:List<String>) :ArrayAdapter<String>(context, 0,items){

    var mSelectedIndex:Int = -1
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       //return createViewFromResource(position, convertView, parent)
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_title, parent, false)
        val tvCategory: TextView = view.tv_selectVideoCategory
        tvCategory.setText(items[position])
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createViewFromResource(position, convertView, parent)

    }

    fun setSelection(position: Int) {
        mSelectedIndex = position
        notifyDataSetChanged()
    }

    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup?): View{
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_row, parent, false)
        val tvCategory: TextView = view.tvCategory

        if(mSelectedIndex == position)
            tvCategory.setTextColor(Color.BLUE)
        tvCategory.setText(items[position])
        return view
    }
}