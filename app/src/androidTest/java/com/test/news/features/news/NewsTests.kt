package com.test.news.features

import android.content.Context
import android.net.wifi.WifiManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import com.test.news.common.NewsScreenConstants.NEWS_TEXT_VIEW_HEADER
import com.test.news.features.news.presentation.NewsActivity
import com.test.news.rules.AnimationsRule
import com.test.news.userInterations.assertDisplayedTextInTextView
import com.test.news.utils.setAirplaneMode
import com.test.news.utils.setWifiStatus
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
//       checkResourceIsDisplayed(R.id.imageView)
        assertDisplayedTextInTextView(NEWS_TEXT_VIEW_HEADER)

        clickOnItemInReyclerView(0)

    }

    @Test
    fun letssee() {
//        InstrumentationRegistry.getInstrumentation().getUiAutomation()
//            .executeShellCommand("put global airplane_mode_on 0")

        setAirplaneMode(true)
//        setWifiStatus(true)
        Thread.sleep(5000)
//        setAirplaneMode(false)
//        Thread.sleep(5000)



//        with(UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())) {
//            executeShellCommand("settings put global airplane_mode_on 1")
//
//        }

//        adb shell settings put global airplane_mode_on 0


//        val wifi = getSystemService(Context.WIFI_SERVICE, NewsTests::class.java) as wifimanager




//        val wifi =
//            getSystemService<Any>(Context.WIFI_SERVICE) as WifiManager?
//        wifi!!.isWifiEnabled = false
////       checkResourceIsDisplayed(R.id.imageView)
//        assertDisplayedTextInTextView(NEWS_TEXT_VIEW_HEADER)
//
//        clickOnItemInReyclerView(0)

//        val context: Context =
//            InstrumentationRegistry.getInstrumentation().getTargetContext()
//        val wifiManager =
//            context.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        wifiManager.isWifiEnabled = false
//
        Thread.sleep(2000)

    }

}
