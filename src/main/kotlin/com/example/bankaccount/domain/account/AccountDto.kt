package com.example.bankaccount.domain.account

import com.example.bankaccount.domain.user.UserDto
import java.math.BigDecimal

data class AccountDto(
    val id: Long,
    val balance: BigDecimal,
    val user: UserDto
)
