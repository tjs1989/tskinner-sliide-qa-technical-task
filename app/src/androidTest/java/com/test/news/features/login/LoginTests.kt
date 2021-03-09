package com.test.news.features.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.test.news.R
import com.test.news.common.LoginScreenConstants.VALID_USER_NAME
import com.test.news.common.LoginScreenConstants.VALID_USER_PASSWORD
import com.test.news.common.NewsScreenConstants.NEWS_TEXT_VIEW_HEADER
import com.test.news.features.login.presentation.LoginActivity
import com.test.news.rules.AnimationsRule
import com.test.news.userInterations.assertTextInOuterParentTextView
import com.test.news.userInterations.clearAndEnterTextInField
import com.test.news.userInterations.tapOnButton
import com.test.news.userInterations.waitForResourceToDisplay
import com.test.news.utils.getCurrentTimestampInMillis
import com.test.news.utils.getRandomString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTests {

    @get:Rule
    var activityTestRule = ActivityTestRule<LoginActivity>(
        LoginActivity::class.java
    )

    @get:Rule
    val animationsRule = AnimationsRule()

    @Test
    fun loginWithValidCredentials() {
        clearAndEnterTextInField(
            R.id.editTextUserName,
            VALID_USER_NAME
        )
        clearAndEnterTextInField(
            R.id.editTextPassword,
            VALID_USER_PASSWORD
        )
        tapOnButton(R.id.buttonLogin)
        waitForResourceToDisplay(R.id.imageView)
        assertTextInOuterParentTextView(R.id.action_bar, R.id.action_bar_container, NEWS_TEXT_VIEW_HEADER)
    }

    @Test
    fun loginWithInvalidCredentials() {
        clearAndEnterTextInField(
            R.id.editTextUserName, "bob" + getCurrentTimestampInMillis() + "@gmail.com"
        )
        clearAndEnterTextInField(R.id.editTextPassword, getRandomString(25))
        tapOnButton(R.id.buttonLogin)

        //TODO Target the OS error fields and assert that the username and password errors display


    }

}
