package cash_manager.epitech.cashmanager.locale.languages

import cash_manager.epitech.cashmanager.MainActivity
import cash_manager.epitech.cashmanager.RegisterActivity
import cash_manager.epitech.cashmanager.locale.AllI18n
import cash_manager.epitech.cashmanager.locale.AppLanguage

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