package br.com.hussan.enjoeitest

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import br.com.hussan.enjoeitest.domain.Product
import br.com.hussan.enjoeitest.extensions.navigate
import br.com.hussan.enjoeitest.ui.productdetails.ProductDetailsActivity

class AppNavigator(private val activity: Activity) {

    companion object {
        const val PRODUCT = "PRODUCT"
        const val EXTRA_IMAGE_TRANSITION_NAME = "EXTRA_IMAGE_TRANSITION_NAME"
    }

    fun navigateToProductDetails(product: Product, view: View) {

        var options: ActivityOptionsCompat? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            options = ViewCompat.getTransitionName(view)?.let {
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity,
                    view,
                    it
                )
            }
        }

        val bundle = Bundle().apply {
            putSerializable(PRODUCT, product)
            putString(EXTRA_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(view))
        }
        activity.navigate<ProductDetailsActivity>(bundle, options)
    }
}
