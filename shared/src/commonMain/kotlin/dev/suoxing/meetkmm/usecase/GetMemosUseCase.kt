package dev.suoxing.meetkmm.usecase

import dev.suoxing.meetkmm.repository.MemoRepository

class GetMemosUseCase(private val memoRepository: MemoRepository) {

    operator fun invoke() = memoRepository.getMemos()
}