package com.example.ystudio.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ystudio.R
import com.example.ystudio.utils.SharedPreference
import kotlinx.android.synthetic.main.activity_comment_notifications.*

class CommentNotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_notifications)
        setTitle("Notifications")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        radioButtonSetup()
    }

    private fun radioButtonSetup()
    {
        val sharedPreference: SharedPreference =SharedPreference(this)

        if (sharedPreference.getValueString("comment_notification_key")!=null)
        {
            val comment_notification:String = sharedPreference.getValueString("comment_notification_key")!!
            when(comment_notification){
                "all"-> {radioBtn_all_comment_notification.isChecked = true}
                "important"-> {radioBtn_important_comments_notification.isChecked = true}
                "none"-> {radioBtn_turn_off_all_comment.isChecked = true}
            }
        }

        radioBtn_all_comment_notification.setOnClickListener {it ->
            sharedPreference.save("comment_notification_key","all")
            radioBtn_all_comment_notification.isChecked = true
            radioBtn_important_comments_notification.isChecked = false
            radioBtn_turn_off_all_comment.isChecked = false
            onBackPressed()
        }
        radioBtn_important_comments_notification.setOnClickListener { it ->
            sharedPreference.save("comment_notification_key","important")
            radioBtn_important_comments_notification.isChecked = true
            radioBtn_all_comment_notification.isChecked = false
            radioBtn_turn_off_all_comment.isChecked = false
            onBackPressed()
        }
        radioBtn_turn_off_all_comment.setOnClickListener { it ->
            sharedPreference.save("comment_notification_key","none")
            radioBtn_turn_off_all_comment.isChecked = true
            radioBtn_all_comment_notification.isChecked = false
            radioBtn_important_comments_notification.isChecked = false
            onBackPressed()
        }
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
