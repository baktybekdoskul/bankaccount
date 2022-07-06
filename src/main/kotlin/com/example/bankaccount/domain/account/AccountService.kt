package com.example.bankaccount.domain.account

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {
    @Transactional(isolation = Isolation.READ_COMMITTED)
    fun getAccountDetails(accountId: Long): AccountDto {
        return accountRepository.findById(accountId).get().toDto()
    }
}
