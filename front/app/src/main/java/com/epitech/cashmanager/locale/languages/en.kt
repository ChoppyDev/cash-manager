package com.epitech.cashmanager.locale.languages

import com.epitech.cashmanager.MainActivity
import com.epitech.cashmanager.locale.AllI18n
import com.epitech.cashmanager.locale.AppLanguage

val enI18n = AllI18n(
    langage = AppLanguage.EN,
    main = MainActivity.i18n(
        title = "Login",
        loginLabel = "Login",
        registerLabel = "Register"
    )
)