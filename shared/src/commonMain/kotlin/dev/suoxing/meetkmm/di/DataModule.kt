package dev.suoxing.meetkmm.di

import dev.suoxing.meetkmm.repository.MemoRepository
import dev.suoxing.meetkmm.usecase.GetMemoBookUseCase
import dev.suoxing.meetkmm.usecase.GetMemosUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::MemoRepository)

    factoryOf(::GetMemosUseCase)
    factoryOf(::GetMemoBookUseCase)
}