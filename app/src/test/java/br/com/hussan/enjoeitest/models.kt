package br.com.hussan.enjoeitest.main

import br.com.hussan.enjoeitest.domain.Avatar
import br.com.hussan.enjoeitest.domain.Photo
import br.com.hussan.enjoeitest.domain.Product
import br.com.hussan.enjoeitest.domain.User

val PRODUCT = Product(
    1, "title", 1.0, 2.0, 1, 1,
    1, 1, "", "m",
    listOf(Photo("", "", "")),
    User(Avatar("", "", ""), 1, "")
)
val PRODUCTS = listOf(
    PRODUCT
)
