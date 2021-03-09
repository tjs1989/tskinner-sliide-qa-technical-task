package com.test.news.userInterations

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.test.news.common.TestSystemConstants.DEFAULT_WAIT_TIMEOUT
import com.test.news.viewActions.ViewActions
import org.hamcrest.Matchers.allOf

fun checkResourceIsDisplayed(resourceID: Int) {
    onView(withId(resourceID))
        .check(matches(isDisplayed()))

}

fun waitForResourceToDisplay(resourceID: Int) {
    onView(isRoot()).perform(
        ViewActions.pollForResource(
            resourceID, DEFAULT_WAIT_TIMEOUT.toLong()
        )
    )
}

fun assertTextInOuterParentTextView(childResource: Int, parentResource: Int, text: String) {
    val textView = onView(
        allOf(
            withParent(
                allOf(
                    withId(childResource),
                    withParent(withId(parentResource))
                )
            ),
            isDisplayed()
        )
    )
    textView.check(matches(withText(text)))
}

fun assertTextInTextView(childResource: Int, parentResource: Int, text: String) {
    val textView = onView(
        allOf(
            withId(childResource),
            withParent(withParent(withId(parentResource))),
            isDisplayed()
        )
    )
    textView.check(matches(withText(text)))
}

