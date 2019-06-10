package br.com.hussan.enjoeitest.domain

import com.google.gson.annotations.SerializedName

data class Photo(
    val crop: String,
    val gravity: String,
    @SerializedName("public_id")
    val publicId: String
)
