package br.com.hussan.enjoeitest.data.di

import br.com.hussan.enjoeitest.data.datasource.ProductDatasource
import br.com.hussan.enjoeitest.data.datasource.ProductRepository
import org.koin.dsl.module.module

val dataModule = module {
    single<ProductDatasource> { ProductRepository(get(), get()) }
}
