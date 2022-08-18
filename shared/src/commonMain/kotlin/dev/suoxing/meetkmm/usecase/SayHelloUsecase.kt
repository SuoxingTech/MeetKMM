package dev.suoxing.meetkmm.usecase

import dev.suoxing.meetkmm.model.HelloVO
import dev.suoxing.meetkmm.repository.HelloRepository
import kotlinx.coroutines.flow.Flow

class SayHelloUsecase(private val repository: HelloRepository) {

    operator fun invoke(): Flow<HelloVO> {
        return repository.sayHello()
    }
}