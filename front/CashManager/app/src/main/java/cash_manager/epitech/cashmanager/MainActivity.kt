package cash_manager.epitech.cashmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cash_manager.epitech.cashmanager.databinding.ActivityMainBinding

import cash_manager.epitech.cashmanager.locale.allI18n
import cash_manager.epitech.cashmanager.stdlib.Singletons.Logger
import java.util.*

class MainActivity : AppCompatActivity() {

    class I18n (
        val title: String,
        val loginLabel: String,
        val registerLabel: String
    )

    private val activityI18n  = allI18n.main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //langs bindings
         binding.strings = allI18n.main



        val button: Button = findViewById(R.id.registerButton)
        val loginButton: Button = findViewById(R.id.loginButton)
        val i = Intent(this, RegisterActivity::class.java)
        val loginIntent = Intent(this, NavActivity::class.java)

        button.setOnClickListener {
            startActivity(i)
        }

        loginButton.setOnClickListener {
            startActivity(loginIntent)
            this.finish() //finish login activity for security issues
            // todo : Make a it in a better way
        }
        Logger.info("ISO ${Locale.getDefault().toString()}")
        Logger.info("Lang of i18n ${allI18n.langage}")
        Logger.noCommit("TESTSTSTSTTSTSTS")
    }


}
