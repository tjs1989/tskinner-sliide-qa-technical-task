package com.test.news.actions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.test.news.R


fun clearAndEnterTextInField(resourceID: Int, text: String){
    onView(withId(resourceID))
        .perform(clearText(), typeText(text))
}

fun tapOnButton(resourceID: Int){
    onView(withId(resourceID))
        .perform(ViewActions.click())
}

