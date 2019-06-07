package br.com.hussan.enjoeitest.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.hussan.enjoeitest.domain.Product
import br.com.hussan.enjoeitest.usecases.GetProducts

class ProductsViewModel(
    private val getProducts: GetProducts
) : ViewModel() {

    private val results = MutableLiveData<List<Product>>()

    fun getProducts(page: Int) = getProducts.invoke(page)
        .doOnNext { results.postValue(it) }

    fun getResultProducts() = results
}

