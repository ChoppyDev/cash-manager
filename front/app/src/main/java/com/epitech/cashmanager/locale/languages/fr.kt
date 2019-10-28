package com.epitech.cashmanager.locale.languages

import com.epitech.cashmanager.MainActivity
import com.epitech.cashmanager.locale.AllI18n
import com.epitech.cashmanager.locale.AppLanguage

val frI18n = AllI18n(
    langage = AppLanguage.FR,
    main = MainActivity.i18n(
        title = "Connexion",
        loginLabel = "Connexion",
        registerLabel = "S'inscrire"
    )
)