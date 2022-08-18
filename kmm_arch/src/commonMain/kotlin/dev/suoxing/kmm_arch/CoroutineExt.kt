package dev.suoxing.kmm_arch

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.native.concurrent.ThreadLocal

val uiDispatcher: CoroutineDispatcher = Dispatchers.Main

expect val ioDispatcher: CoroutineDispatcher

expect val defaultDispatcher: CoroutineDispatcher

@ThreadLocal
var createViewModelScope: () -> CoroutineScope = {
    CoroutineScope(uiDispatcher)
}