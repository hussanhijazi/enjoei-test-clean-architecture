package br.com.hussan.enjoeitest.usecases

import br.com.hussan.enjoeitest.data.datasource.ProductDatasource
import br.com.hussan.enjoeitest.data.response.ProductsPagination
import br.com.hussan.enjoeitest.domain.Pagination
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class GetProductsTest {

    private lateinit var getProducts: GetProducts
    private lateinit var repository: ProductDatasource

    @Before
    fun setUp() {
        repository = mock()
        getProducts = GetProducts(repository)
    }

    @Test
    fun `Get products call locally`() {

        val page = 1
        val productsResponse = ProductsPagination(
            Pagination(1, 1),
            PRODUCTS
        )
        `when`(repository.getProducts(page)).thenReturn(Observable.just(productsResponse))

        getProducts.invoke(page).test()
            .assertValue(productsResponse)
            .assertNoErrors()
            .assertComplete()


        verify(repository).getProducts(1)
        verifyNoMoreInteractions(repository)
    }

    @Test
    fun `Get products call locally with error`() {

        val page = 1

        val exception = Exception()
        `when`(repository.getProducts(page)).thenReturn(Observable.error(exception))

        getProducts.invoke(page).test().assertError(exception)

        verify(repository).getProducts(page)
        verifyNoMoreInteractions(repository)
    }
}
