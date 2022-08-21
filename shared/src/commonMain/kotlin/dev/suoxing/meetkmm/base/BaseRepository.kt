package dev.suoxing.meetkmm.base

import dev.suoxing.kmm_arch.ioDispatcher
import dev.suoxing.meetkmm.RealmHelper
import kotlinx.coroutines.withContext

open class BaseRepository {

    protected val realm = RealmHelper.realm

    protected suspend fun <T> postIO(block: suspend () -> T): T {
        return withContext(ioDispatcher) {
            block()
        }
    }
}