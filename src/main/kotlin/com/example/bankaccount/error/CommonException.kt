package com.example.bankaccount.error

import java.util.UUID

open class CommonException : RuntimeException {

    val id = UUID.randomUUID()

    val error: Error

    val data: String?

    constructor (error: Error, data: String? = null) : super(error.text) {
        this.error = error
        this.data = data
    }

    constructor (error: Error, message: String, data: String? = null) : super(message) {
        this.error = error
        this.data = data
    }

    constructor (error: Error, message: String, ex: Exception, data: String? = null) : super(message, ex) {
        this.error = error
        this.data = data
    }
}
