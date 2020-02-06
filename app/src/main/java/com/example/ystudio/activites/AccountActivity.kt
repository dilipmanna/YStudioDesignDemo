package com.example.ystudio.activites

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ystudio.R
import kotlinx.android.synthetic.main.app_bar_main.*


class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setTitle("Account")

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_cancel)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.GRAY))
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onBackPressed() {
        finish()
        overridePendingTransition(0,R.anim.slide_out_bottom)
        super.onBackPressed()
    }
}
