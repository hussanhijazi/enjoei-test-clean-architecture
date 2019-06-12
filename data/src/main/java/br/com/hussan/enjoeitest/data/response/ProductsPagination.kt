package br.com.hussan.enjoeitest.data.response


import br.com.hussan.enjoeitest.domain.Pagination
import br.com.hussan.enjoeitest.domain.Product
import com.google.gson.annotations.SerializedName

data class ProductsPagination(
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("products")
    val products: List<Product>
)
