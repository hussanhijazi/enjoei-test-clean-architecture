package br.com.hussan.enjoeitest.usecases

import br.com.hussan.enjoeitest.data.datasource.ProductDatasource
import br.com.hussan.enjoeitest.data.response.ProductsPagination
import io.reactivex.Observable

class GetProducts(private val dataSource: ProductDatasource) {
    operator fun invoke(page: Int): Observable<ProductsPagination> {
        return dataSource.getProducts(page)
    }
}

