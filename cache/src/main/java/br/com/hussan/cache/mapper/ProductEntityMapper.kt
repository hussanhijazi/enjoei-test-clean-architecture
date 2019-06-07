package br.com.hussan.cache.mapper

import br.com.hussan.cache.model.ProductEntity
import br.com.hussan.enjoeitest.domain.Product

class ProductEntityMapper : EntityMapper<ProductEntity, Product> {
    override fun mapFromCached(type: ProductEntity): Product {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mapToCached(type: Product): ProductEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
