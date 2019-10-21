package com.epitech.stdlib

import java.util.*

object Logger {

    //print a msg with No commit message
    @Deprecated("This code contains a no commit log")
    fun noCommit(f : String) {
        println(" [NO COMMIT] - ${Calendar.getInstance().time} - ${f}")
    }
}