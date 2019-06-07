package br.com.hussan.cache.di

import androidx.room.Room.databaseBuilder
import br.com.hussan.cache.AppDatabase
import br.com.hussan.cache.ProductCacheImpl
import br.com.hussan.cache.mapper.ProductEntityMapper
import br.com.hussan.enjoeitest.data.cache.ProductCache
import org.koin.dsl.module.module

val cacheModule = module {
    single {
        databaseBuilder(
            get(),
            AppDatabase::class.java, "enjoei-challenge"
        ).build()
    }

    single { ProductEntityMapper() }

    single<ProductCache> {
        ProductCacheImpl(get(), get())
    }
}
