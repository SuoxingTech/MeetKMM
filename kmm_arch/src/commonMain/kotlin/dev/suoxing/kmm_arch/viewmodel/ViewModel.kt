package dev.suoxing.kmm_arch.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

expect abstract class ViewModel<T: Any>() {

    protected val viewModelScope: CoroutineScope

    open fun onCleared()

    abstract val uiStateFlow: StateFlow<T>
}