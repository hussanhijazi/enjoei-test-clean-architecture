package br.com.hussan.enjoeitest.data.mapper

import br.com.hussan.enjoeitest.data.model.ProductView
import br.com.hussan.enjoeitest.domain.Product

class ProductViewMapper : EntityViewMapper<ProductView, Product> {
    override fun mapToView(type: Product): ProductView {
        return ProductView(
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
            type.photos,
            type.user
        )
    }
}
