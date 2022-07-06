package com.example.bankaccount.error

import org.springframework.http.HttpStatus

enum class Error(
    val httpStatus: HttpStatus,
    val text: String
) {
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Required request body is missing"),
}