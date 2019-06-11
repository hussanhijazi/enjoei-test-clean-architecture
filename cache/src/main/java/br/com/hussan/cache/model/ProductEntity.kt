package br.com.hussan.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "price") var price: Double,
    @ColumnInfo(name = "original_price") var originalPrice: Double,
    @ColumnInfo(name = "likes_count") var likesCount: Int,
    @ColumnInfo(name = "maximum_installment") val maximumInstallment: Int,
    @ColumnInfo(name = "discount_percentage") val discountPercentage: Int,
    @ColumnInfo(name = "published_comments_count") var publishedCommentsCount: Int
)
