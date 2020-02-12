package com.example.ystudio.activites

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.ystudio.R
import com.example.ystudio.adapters.CustomSpinnerAdapter
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.app_bar_main.*


class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setTitle("Account")

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_cancel)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.GRAY))

        addItemsToSpinner()
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

    fun addItemsToSpinner() {
        val list = ArrayList<String>()
        list.add("Bengali Story")
        list.add("Dilip Manna")
        // Custom ArrayAdapter with spinner item layout to set popup background
        var spinAdapter = CustomSpinnerAdapter(this,list)
        spinner_account.adapter = spinAdapter
        spinner_account.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapter: AdapterView<*>, v: View,
                position: Int, id: Long
            ) { // On selecting a spinner item
                spinAdapter.setSelection(position)
                val item = adapter.getItemAtPosition(position).toString()
                // Showing selected spinner item
                //Toast.makeText(context, "Selected  : $item", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(arg0: AdapterView<*>?) {
                //Toast.makeText(context, "Please select item", Toast.LENGTH_LONG).show()
            }
        }
    }
}
