package dev.suoxing.meetkmm.uistate

import dev.suoxing.meetkmm.UiStatus
import dev.suoxing.meetkmm.base.IUIState
import dev.suoxing.meetkmm.model.MemoBook

data class MemoUIState(
    val firstBook: MemoBook? = null,
    val toastMessage: String? = null,
    override val status: UiStatus = UiStatus.LOADING
) : IUIState
