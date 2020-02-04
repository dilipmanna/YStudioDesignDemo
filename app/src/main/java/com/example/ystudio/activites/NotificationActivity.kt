package com.example.ystudio.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.ystudio.R
import kotlinx.android.synthetic.main.app_bar_main.*

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_notification)
        setTitle("Notification")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
       // getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_analytics);
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
        super.onBackPressed()
    }
}
