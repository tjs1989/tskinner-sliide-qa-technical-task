package com.test.news.features.news

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.test.news.R
import com.test.news.common.NewsScreenConstants.NEWS_TEXT_VIEW_HEADER
import com.test.news.features.news.presentation.NewsActivity
import com.test.news.rules.AnimationsRule
import com.test.news.userInterations.assertTextInOuterParentTextView
import com.test.news.viewActions.clickOnItemInReyclerView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NewsTests {

    @get:Rule
    var activityTestRule = ActivityTestRule<NewsActivity>(
        NewsActivity::class.java
    )

    @get:Rule
    val animationsRule = AnimationsRule()

    @Test
    fun imagesAreDisplayed() {
        assertTextInOuterParentTextView(
            R.id.action_bar,
            R.id.action_bar_container,
            NEWS_TEXT_VIEW_HEADER
        )

        clickOnItemInReyclerView(0)
        //TODO Assert that Chrome opened with the image
    }
}
