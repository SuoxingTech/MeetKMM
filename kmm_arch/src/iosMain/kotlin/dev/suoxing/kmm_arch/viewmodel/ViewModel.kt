package dev.suoxing.kmm_arch.viewmodel

import dev.suoxing.kmm_arch.createViewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

actual abstract class ViewModel<T: Any> actual constructor() {
    protected actual val viewModelScope: CoroutineScope = createViewModelScope()

    actual open fun onCleared() {
        viewModelScope.cancel()
    }

    actual abstract val uiStateFlow: StateFlow<T>

    fun peek(): T = uiStateFlow.value

    fun collect(onEach: (T) -> Unit) {
        uiStateFlow
            .onEach { onEach(it) }
            .launchIn(viewModelScope)
    }
}