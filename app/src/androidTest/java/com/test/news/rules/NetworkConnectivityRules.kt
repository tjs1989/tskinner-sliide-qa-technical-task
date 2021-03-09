package com.test.news.rules

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.test.news.common.AdbCommands

fun setWifiStatus(enable: Boolean) {
    if (enable) {
        executeShellCommand(AdbCommands.SET_WIFI_STATUS_ENABLED)
    } else {
        executeShellCommand(AdbCommands.SET_WIFI_STATUS_DISABLED)
    }
}

fun setMobileDataStatus(enable: Boolean) {
    if (enable) {
        executeShellCommand(AdbCommands.SET_MOBILE_DATA_ENABLED)
    } else {
        executeShellCommand(AdbCommands.SET_MOBILE_DATA_DISABLED)
    }
}

fun executeShellCommand(command: String) {
    with(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())) {
        executeShellCommand(command)
    }
}
