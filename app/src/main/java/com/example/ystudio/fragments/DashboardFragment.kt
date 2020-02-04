package com.example.ystudio.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner

import com.example.ystudio.R
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.spinner_nav?.visibility = View.GONE
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu?.findItem(R.id.action_search)?.setVisible(false)
        super.onPrepareOptionsMenu(menu)
    }
}
