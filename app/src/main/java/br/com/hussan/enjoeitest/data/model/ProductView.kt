package br.com.hussan.enjoeitest.data.model

import android.os.Parcelable
import br.com.hussan.enjoeitest.domain.Photo
import br.com.hussan.enjoeitest.domain.User
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductView(
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
) : Parcelable

