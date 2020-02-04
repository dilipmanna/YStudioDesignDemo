package com.example.ystudio.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast

import com.example.ystudio.R
import com.example.ystudio.adapters.CustomSpinnerAdapter
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * A simple [Fragment] subclass.
 */
class CommentsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        menu?.findItem(R.id.action_search)?.setVisible(false)
        super.onPrepareOptionsMenu(menu)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.spinner_nav?.visibility = View.VISIBLE
        addItemsToSpinner()
    }


    fun addItemsToSpinner() {
        val list = ArrayList<String>()
        list.add("Published comments")
        list.add("Held for review")
        list.add("Likely spam")
        // Custom ArrayAdapter with spinner item layout to set popup background
        var spinAdapter = CustomSpinnerAdapter(context!!,list)
        activity?.spinner_nav?.adapter = spinAdapter
        activity?.spinner_nav?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapter: AdapterView<*>, v: View,
                position: Int, id: Long
            ) { // On selecting a spinner item
                spinAdapter.setSelection(position)
                val item = adapter.getItemAtPosition(position).toString()
                // Showing selected spinner item
                Toast.makeText(context, "Selected  : $item", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
                Toast.makeText(context, "Please select item", Toast.LENGTH_LONG).show()
            }
        }
    }


}
