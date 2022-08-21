package dev.suoxing.meetkmm.viewmodel

import dev.suoxing.meetkmm.UiStatus
import dev.suoxing.meetkmm.base.BaseViewModel
import dev.suoxing.meetkmm.repository.MemoRepository
import dev.suoxing.meetkmm.uistate.MemoUIState
import dev.suoxing.meetkmm.usecase.GetMemoBookUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class MemoViewModel : BaseViewModel<MemoUIState>() {

    private val getMemoBookUseCase by inject<GetMemoBookUseCase>()
    private val memoRepository by inject<MemoRepository>()

    override val _uiStateFlow = MutableStateFlow(MemoUIState())
    val uiStateFlow: StateFlow<MemoUIState> = _uiStateFlow

    override fun start() {
        viewModelScope.launch {
            getMemoBookUseCase().collect {
                updateState {
                    copy(
                        firstBook = it,
                        status = if (it == null) UiStatus.EMPTY else UiStatus.IDLE
                    )
                }
            }
        }
    }

    fun createMemoBook() {
        viewModelScope.launch {
            memoRepository.createMemoBook("MyMemos")
        }
    }

    fun createMemo(content: String, bookName: String) {
        viewModelScope.launch {
            memoRepository.createMemo(content, bookName)
        }
    }
}