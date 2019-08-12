package br.com.hussan.enjoeitest.data.mapper

import br.com.hussan.enjoeitest.data.model.ProductsPaginationView
import br.com.hussan.enjoeitest.data.response.ProductsPagination

class ProductsPaginationViewMapper(private val productViewMapper: ProductViewMapper) :
    EntityViewMapper<ProductsPaginationView, ProductsPagination> {
    override fun mapToView(type: ProductsPagination): ProductsPaginationView {
        return ProductsPaginationView(
            type.pagination,
            type.products.map(productViewMapper::mapToView)
        )
    }
}
