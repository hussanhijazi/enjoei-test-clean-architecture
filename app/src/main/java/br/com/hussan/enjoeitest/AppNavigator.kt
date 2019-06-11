package br.com.hussan.enjoeitest

import android.app.Activity
import android.os.Bundle
import br.com.hussan.enjoeitest.domain.Product
import br.com.hussan.enjoeitest.extensions.navigate
import br.com.hussan.enjoeitest.ui.productdetails.ProductDetailsActivity

class AppNavigator(private val activity: Activity) {

    companion object {
        const val PRODUCT = "product"
    }

    fun navigateToProductDetails(product: Product) {
        val bundle = Bundle().apply {
            putSerializable(PRODUCT, product)
        }
        activity.navigate<ProductDetailsActivity>(bundle)
    }
}
