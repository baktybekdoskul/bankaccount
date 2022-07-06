package com.example.bankaccount.domain.transfer

import com.example.bankaccount.domain.account.AccountRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class TransferService(
    private val transferRepository: TransferRepository,
    private val accountRepository: AccountRepository
) {
    @Transactional(rollbackFor = [Exception::class], isolation = Isolation.READ_COMMITTED)
    fun save(request: TransferRequest): TransferDto {
        val accountFrom = accountRepository.findById(request.accountFrom).get()
        val accountTo = accountRepository.findById(request.accountTo).get()
        if (request.amount > accountFrom.balance)
            throw Exception("Insufficient resources")
        accountFrom.balance -= request.amount
        accountTo.balance += request.amount
        accountRepository.save(accountFrom)
        accountRepository.save(accountTo)
        return transferRepository.save(request.toEntity()).toDto()
    }
    //
}
