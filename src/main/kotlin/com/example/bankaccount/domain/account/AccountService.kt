package com.example.bankaccount.domain.account

import com.example.bankaccount.util.findByIdOrThrowException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    fun getAccountDetails(accountId: Long): AccountDto =
        accountRepository.findByIdOrThrowException(accountId).toDto()
}
