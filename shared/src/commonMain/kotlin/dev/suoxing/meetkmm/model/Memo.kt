package dev.suoxing.meetkmm.model

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class Memo : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    var content: String = ""
    var since: RealmInstant? = null
}
