package com.example.ystudio.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.ystudio.R
import com.example.ystudio.adapters.AnalyticsViewPagerAdapder
import kotlinx.android.synthetic.main.fragment_analytics.*


/**
 * A simple [Fragment] subclass.
 */
class AnalyticsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_analytics, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AnalyticsViewPagerAdapder(getChildFragmentManager())
        adapter.addFragment(OverviewFragment(), "OVERVIEW")
        adapter.addFragment(RevenueFragment(), "REVENUE")
        adapter.addFragment(DiscoveryFragment(), "DISCOVERY")
        adapter.addFragment(AudienceFragment(), "AUDIENCE")
        adapter.addFragment(InteractiveContentFragment(), "INTERACTIVE CONTENT")
        adapter.addFragment(AnalyticPlaylistsFragment(), "PLAYLISTS")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }


}
