package com.epitech.cashmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.epitech.cashmanager.databinding.ActivityMainBinding
import com.epitech.cashmanager.databinding.ActivityRegisterBinding
import com.epitech.cashmanager.locale.allI18n

class RegisterActivity : AppCompatActivity() {

    class I18n(
        val title: String,
        val firstNameLabel : String,
        val lastNameLabel : String,
        val usernameLabel : String,
        val passwordLabel : String,
        val confirmPasswordLabel : String,
        val buttonLabel : String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityRegisterBinding =  DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.strings = allI18n.register

        //setContentView(R.layout.activity_register)
    }

}
