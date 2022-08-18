package dev.suoxing.meetkmm.di

import dev.suoxing.meetkmm.Greeting
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::Greeting)
}