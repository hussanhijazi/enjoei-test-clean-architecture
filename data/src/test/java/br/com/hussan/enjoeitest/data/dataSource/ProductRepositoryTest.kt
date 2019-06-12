package br.com.hussan.enjoeitest.data.dataSource

import br.com.hussan.enjoeitest.data.AppApi
import br.com.hussan.enjoeitest.data.cache.ProductCache
import br.com.hussan.enjoeitest.data.datasource.ProductDatasource
import br.com.hussan.enjoeitest.data.datasource.ProductRepository
import br.com.hussan.enjoeitest.data.mock
import br.com.hussan.enjoeitest.data.response.ProductsPagination
import br.com.hussan.enjoeitest.domain.*
import com.google.gson.Gson
import io.reactivex.Completable
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
class ProductRepositoryTest {

    lateinit var repository: ProductDatasource
    lateinit var api: AppApi
    lateinit var mockServer: MockWebServer
    lateinit var gson: Gson
    lateinit var cache: ProductCache


    @Before
    @Throws
    fun setUp() {

        gson = Gson()
        cache = mock()

        mockServer = MockWebServer()
        val baseURL = mockServer.url("/").toString()

        val okHttpClient = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        api = retrofit.create(AppApi::class.java)

        repository = ProductRepository(api, cache)

    }

    @Test
    fun `Get facts remote and save locally`() {

        val page = 1
        val productsResponse = ProductsPagination(
            Pagination(1, 1),
            listOf(
                Product(
                    "id", 1, 1, 1, 1, 1, listOf(Photo("", "", "")),
                    1F, 1, "m", "", User(Avatar("", "", ""), 1, "")
                )
            )
        )
        val path = "/products/home?page=$page"

        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(gson.toJson(productsResponse))
        mockServer.enqueue(mockResponse)

        val productsToSave = productsResponse.products.map {
            it
        }

        `when`(cache.save(productsToSave)).thenReturn(Completable.complete())

        repository.getProducts(page).test().apply {
            awaitTerminalEvent(1, TimeUnit.SECONDS)
            assertValue(productsResponse.products)
            assertNoErrors()
            assertValueCount(1)
        }

        val request = mockServer.takeRequest()
        assertEquals(path, request.path)

        verify(cache).save(productsToSave)

    }

}
