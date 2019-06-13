package br.com.hussan.cache.mapper

import br.com.hussan.cache.PRODUCT
import br.com.hussan.cache.PRODUCT_ENTITY
import br.com.hussan.cache.model.ProductEntity
import br.com.hussan.enjoeitest.domain.Product
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProductEntityMapperTest {

    private lateinit var productEntityMapper: ProductEntityMapper

    @Before
    fun setUp() {
        productEntityMapper = ProductEntityMapper()
    }

    @Test
    fun mapToCachedMapsData() {

        val cachedProduct = productEntityMapper.mapToCached(PRODUCT)

        assertDataEquality(PRODUCT, cachedProduct)
    }

    @Test
    fun mapFromCachedMapsData() {
        val product = productEntityMapper.mapFromCached(PRODUCT_ENTITY)

        assertDataEquality(product, PRODUCT_ENTITY)
    }

    private fun assertDataEquality(
        product: Product,
        cachedProduct: ProductEntity
    ) {
        assertEquals(product.title, cachedProduct.title)
    }

}
