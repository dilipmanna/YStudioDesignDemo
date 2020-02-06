package com.example.ystudio.activites

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ystudio.R


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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.notification_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.notification_setting ->{
                val intent = Intent(this,NotificationSettingActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.notification_clear_all_button ->{
                showDialog("","Clear all notifications?")
                true
            }
            else ->super.onOptionsItemSelected(item)
        }
    }
    private fun showDialog( title: String?, message: CharSequence?) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        if (title != null) builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("CLEAR ALL") {dialog, which->
            Toast.makeText(this,"Clear all clicked!",Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("CANCEL", negativeButtonclick)
        builder.show()
    }
    val negativeButtonclick = {dialog:DialogInterface,which:Int ->
        Toast.makeText(this,android.R.string.no,Toast.LENGTH_SHORT).show()
    }
}
