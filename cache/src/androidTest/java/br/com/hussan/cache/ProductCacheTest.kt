package br.com.hussan.cache

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.hussan.cache.mapper.ProductEntityMapper
import br.com.hussan.enjoeitest.data.cache.ProductCache
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductCacheTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var appDatabase: AppDatabase

    private var entityMapper = ProductEntityMapper()

    private lateinit var productCache: ProductCache

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDatabase = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        productCache = ProductCacheImpl(appDatabase, entityMapper)
    }

    @Test
    fun saveProduct() {

        productCache.save(PRODUCTS).test()
            .assertNoValues()
            .assertComplete()

    }

    @Test
    fun saveSearchAndGet() {

        productCache.save(PRODUCTS).test()
            .assertNoValues()
            .assertComplete()

        productCache.get(1).test()
            .assertValue(PRODUCTS)
    }

}
