package br.com.hussan.enjoeitest.domain

import java.io.Serializable

// TODO check nulls
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
    val photos: List<Photo>? = null,
    val size: String? = null,
    val user: User? = null
) : Serializable
