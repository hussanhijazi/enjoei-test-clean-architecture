package br.com.hussan.enjoeitest.domain

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val originalPrice: Double,
    val likesCount: Int,
    val maximumInstallment: Int,
    val discountPercentage: Int,
    val publishedCommentsCount: Int,
    val content: String,
    val size: String?,
    val photos: List<Photo>?,
    val user: User?
)
