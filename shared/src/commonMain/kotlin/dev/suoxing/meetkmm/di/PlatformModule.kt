package dev.suoxing.meetkmm.di

import dev.suoxing.meetkmm.Platform
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val platformModule = module {
    singleOf(::Platform)
}