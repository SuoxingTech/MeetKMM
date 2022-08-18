package dev.suoxing.meetkmm.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HelloVO(
    @SerialName("message")
    val msg: String
)
