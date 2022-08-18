package dev.suoxing.meetkmm.viewmodel

import dev.suoxing.kmm_arch.ioDispatcher
import dev.suoxing.kmm_arch.viewmodel.ViewModel
import dev.suoxing.meetkmm.Greeting
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HelloViewModel : ViewModel<String>() {

    private val _greetFlow = MutableStateFlow("loading...")
    override val uiStateFlow: StateFlow<String> = _greetFlow

    init {
        doGreet()
    }

    fun doGreet() {
        viewModelScope.launch {
            delay(1000)
            _greetFlow.value = "1000ms later..."
            delay(300)
            val resp = withContext(ioDispatcher) {
                Greeting().getGreet()
            }
            _greetFlow.value = resp
        }
    }
}