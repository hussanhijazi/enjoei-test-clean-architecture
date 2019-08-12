package br.com.hussan.enjoeitest.data.mapper

interface EntityViewMapper<T, V> {
    fun mapToView(type: V): T
}
