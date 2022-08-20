package dev.suoxing.meetkmm.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

data class MemoBook(
    @PrimaryKey
    val _id: ObjectId = ObjectId.create(),
    val title: String = "",
    val memos: RealmList<Memo> = realmListOf()
) : RealmObject
