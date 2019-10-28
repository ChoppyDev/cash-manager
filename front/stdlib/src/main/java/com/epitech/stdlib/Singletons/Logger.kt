package com.epitech.stdlib.Singletons

import java.util.*

object Logger {

    //print a msg with No commit message
    @Deprecated("This code contains a no commit log")
    fun noCommit(f : String) {
        println(" [NO COMMIT] - ${Calendar.getInstance().time} - $f")
    }

    fun info(f: String) {
        println(" [INFO] - ${Calendar.getInstance().time} - $f")
    }
}