package com.example.ystudio.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ystudio.R
import com.example.ystudio.adapters.VideoListAdapter
import com.example.ystudio.models.VideoListModel
import kotlinx.android.synthetic.main.fragment_videos.*


/**
 * A simple [Fragment] subclass.
 */
class VideosFragment : Fragment() {

    //var  videoList = mutableListOf<VideoListModel>()
    var sortText:String = "Most recent"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        for ( i in 1..10){
//            videoList.add(VideoListModel("Video Title","1,322","14","25"))
//        }

        val layoutManager = StaggeredGridLayoutManager(1,1)
        recyclerview_videolist.layoutManager = layoutManager
        recyclerview_videolist.adapter = VideoListAdapter()

        rl_soring.setOnClickListener {
            // Inflate a custom view using layout inflater
            val sortingPopupView = layoutInflater.inflate(R.layout.video_sort,null)
            val textView_most_recent = sortingPopupView.findViewById<TextView>(R.id.tv_most_recent)
            val textView_most_viewed = sortingPopupView.findViewById<TextView>(R.id.tv_most_viewed)
            textView_most_recent.setBackgroundResource(R.color.colorWhite)
            textView_most_viewed.setBackgroundResource(R.color.colorWhite)
            if(sortText == "Most recent"){
                textView_most_recent.setBackgroundResource(R.color.colorGrayDropDown)
            }
            else{
                textView_most_viewed.setBackgroundResource(R.color.colorGrayDropDown)
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

            textView_most_recent.setOnClickListener {
                tv_video_sorting.text = textView_most_recent.text.toString()
                sortText = tv_video_sorting.text.toString()
                popupWindow.dismiss()
            }
            textView_most_viewed.setOnClickListener {
                tv_video_sorting.text = textView_most_viewed.text.toString()
                sortText = tv_video_sorting.text.toString()
                popupWindow.dismiss()
            }
        }
    }

}
