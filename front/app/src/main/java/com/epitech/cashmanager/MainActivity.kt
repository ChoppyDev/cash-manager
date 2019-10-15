package com.epitech.cashmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button2)
        val i = Intent(this, RegisterActivity::class.java)
        button.setOnClickListener {
            setContentView(R.layout.activity_register)
            startActivity(i)
        }
    }



}
