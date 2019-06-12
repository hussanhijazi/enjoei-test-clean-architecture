package br.com.hussan.enjoeitest.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.hussan.enjoeitest.AppNavigator
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.data.response.ProductsPagination
import br.com.hussan.enjoeitest.domain.Pagination
import br.com.hussan.enjoeitest.domain.Product
import br.com.hussan.enjoeitest.extensions.add
import br.com.hussan.enjoeitest.extensions.hide
import br.com.hussan.enjoeitest.extensions.show
import br.com.hussan.enjoeitest.extensions.snack
import br.com.hussan.enjoeitest.util.EndlessRecyclerOnScrollListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list_products.*
import kotlinx.android.synthetic.main.lyt_error_connection.*
import kotlinx.android.synthetic.main.lyt_loading.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.net.UnknownHostException


class ListProductsFragment : Fragment() {

    private lateinit var scrollListener: EndlessRecyclerOnScrollListener
    private var actualPage: Int = 1
    private lateinit var pagination: Pagination
    private val viewModel: ProductsViewModel by viewModel()
    private val navigator: AppNavigator by inject { parametersOf(activity) }
    private val compositeDisposable = CompositeDisposable()
    private val productAdapter by lazy { ProductsAdapter(::goToDetails) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViewProducts()
        setupSwipeRefresh()
        getProducts(1)
        setConnectionErrorButton()
    }

    private fun setConnectionErrorButton() {
        btnTryAgain.setOnClickListener {
            getProducts(actualPage)
        }
    }

    private fun setupSwipeRefresh() {
        swipeRefresh.setOnRefreshListener {
            productAdapter.setItems(listOf())
            scrollListener.reset()
            getProducts(1)
        }
    }

    private fun getProducts(page: Int) {
        viewModel.getProducts(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading(true) }
            .doOnComplete { showLoading(false) }
            .doOnError { showLoading(false) }
            .subscribe(::showProducts, ::showError)
            .add(compositeDisposable)
    }

    private fun showProducts(items: ProductsPagination) {
        if (items.products.isNotEmpty()) {
            pagination = items.pagination
            productAdapter.addItems(items.products)
            showRecyclerViewProducts()
            if (swipeRefresh.isRefreshing)
                swipeRefresh.isRefreshing = false
        }
    }

    private fun showRecyclerViewProducts() {
        rvProducts.show()
        lytConnectionError.hide()
    }

    private fun showError(error: Throwable) {
        Log.d("h2", error.message)
        when (error) {
            is UnknownHostException -> lytConnectionError.show()
            else -> lytRoot.snack(R.string.error_message)
        }
    }

    private fun showLoading(show: Boolean) {
        if (show)
            progressBar.show()
        else
            progressBar.hide()
    }

    private fun setupRecyclerViewProducts() {
        rvProducts.run {
            setHasFixedSize(true)
            val gridLayout = GridLayoutManager(activity, 2)
            layoutManager = gridLayout
            adapter = productAdapter

            scrollListener = object : EndlessRecyclerOnScrollListener(gridLayout) {
                override fun onLoadMore(page: Int) {
                    actualPage = page
                    if (pagination.totalPages >= page)
                        getProducts(page)
                }
            }
            addOnScrollListener(scrollListener)
        }

    }

    private fun goToDetails(product: Product) {
        navigator.navigateToProductDetails(product)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}

