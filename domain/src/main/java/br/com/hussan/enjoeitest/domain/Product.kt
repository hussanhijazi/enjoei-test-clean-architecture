package br.com.hussan.enjoeitest.domain

import com.google.gson.annotations.SerializedName


// TODO check nulls
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val content: String? = null,
    val discountPercentage: Int? = null,
    @SerializedName("likes_count")
    val likesCount: Int? = null,
    val maximumInstallment: Int? = null,
    val originalPrice: Int? = null,
    val photos: List<Photo>? = null,
    val publishedCommentsCount: Int? = null,
    val size: String? = null,
    val user: User? = null
)
