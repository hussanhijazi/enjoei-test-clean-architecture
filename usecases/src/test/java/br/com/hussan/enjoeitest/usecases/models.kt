package br.com.hussan.enjoeitest.usecases

import br.com.hussan.enjoeitest.domain.Avatar
import br.com.hussan.enjoeitest.domain.Photo
import br.com.hussan.enjoeitest.domain.Product
import br.com.hussan.enjoeitest.domain.User

val PRODUCT = Product(
    "id", 1, 1, 1, 1, 1, listOf(Photo("", "", "")),
    1F, 1, "m", "", User(Avatar("", "", ""), 1, "")
)
val PRODUCTS = listOf(
    PRODUCT
)
