package com.example.bankaccount.domain.account

import com.example.bankaccount.domain.user.UserDto
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

@Schema(name = "Account's response object")
data class AccountDto(
    val id: Long,
    val balance: BigDecimal,
    val user: UserDto
)
