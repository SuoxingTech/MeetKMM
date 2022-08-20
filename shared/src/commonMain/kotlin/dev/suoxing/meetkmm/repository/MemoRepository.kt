package dev.suoxing.meetkmm.repository

import dev.suoxing.meetkmm.*
import dev.suoxing.meetkmm.model.Memo
import dev.suoxing.meetkmm.model.MemoBook
import io.realm.kotlin.ext.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class MemoRepository(
    private val scope: CoroutineScope,
    private val dispatcher: CoroutineContext = Dispatchers.Default
) {

    fun getMemos() = RealmHelper.realm.query<Memo>().flowQuery()

    fun getMemoBook() = RealmHelper.realm.query<MemoBook>().first().flowSingle()
}