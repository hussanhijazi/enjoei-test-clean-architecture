package br.com.hussan.enjoeitest.di

import br.com.hussan.enjoeitest.AppNavigator
import br.com.hussan.enjoeitest.ui.main.ProductsActivity
import br.com.hussan.enjoeitest.ui.main.ProductsViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    viewModel { ProductsViewModel(get()) }
    single { (activity: ProductsActivity) ->
        AppNavigator(activity = activity)
    }
}
