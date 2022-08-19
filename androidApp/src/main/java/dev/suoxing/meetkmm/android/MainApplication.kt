package dev.suoxing.meetkmm.android

import android.app.Application
import dev.suoxing.kmm_arch.ApplicationWrapper

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationWrapper.init(this)
    }
}