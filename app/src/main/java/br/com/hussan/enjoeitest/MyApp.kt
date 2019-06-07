package br.com.hussan.enjoeitest

import android.app.Application
import br.com.hussan.cache.di.cacheModule
import br.com.hussan.enjoeitest.data.di.apiModule
import br.com.hussan.enjoeitest.data.di.dataModule
import br.com.hussan.enjoeitest.di.appModule
import br.com.hussan.enjoeitest.usecases.di.useCaseModule
import org.koin.android.ext.android.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, useCaseModule, apiModule, dataModule, cacheModule))

    }
}
