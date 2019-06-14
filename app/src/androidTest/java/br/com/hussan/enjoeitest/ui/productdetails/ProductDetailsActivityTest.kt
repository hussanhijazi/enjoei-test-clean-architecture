package br.com.hussan.enjoeitest.ui.productdetails

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.extensions.formatPrice
import br.com.hussan.enjoeitest.ui.PRODUCT
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ProductDetailsActivityTest {

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<ProductDetailsActivity> =
        object : ActivityTestRule<ProductDetailsActivity>(ProductDetailsActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                return ProductDetailsActivity.newIntent(targetContext, PRODUCT)
            }
        }

    @Test
    fun checkProductsDetails() {
        val price = activityRule.activity.getString(R.string.price_format, PRODUCT.price.formatPrice())
        val originalPrice = activityRule.activity.getString(R.string.price_format, PRODUCT.originalPrice.formatPrice())

        onView(withText(price)).check(matches(isDisplayed()))
        onView(withText(originalPrice)).check(matches(isDisplayed()))
        onView(withText(PRODUCT.title)).check(matches(isDisplayed()))

        onView(withId(R.id.btnComments)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLike)).check(matches(isDisplayed()))
    }

}
