package br.com.hussan.enjoeitest.ui

import br.com.hussan.enjoeitest.data.model.ProductView
import br.com.hussan.enjoeitest.domain.Avatar
import br.com.hussan.enjoeitest.domain.Photo
import br.com.hussan.enjoeitest.domain.User

val PRODUCT = ProductView(
    1, "title", 1.0, 2.0, 1, 1,
    1, 1, "", "m",
    listOf(Photo("", "", "")),
    User(Avatar("", "", ""), 1, "")
)
val PRODUCTS = listOf(
    PRODUCT
)