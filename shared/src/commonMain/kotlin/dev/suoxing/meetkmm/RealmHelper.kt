package dev.suoxing.meetkmm

import dev.suoxing.meetkmm.model.Memo
import dev.suoxing.meetkmm.model.MemoBook
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object RealmHelper {

    val realm: Realm by lazy {
        val config = RealmConfiguration.Builder(setOf(
            Memo::class,
            MemoBook::class
        )).build()
        Realm.open(config)
    }
}