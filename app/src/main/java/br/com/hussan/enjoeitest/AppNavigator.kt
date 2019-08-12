package br.com.hussan.enjoeitest

import android.app.Activity
import android.os.Bundle
import br.com.hussan.enjoeitest.data.model.ProductView
import br.com.hussan.enjoeitest.extensions.navigate
import br.com.hussan.enjoeitest.ui.productdetails.ProductDetailsActivity

class AppNavigator(private val activity: Activity) {

    companion object {
        const val PRODUCT = "PRODUCT"
    }

    fun navigateToProductDetails(product: ProductView) {
        val bundle = Bundle().apply {
            putParcelable(PRODUCT, product)
        }
        activity.navigate<ProductDetailsActivity>(bundle)
    }
}
