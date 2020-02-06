package com.example.ystudio.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ystudio.R

class NotificationSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_setting)
        setTitle("Settings")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
