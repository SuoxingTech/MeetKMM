package dev.suoxing.meetkmm

import dev.suoxing.meetkmm.di.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}