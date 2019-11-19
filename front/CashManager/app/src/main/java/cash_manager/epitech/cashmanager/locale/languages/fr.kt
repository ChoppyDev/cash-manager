package cash_manager.epitech.cashmanager.locale.languages

import cash_manager.epitech.cashmanager.MainActivity
import cash_manager.epitech.cashmanager.RegisterActivity
import cash_manager.epitech.cashmanager.locale.AllI18n
import cash_manager.epitech.cashmanager.locale.AppLanguage

val frI18n = AllI18n(
    langage = AppLanguage.FR,
    main = MainActivity.I18n(
        title = "Connexion",
        loginLabel = "Connexion",
        registerLabel = "S'inscrire"
    ),
    register = RegisterActivity.I18n(
        title = "Inscription",
        firstNameLabel = "Prénom",
        lastNameLabel = "Nom",
        usernameLabel = "Nom d'utilisateur",
        passwordLabel = "Mot de passe",
        confirmPasswordLabel = "Confirmation du mot de passe",
        buttonLabel = "S'inscrire"
    )
)