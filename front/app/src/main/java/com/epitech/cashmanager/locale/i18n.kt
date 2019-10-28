package com.epitech.cashmanager.locale

import com.epitech.cashmanager.MainActivity
import com.epitech.cashmanager.RegisterActivity
import com.epitech.cashmanager.locale.languages.enI18n
import com.epitech.cashmanager.locale.languages.frI18n
import java.util.*




class AllI18n(
    val langage : AppLanguage,
    val main : MainActivity.I18n,
    val register : RegisterActivity.I18n
)

//get all I18n for selected language
val allI18n : AllI18n = when(Locale.getDefault().toString()) {
        AppLanguage.FR.javaLocales -> frI18n
        AppLanguage.EN.javaLocales -> enI18n
        else -> frI18n // default language
}

enum class AppLanguage(val iso639_1 : String, val iso639_2 : String, val javaLocales : String)  {
    FR("fr", "fra", "fr_FR"),
    EN("en", "eng", "en_US")
}

//implements the i18n interface Skeleton
