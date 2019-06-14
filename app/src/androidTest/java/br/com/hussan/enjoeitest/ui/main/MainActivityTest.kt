package br.com.hussan.enjoeitest.ui.main

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.hussan.enjoeitest.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsNot.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun launchActivity() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun clickToDetailsActivityWhenHasDiscount() {
        Thread.sleep(300)
        onView(allOf(withId(R.id.txtDiscount), isCompletelyDisplayed()))
            .perform(click())

        onView(withId(R.id.txtDiscount)).check(matches(isDisplayed()))
        onView(withId(R.id.txtDiscount)).check(matches(hasTextColor(R.color.gray_text)))
    }

    fun swipeViewPager() {
        onView(withId(R.id.viewPager))
            .check(matches(isDisplayed()))

        onView(withId(R.id.viewPager))
            .perform(swipeLeft())
    }

    @Test
    fun tabLayoutDisplay() {
        onView(withId(R.id.tabLayout)).check(matches(isDisplayed()))
    }

    @Test
    fun lytConnectionErrorNotDisplay() {
        onView(withId(R.id.lytConnectionError)).check(matches(not(isDisplayed())))
    }

    @Test
    fun recyclerViewProductsDisplay() {
        onView(allOf(withId(R.id.rvProducts), isCompletelyDisplayed()))
    }
}
