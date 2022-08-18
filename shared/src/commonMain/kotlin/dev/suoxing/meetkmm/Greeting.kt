package dev.suoxing.meetkmm

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class Greeting {
    private val client = HttpClient()

    suspend fun getGreet(): String {
        val resp = client.get("https://ktor.io")
        return if (resp.status == HttpStatusCode.OK) {
            "OK, I'm fine."
        } else {
            "Uh, I'm not fine."
        }
    }

    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}