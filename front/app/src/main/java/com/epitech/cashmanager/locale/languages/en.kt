package com.epitech.cashmanager.locale.languages

import com.epitech.cashmanager.MainActivity
import com.epitech.cashmanager.RegisterActivity
import com.epitech.cashmanager.locale.AllI18n
import com.epitech.cashmanager.locale.AppLanguage

val enI18n = AllI18n(
    langage = AppLanguage.EN,
    main = MainActivity.I18n(
        title = "Login",
        loginLabel = "Login",
        registerLabel = "Register"
    ),
    register = RegisterActivity.I18n(
        title = "Register",
        firstNameLabel = "First name",
        lastNameLabel = "Last name",
        usernameLabel = "Username",
        passwordLabel = "Password",
        confirmPasswordLabel = "Confirm password",
        buttonLabel = "Sign up"
    )
)