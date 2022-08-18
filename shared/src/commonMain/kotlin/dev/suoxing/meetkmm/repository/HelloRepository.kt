package dev.suoxing.meetkmm.repository

import dev.suoxing.meetkmm.model.HelloVO
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

class HelloRepository(
    private val scope: CoroutineScope,
    private val dispatcher: CoroutineContext = Dispatchers.Default
) {

    private suspend fun realSayHello(count: Int): HelloVO {
        return withContext(dispatcher) {
            HelloVO("hello $count")
        }
    }

    fun sayHello(): Flow<HelloVO> = flow {
        repeat(10) {
            delay(1000)
            emit(realSayHello(it))
        }
    }
}