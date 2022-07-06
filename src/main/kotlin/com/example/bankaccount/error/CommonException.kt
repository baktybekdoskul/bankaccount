package com.example.bankaccount.error

import java.util.UUID

open class CommonException : RuntimeException {

    val id = UUID.randomUUID()

    val error: Error

    val data: String?

    constructor (error: Error, message: String, data: String? = null) : super(message) {
        this.error = error
        this.data = data
    }
}

class AccountNotFoundException(message: String) : CommonException(ERROR, message) {
    companion object {
        val ERROR = Error.ACCOUNT_NOT_FOUND
    }
}
