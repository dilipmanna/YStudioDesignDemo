package com.example.ystudio.fragments


import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.forEach
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
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


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.action_search ->{
               // activity?.
                true
            }
            else ->super.onOptionsItemSelected(item)
        }

        //return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        val searchItem = menu.findItem(R.id.action_search)
        val searchManager =
            activity!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = searchItem.actionView as SearchView

        val searchBar = searchView.findViewById<View>(R.id.search_bar) as LinearLayout
        //searchBar.layoutTransition = LayoutTransition()

        searchView.queryHint = "Search videos..."
        if (searchItem is MenuItem) {
            searchItem.setOnActionExpandListener(object :
                MenuItem.OnActionExpandListener {
                override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                    // background color change
                    (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
                    // hide others menu item
                    menu.forEach { menuitem->
                        if (menuitem !== p0) menuitem.setVisible(false)
                    }
                    return true
                }
                override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                    // background back to as theme background
                    (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorPrimary,context?.theme)))
                    activity?.invalidateOptionsMenu()
                    return true
                }
            })
        }


        //searchView.setBackgroundResource(R.drawable.bg_white_background)

        val editext  = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        editext.setTextColor(Color.BLACK)
        editext.setHintTextColor(Color.GRAY)
        val searchClose = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        searchClose.setColorFilter(Color.argb(255, 0, 0, 0))

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity()?.getComponentName()))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("",false)
                searchItem.collapseActionView()
                Toast.makeText(context,"Looking for $query",Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(context,"Looking for $newText",Toast.LENGTH_SHORT).show()
                return true
            }

        })
    }



}
