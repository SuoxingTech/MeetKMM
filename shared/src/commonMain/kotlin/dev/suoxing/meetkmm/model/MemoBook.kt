package dev.suoxing.meetkmm.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class MemoBook : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    var title: String = ""
    var memos: RealmList<Memo> = realmListOf()
}
