package br.com.hussan.enjoeitest.data.cache

import br.com.hussan.enjoeitest.domain.Product
import io.reactivex.Completable
import io.reactivex.Single

interface ProductCache {
    fun save(products: List<Product>): Completable
    fun get(page: Int): Single<List<Product>>
}
