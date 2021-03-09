package com.test.news.features.news;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.test.news.R;
import com.test.news.features.news.presentation.NewsActivity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.test.news.userInterations.UserAssertionsKt.assertTextInTextView;
import static com.test.news.userInterations.UserAssertionsKt.waitForResourceToDisplay;
import static com.test.news.utils.UtilsKt.setNetworkConnections;


@RunWith(AndroidJUnit4.class)

public class OfflineNewsTests {

    @BeforeClass
    public static void disableInternetConnections() {
        setNetworkConnections(false);
    }

    @Rule
    public ActivityScenarioRule<NewsActivity> activityRule =
            new ActivityScenarioRule<>(NewsActivity.class);

    @Test
    public void noNewsErrorDisplaysWithNoInternet() {
        waitForResourceToDisplay(R.id.textViewError);
        assertTextInTextView(R.id.textViewError, android.R.id.content, "Failed to load news");
    }

    @AfterClass
    public static void enableInternetConnections() {
        setNetworkConnections(true);
    }

}
