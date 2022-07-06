package com.example.bankaccount.domain.transfer

import java.time.LocalDateTime

data class TransferRequest(
    val amount: Double,
    val accountFrom: Long,
    val accountTo: Long
) {
    fun toEntity(): TransferEntity = TransferEntity(
        amount = this.amount,
        accountFrom = this.accountFrom,
        accountTo = this.accountTo,
        createdTime = LocalDateTime.now()
    )
}
