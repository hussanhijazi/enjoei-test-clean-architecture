package br.com.hussan.enjoeitest.data.datasource

import br.com.hussan.enjoeitest.data.AppApi
import br.com.hussan.enjoeitest.data.cache.ProductCache
import br.com.hussan.enjoeitest.domain.Product
import io.reactivex.Observable

class ProductRepository(
    private val api: AppApi, private val cache: ProductCache
) : ProductDatasource {

    override fun getProducts(page: Int): Observable<List<Product>> {

        return api.getProducts(page).map { it.products }.flatMap {
            cache.save(it).andThen(Observable.just(it))
        }
    }

}

interface ProductDatasource {
    fun getProducts(page: Int): Observable<List<Product>>
}
