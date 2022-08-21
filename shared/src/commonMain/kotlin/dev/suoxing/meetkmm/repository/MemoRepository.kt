package dev.suoxing.meetkmm.repository

import dev.suoxing.meetkmm.*
import dev.suoxing.meetkmm.base.BaseRepository
import dev.suoxing.meetkmm.model.Memo
import dev.suoxing.meetkmm.model.MemoBook
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.realmListOf

class MemoRepository: BaseRepository() {

    fun getMemos() = realm.query<Memo>().flowQuery()

    fun getMemoBook() = realm.query<MemoBook>().first().flowSingle()

    suspend fun createMemoBook(title: String): MemoBook = postIO {
        realm.write {
            copyToRealm(MemoBook().apply {
                this.title = title
            })
        }
    }

    suspend fun createMemo(content: String, bookTitle: String) = postIO {
        realm.write {
            val book = realm.query<MemoBook>("title = \'$bookTitle\'").first().find()
            if (book != null) {
                findLatest(book)?.memos?.add(Memo().apply {
                    this.content = content
                })
            } else {
                this.copyToRealm(
                    MemoBook().apply {
                        title = bookTitle
                        memos = realmListOf(
                            Memo().apply {
                                this.content = content
                            }
                        )
                    }
                )
            }
        }
    }
}