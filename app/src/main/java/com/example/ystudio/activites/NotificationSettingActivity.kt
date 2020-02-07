package com.example.ystudio.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ystudio.R
import com.example.ystudio.utils.SharedPreference
import kotlinx.android.synthetic.main.activity_notification_setting.*

class NotificationSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_setting)
        setTitle("Settings")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        ll_comment_notification.setOnClickListener {
            val intent = Intent(this,CommentNotificationsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

        ll_push_notification.setOnClickListener {
            switch_push_notification.isChecked = !switch_push_notification.isChecked
        }


    }

    override fun onStart() {
        super.onStart()
        onSetupNotificationType()
    }
    private fun onSetupNotificationType()
    {
        val sharedPreference: SharedPreference =SharedPreference(this)
        if (sharedPreference.getValueString("comment_notification_key")!=null)
        {
            val comment_notification:String = sharedPreference.getValueString("comment_notification_key")!!
            when(comment_notification){
                "all"-> {tv_notificationType.setText("All")}
                "important"-> {tv_notificationType.setText("Important")}
                "none"-> {tv_notificationType.setText("None")}
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
