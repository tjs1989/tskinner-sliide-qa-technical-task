package com.test.news.userInterations

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId


fun clearAndEnterTextInField(resourceID: Int, text: String) {
    checkResourceIsDisplayed(resourceID)
    onView(withId(resourceID))
        .perform(clearText(), typeText(text))
}

fun tapOnButton(resourceID: Int) {
    checkResourceIsDisplayed(resourceID)
    onView(withId(resourceID))
        .perform(ViewActions.click())
}
