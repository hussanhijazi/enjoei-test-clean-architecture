package br.com.hussan.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "price") var price: Double
)
