package br.com.hussan.enjoeitest.domain

data class Product(
    val content: String,
    val discountPercentage: Int,
    val id: Int,
    val likesCount: Int,
    val maximumInstallment: Int,
    val originalPrice: Int,
    val photos: List<Photo>,
    val price: Float,
    val publishedCommentsCount: Int,
    val size: String,
    val title: String,
    val user: User
)
