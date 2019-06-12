package br.com.hussan.enjoeitest.data.datasource

import br.com.hussan.enjoeitest.data.AppApi
import br.com.hussan.enjoeitest.data.cache.ProductCache
import br.com.hussan.enjoeitest.data.response.ProductsPagination
import io.reactivex.Observable

class ProductRepository(
    private val api: AppApi, private val cache: ProductCache
) : ProductDatasource {

    override fun getProducts(page: Int): Observable<ProductsPagination> {
        return api.getProducts(page)
            .flatMap {
                cache.save(it.products).andThen(Observable.just(it))
            }
    }

}

interface ProductDatasource {
    fun getProducts(page: Int): Observable<ProductsPagination>
}
