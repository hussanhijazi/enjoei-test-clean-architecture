package br.com.hussan.enjoeitest.data

import br.com.hussan.enjoeitest.data.response.ProductsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {
    @GET("products/home")
    fun getProducts(@Query("page") page: Int): Observable<ProductsResponse>
}
