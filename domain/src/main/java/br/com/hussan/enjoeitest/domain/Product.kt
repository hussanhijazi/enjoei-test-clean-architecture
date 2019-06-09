package br.com.hussan.enjoeitest.domain


// TODO check nulls
data class Product(
    val id: Int,
    val title: String,
    val content: String? = null,
    val discountPercentage: Int? = null,
    val likesCount: Int? = null,
    val maximumInstallment: Int? = null,
    val originalPrice: Int? = null,
    val photos: List<Photo>? = null,
    val price: Float? = null,
    val publishedCommentsCount: Int? = null,
    val size: String? = null,
    val user: User? = null
)
