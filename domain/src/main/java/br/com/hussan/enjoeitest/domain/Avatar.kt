package br.com.hussan.enjoeitest.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Avatar(
    val crop: String,
    val gravity: String,
    @SerializedName("public_id")
    val publicId: String
) : Serializable
