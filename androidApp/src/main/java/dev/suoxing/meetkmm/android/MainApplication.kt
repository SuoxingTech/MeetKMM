package dev.suoxing.meetkmm.android

import android.app.Application
import dev.suoxing.kmm_arch.ApplicationWrapper
import dev.suoxing.meetkmm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO: replace ApplicationWrapper with injected ApplicationContext
        ApplicationWrapper.init(this)

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule())
        }
    }
}