package br.com.hussan.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "original_price") val originalPrice: Double,
    @ColumnInfo(name = "likes_count") val likesCount: Int,
    @ColumnInfo(name = "maximum_installment") val maximumInstallment: Int,
    @ColumnInfo(name = "discount_percentage") val discountPercentage: Int,
    @ColumnInfo(name = "published_comments_count") val publishedCommentsCount: Int,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "site") val size: String?
)
