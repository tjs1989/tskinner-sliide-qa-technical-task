package com.test.news.common

object TestSystemConstants {
    const val DEFAULT_WAIT_TIMEOUT = 15000
}

object LoginScreenConstants {
    const val VALID_USER_NAME = "user1"
    const val VALID_USER_PASSWORD = "password"
}

object NewsScreenConstants {
    const val NEWS_TEXT_VIEW_HEADER = "News"
}

object AdbCommands {
    const val SET_WIFI_STATUS_ENABLED = "svc wifi enable"
    const val SET_WIFI_STATUS_DISABLED = "svc wifi disable"
    const val TRANSITION_ANIMATION_SCALE =
        "settings put global transition_animation_scale"
    const val WINDOW_ANIMATION_SCALE = "settings put global window_animation_sc"
    const val ANIMATOR_DURATION = "settings put global animator_duration_scale"
    const val SET_MOBILE_DATA_ENABLED = "svc data enable"
    const val SET_MOBILE_DATA_DISABLED = "svc data disable"
}
