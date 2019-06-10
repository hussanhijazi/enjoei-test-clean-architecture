package br.com.hussan.enjoeitest

import android.app.Application
import br.com.hussan.cache.di.cacheModule
import br.com.hussan.enjoeitest.data.di.apiModule
import br.com.hussan.enjoeitest.data.di.dataModule
import br.com.hussan.enjoeitest.di.appModule
import br.com.hussan.enjoeitest.usecases.di.useCaseModule
import com.cloudinary.android.MediaManager
import org.koin.android.ext.android.startKoin

class MyApp : Application() {

    companion object {
        const val CLOUD_NAME_CONF = "cloud_name"
        const val CLOUD_NAME = "demo"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, useCaseModule, apiModule, dataModule, cacheModule))
        val config = HashMap<String, String>()
        config.put(CLOUD_NAME_CONF, CLOUD_NAME)
        MediaManager.init(this, config)
    }
}
