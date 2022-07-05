package com.example.bankaccount.domain.account

import com.example.bankaccount.domain.user.UserDto

data class AccountDto(
    val id: Long,
    val balance: Double,
    val user: UserDto
)
