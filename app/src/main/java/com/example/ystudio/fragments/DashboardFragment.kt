package com.example.ystudio.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

import com.example.ystudio.R
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_dashboard.*

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

        btn_viewmore_analytics.setOnClickListener {
            goToAnalyticsPage(it)
        }
        btn_analytics_summery.setOnClickListener {
            goToAnalyticsPage(it)
        }

    }

    private fun goToAnalyticsPage(it:View)
    {
        val action : NavDirections = DashboardFragmentDirections.actionNavDashboardToNavAnalytics()
        Navigation.findNavController(it).navigate(action)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu?.findItem(R.id.action_search)?.setVisible(false)
        super.onPrepareOptionsMenu(menu)
    }
}
