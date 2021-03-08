package com.test.news.utils

import android.util.Log

fun getRandomString(length: Int): String {
    val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    Log.i("random string generation", "Generated random string of$charset")
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}

fun getCurrentTimestampInMillis(): String {
    return System.currentTimeMillis().toString()
}