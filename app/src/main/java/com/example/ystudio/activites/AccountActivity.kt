package com.example.ystudio.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ystudio.R

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setTitle("Account")
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_analytics);
    }
}
