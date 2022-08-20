package dev.suoxing.meetkmm.base

import dev.suoxing.kmm_arch.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent

/**
 * BaseViewModel wrap up.
 *
 * @author Yifan Wong
 * @since 2022-08-20
 */
abstract class BaseViewModel<T : Any> : ViewModel<T>(), KoinComponent {

    /**
     * Provide a way for UI layer to start running ViewModel manually.
     */
    open fun start() { }
}