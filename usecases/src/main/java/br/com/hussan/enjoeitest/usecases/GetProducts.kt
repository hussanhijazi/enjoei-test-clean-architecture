package br.com.hussan.enjoeitest.usecases

import br.com.hussan.enjoeitest.data.datasource.ProductDatasource
import br.com.hussan.enjoeitest.domain.Product
import io.reactivex.Observable

class GetProducts(private val dataSource: ProductDatasource) {
    operator fun invoke(page: Int): Observable<List<Product>> {
        return dataSource.getProducts(page)
    }
}

