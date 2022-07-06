package com.example.bankaccount.domain.account

import com.example.bankaccount.error.AccountNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    fun getAccountDetails(accountId: Long): AccountDto {
        val account = accountRepository.findByIdOrNull(accountId)?.toDto()
            ?: throw AccountNotFoundException("There is no account with that id")
        return account
    }
}
