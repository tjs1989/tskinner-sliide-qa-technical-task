package com.test.news.features.login.presentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.test.news.R
import com.test.news.userInterations.clearAndEnterTextInField
import com.test.news.userInterations.tapOnButton
import com.test.news.rules.AnimationsRule
import com.test.news.viewActions.ViewActions.waitForResourceToDisplay
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {

    @get:Rule
    var activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @get:Rule
    val animationsRule = AnimationsRule()

    @Test
    fun shouldLoginWithValidCredentials() {
        clearAndEnterTextInField(
            R.id.editTextUserName,
            VALID_USER_NAME
        )
        clearAndEnterTextInField(
            R.id.editTextPassword,
            VALID_USER_PASSWORD
        )
        tapOnButton(R.id.buttonLogin)


        // TODO assert login when ready
//        assertTrue(activityTestRule.activity.isFinishing)
        onView(isRoot()).perform(waitForResourceToDisplay(R.id.imageView, 5000));
    }

    companion object {
        private const val VALID_USER_NAME = "user1"
        private const val VALID_USER_PASSWORD = "password"
    }
}
