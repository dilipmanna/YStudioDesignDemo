package com.example.ystudio.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ystudio.R
import com.example.ystudio.adapters.CustomSpinnerAdapter
import com.example.ystudio.adapters.VideoListAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_videos.*


/**
 * A simple [Fragment] subclass.
 */
class VideosFragment : Fragment() {

    //var  videoList = mutableListOf<VideoListModel>()
    var sortText:String = "Most recent"

   // private var toolbar: Toolbar? = null

    //private var spinner_nav: Spinner? = null
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

        tv_video_sorting.text = "Most recent"
        rl_soring.setOnClickListener {
            // Inflate a custom view using layout inflater
            val sortingPopupView = layoutInflater.inflate(R.layout.video_sort,null)
            val tv_sort1 = sortingPopupView.findViewById<TextView>(R.id.tv_sort1)
            val tv_sort2 = sortingPopupView.findViewById<TextView>(R.id.tv_sort2)
            tv_sort1.setText("Most recent")
            tv_sort2.setText("Most viewed")
            tv_sort1.setBackgroundResource(R.color.colorWhite)
            tv_sort2.setBackgroundResource(R.color.colorWhite)
            if(sortText == "Most recent"){
                tv_sort1.setBackgroundResource(R.color.colorGrayDropDown)
            }
            else{
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

        activity?.spinner_nav?.visibility = View.VISIBLE
        addItemsToSpinner()
    }
    fun addItemsToSpinner() {
        val list = ArrayList<String>()
        list.add("All videos")
        list.add("Draft")
        list.add("Public")
        list.add("Unlisted")
        list.add("Private")
        // Custom ArrayAdapter with spinner item layout to set popup background
        var spinAdapter = CustomSpinnerAdapter(context!!,list)
        activity?.spinner_nav?.adapter = spinAdapter
        activity?.spinner_nav?.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapter: AdapterView<*>, v: View,
                position: Int, id: Long
            ) { // On selecting a spinner item
                spinAdapter.setSelection(position)
                val item = adapter.getItemAtPosition(position).toString()
                // Showing selected spinner item
                //Toast.makeText(context, "Selected  : $item", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
                //Toast.makeText(context, "Please select item", Toast.LENGTH_LONG).show()
            }
        }
    }

}
