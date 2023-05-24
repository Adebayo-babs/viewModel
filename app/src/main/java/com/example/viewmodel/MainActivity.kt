package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    //Reference variable for the viewmodel object
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val textView = findViewById<TextView>(R.id.tvView)
        val button = findViewById<Button>(R.id.button)

        //textView.text = count.toString()
//        textView.text = viewModel.count.toString()

        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })

        button.setOnClickListener{
//            count++
//            textView.text = count.toString()

            viewModel.updateCount()
            //textView.text = viewModel.count.toString()
        }
    }
}