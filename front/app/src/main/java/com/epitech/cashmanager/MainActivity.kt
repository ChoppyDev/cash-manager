package com.epitech.cashmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.epitech.stdlib.Singletons.Logger
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button2)
        val loginButton: Button = findViewById(R.id.connexionButton)
        val i = Intent(this, RegisterActivity::class.java)
        val loginIntent = Intent(this, CartActivity::class.java)

        button.setOnClickListener {
            startActivity(i)
        }

        loginButton.setOnClickListener {
            startActivity(loginIntent)
            this.finish() //finish login activity for security issues
            // todo : Make a it in a better way
        }
        println("iso test ${Locale.getDefault()}")
        Logger.noCommit("TESTSTSTSTTSTSTS")
    }


}
