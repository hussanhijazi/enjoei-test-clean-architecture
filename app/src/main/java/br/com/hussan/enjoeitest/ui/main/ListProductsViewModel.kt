package br.com.hussan.enjoeitest.ui.main

import androidx.lifecycle.ViewModel
import br.com.hussan.enjoeitest.usecases.GetProducts

class ListProductsViewModel(
    private val getProducts: GetProducts
) : ViewModel() {

    fun getProducts(page: Int) = getProducts.invoke(page)
}

