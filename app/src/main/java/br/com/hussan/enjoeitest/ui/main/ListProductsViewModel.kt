package br.com.hussan.enjoeitest.ui.main

import androidx.lifecycle.ViewModel
import br.com.hussan.enjoeitest.data.mapper.ProductsPaginationViewMapper
import br.com.hussan.enjoeitest.data.model.ProductsPaginationView
import br.com.hussan.enjoeitest.usecases.GetProducts
import io.reactivex.Observable

class ListProductsViewModel(
    private val getProducts: GetProducts,
    private val mapper: ProductsPaginationViewMapper
) : ViewModel() {

    fun getProducts(page: Int): Observable<ProductsPaginationView> = getProducts.invoke(page).map(mapper::mapToView)
}

