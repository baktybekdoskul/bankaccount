package com.example.bankaccount.error

import org.springframework.http.HttpStatus
import java.util.UUID

data class ErrorModel(
    val id: UUID,
    val status: HttpStatus,
    val code: Error,
    val error: String? = null,
    val data: String? = null,
    val detail: String? = null
)
