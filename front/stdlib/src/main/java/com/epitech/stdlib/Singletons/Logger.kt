package com.epitech.stdlib.Singletons

import java.util.*


/**
* This is a Logger class helper to show console log with date and data
* */
object Logger {

    fun log(prefix : String, msg : String) {
        println(" [$prefix] - ${Calendar.getInstance().time} - $msg")
    }

    @Deprecated("This code contains a no commit log")
    fun noCommit(f : String) {
       log("NO COMMIT", f)
    }

    fun info(f: String) {
        log("INFO", f)
    }

    fun debug(f: String) {
        log("DEBUG", f)
    }
}