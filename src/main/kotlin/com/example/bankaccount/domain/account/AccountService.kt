package com.example.bankaccount.domain.account

import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {
    fun getAccountDetails(accountId: Long): AccountDto {
        return accountRepository.findById(accountId).get().toDto()
    }
}
