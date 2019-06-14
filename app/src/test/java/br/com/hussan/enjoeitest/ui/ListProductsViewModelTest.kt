package br.com.hussan.cleanarch.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.hussan.enjoeitest.data.response.ProductsPagination
import br.com.hussan.enjoeitest.domain.Pagination
import br.com.hussan.enjoeitest.main.PRODUCTS
import br.com.hussan.enjoeitest.ui.main.ListProductsViewModel
import br.com.hussan.enjoeitest.usecases.GetProducts
import io.reactivex.Observable
import mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class ListProductsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val getProducts: GetProducts = mock()
    private lateinit var mViewModelList: ListProductsViewModel

    @Before
    fun setUp() {
        mViewModelList = ListProductsViewModel(getProducts)
    }

    @Test
    fun `Get products `() {

        val page = 1
        val productsResponse = ProductsPagination(
            Pagination(1, 1),
            PRODUCTS
        )
        `when`(getProducts.invoke(page)).thenReturn(Observable.fromArray(productsResponse))

        mViewModelList.getProducts(page)
            .test()
            .assertValue(productsResponse)
            .assertComplete()

        verify(getProducts).invoke(1)

    }

    @Test
    fun `Get products with error`() {

        val exception = Exception()
        val page = 1

        `when`(getProducts.invoke(1)).thenReturn(Observable.error(exception))

        mViewModelList.getProducts(page)
            .test()
            .assertError(exception)

    }
}
