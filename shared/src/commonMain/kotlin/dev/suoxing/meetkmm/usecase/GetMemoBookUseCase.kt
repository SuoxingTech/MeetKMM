package dev.suoxing.meetkmm.usecase

import dev.suoxing.meetkmm.model.MemoBook
import dev.suoxing.meetkmm.repository.MemoRepository
import kotlinx.coroutines.flow.Flow

class GetMemoBookUseCase(private val memoRepository: MemoRepository) {

    operator fun invoke(): Flow<MemoBook?> {
        return memoRepository.getMemoBook()
    }
}