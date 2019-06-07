package br.com.hussan.cache

import br.com.hussan.cache.mapper.ProductEntityMapper
import br.com.hussan.enjoeitest.data.cache.ProductCache
import br.com.hussan.enjoeitest.domain.Product
import io.reactivex.Completable
import io.reactivex.Single

class ProductCacheImpl(
    private val db: AppDatabase,
    private val mapper: ProductEntityMapper
) :
    ProductCache {
    override fun save(products: List<Product>): Completable {
        return db.productDao().insertAll(products.map {
            mapper.mapToCached(it)
        })
    }

    override fun get(page: Int): Single<List<Product>> {
        return db.productDao().loadProducts().map { it.map { mapper.mapFromCached(it) } }
    }
}
