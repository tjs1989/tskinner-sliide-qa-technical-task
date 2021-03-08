package com.test.news

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.test.news.common.NewsScreenConstants.NEWS_TEXT_VIEW_HEADER
import com.test.news.features.login.presentation.LoginActivity
import com.test.news.rules.AnimationsRule
import com.test.news.userInterations.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {

    @get:Rule
    var activityTestRule = ActivityTestRule<LoginActivity>(
        LoginActivity::class.java)

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

        assertDisplayedTextInTextView(NEWS_TEXT_VIEW_HEADER)

    }

    companion object {
        private const val VALID_USER_NAME = "user1"
        private const val VALID_USER_PASSWORD = "password"
    }
}
