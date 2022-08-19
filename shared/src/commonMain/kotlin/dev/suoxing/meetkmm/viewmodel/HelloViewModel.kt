package dev.suoxing.meetkmm.viewmodel

import dev.suoxing.kmm_arch.ioDispatcher
import dev.suoxing.kmm_arch.viewmodel.ViewModel
import dev.suoxing.meetkmm.Greeting
import dev.suoxing.meetkmm.HappyKV
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock

class HelloViewModel : ViewModel<String>() {

    private val _greetFlow = MutableStateFlow("loading...")
    override val uiStateFlow: StateFlow<String> = _greetFlow

    private val testKey = "test_key"

    private var startTimeMillis = 0L

    init {
        startTimeMillis = Clock.System.now().toEpochMilliseconds()
        viewModelScope.launch {
            // Temporary synchronous, too slow for now 😥 android simulator: 113ms, iOS: 35ms
            val hasGreeted = HappyKV.getBoolean(testKey, false)
            val ms = Clock.System.now().toEpochMilliseconds() - startTimeMillis
            if (hasGreeted) {
                doWelcome(ms)
                HappyKV.putBoolean(testKey, false)
            } else {
                doGreet()
                HappyKV.putBoolean(testKey, true)
            }
        }
    }

    fun doWelcome(ms: Long) {
        viewModelScope.launch {
            delay(1000)
            _greetFlow.value = "Welcome back! $ms ms to read."
        }
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