package com.epitech.cashmanager.api

import java.net.HttpURLConnection
import java.net.URL

class TestService {
    fun sendGet() {
        val url = URL("http://www.google.com/")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            inputStream.bufferedReader().use {
                println(it.readLine())
            }
        }
    }
}