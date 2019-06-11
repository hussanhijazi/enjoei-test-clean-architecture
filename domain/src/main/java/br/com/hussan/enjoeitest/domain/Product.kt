package br.com.hussan.enjoeitest.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable


// TODO check nulls
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    @SerializedName("original_price")
    val originalPrice: Double,
    @SerializedName("likes_count")
    val likesCount: Int,
    @SerializedName("maximum_installment")
    val maximumInstallment: Int,
    @SerializedName("discount_percentage")
    val discountPercentage: Int,
    @SerializedName("published_comments_count")
    val publishedCommentsCount: Int,
    val content: String,
    val photos: List<Photo>? = null,
    val size: String? = null,
    val user: User? = null
) : Serializable
