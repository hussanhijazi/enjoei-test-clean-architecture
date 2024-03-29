package br.com.hussan.cache.mapper

import br.com.hussan.cache.model.ProductEntity
import br.com.hussan.enjoeitest.domain.Product

class ProductEntityMapper : EntityMapper<ProductEntity, Product> {
    override fun mapFromCached(type: ProductEntity): Product {
        return Product(
            type.id,
            type.title,
            type.price,
            type.originalPrice,
            type.likesCount,
            type.maximumInstallment,
            type.discountPercentage,
            type.publishedCommentsCount,
            type.content,
            type.size,
            null,
            null
        )
    }

    override fun mapToCached(type: Product): ProductEntity {
        return ProductEntity(
            type.id,
            type.title,
            type.price,
            type.originalPrice,
            type.likesCount,
            type.maximumInstallment,
            type.discountPercentage,
            type.publishedCommentsCount,
            type.content,
            type.size
        )
    }
}
