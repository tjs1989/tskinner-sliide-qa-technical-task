package com.test.news.utils

import android.util.Log
import com.test.news.rules.setMobileDataStatus
import com.test.news.rules.setWifiStatus

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

fun setNetworkConnections(enabled: Boolean) {
    if (enabled) {
        setWifiStatus(true)
        setMobileDataStatus(true)
    } else {
        setWifiStatus(false)
        setMobileDataStatus(false)
    }
}


fun Boolean.toInt(): Int {
    return if (this) 1 else 0
}
