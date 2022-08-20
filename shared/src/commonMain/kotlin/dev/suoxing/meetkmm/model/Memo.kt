package dev.suoxing.meetkmm.model

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

data class Memo(
    @PrimaryKey
    val _id: ObjectId = ObjectId.create(),
    val content: String = "",
    val since: RealmInstant? = null
) : RealmObject
