package br.com.hussan.enjoeitest

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.hussan.cache.AppDatabase
import br.com.hussan.cache.dao.ProductDao
import br.com.hussan.cache.model.ProductEntity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ProductDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var productDao: ProductDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        productDao = db.productDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun saveProducts() {

        val products = listOf(ProductEntity(1, "title"))

        productDao.insertAll(products).test()
            .assertComplete()
            .assertNoValues()

    }

    @Test
    fun loadCategories() {

        val products = listOf(ProductEntity(1, "title"))

        productDao.insertAll(products).test()
            .assertNoValues()
            .assertComplete()

        productDao.loadProducts().test()
            .assertValue(products)
    }
}

