package br.com.hussan.enjoeitest.usecases.di

import br.com.hussan.enjoeitest.usecases.GetProducts
import org.koin.dsl.module.module

val useCaseModule = module {
    single { GetProducts(get()) }
}
