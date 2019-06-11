package br.com.hussan.enjoeitest.domain

import java.io.Serializable

data class User(
    val avatar: Avatar,
    val id: Int,
    val name: String
) : Serializable
