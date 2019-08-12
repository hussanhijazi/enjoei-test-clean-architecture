package br.com.hussan.enjoeitest.data.model

import br.com.hussan.enjoeitest.domain.Pagination

data class ProductsPaginationView(
    val pagination: Pagination,
    val products: List<ProductView>
)
