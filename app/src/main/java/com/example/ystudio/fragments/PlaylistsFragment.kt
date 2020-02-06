package com.example.ystudio.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.ystudio.R
import com.example.ystudio.adapters.PlayListAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_playlists.*

/**
 * A simple [Fragment] subclass.
 */
class PlaylistsFragment : Fragment() {

    var sortText:String = "Time created"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.spinner_nav?.visibility = View.GONE

        val layoutManager = StaggeredGridLayoutManager(1,1)
        recyclerview_playlist.layoutManager = layoutManager
        recyclerview_playlist.adapter = PlayListAdapter()

        tv_video_sorting.text = "Time created"
        rl_soring.setOnClickListener {
            // Inflate a custom view using layout inflater
            val sortingPopupView = layoutInflater.inflate(R.layout.video_sort, null)
            val tv_sort1 = sortingPopupView.findViewById<TextView>(R.id.tv_sort1)
            val tv_sort2 = sortingPopupView.findViewById<TextView>(R.id.tv_sort2)
            tv_sort1.setText("Time created")
            tv_sort2.setText("Last video added")
            tv_sort1.setBackgroundResource(R.color.colorWhite)
            tv_sort2.setBackgroundResource(R.color.colorWhite)
            if (sortText == "Time created") {
                tv_sort1.setBackgroundResource(R.color.colorGrayDropDown)
            } else {
                tv_sort2.setBackgroundResource(R.color.colorGrayDropDown)
            }

            val popupWindow = PopupWindow(
                sortingPopupView, // Custom view to show in popup window
                LinearLayout.LayoutParams.MATCH_PARENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Window height
                true
            )

            popupWindow.showAsDropDown(
                rl_soring, // Exact position of layout to display popup
                0, // X offset
                -tv_video_sorting.height // Y offset
            )

            tv_sort1.setOnClickListener {
                tv_video_sorting.text = tv_sort1.text.toString()
                sortText = tv_video_sorting.text.toString()
                popupWindow.dismiss()
            }
            tv_sort2.setOnClickListener {
                tv_video_sorting.text = tv_sort2.text.toString()
                sortText = tv_video_sorting.text.toString()
                popupWindow.dismiss()
            }
        }
    }


}
