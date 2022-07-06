package com.example.bankaccount.domain.transfer

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "transfer")
data class TransferEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    // Pessimistic lock or parrallel access management security
    val amount: Double,
    val accountFrom: Long,
    val accountTo: Long,
    val createdTime: LocalDateTime
) {
    fun toDto(): TransferDto = TransferDto(
        id = this.id,
        amount = this.amount,
        accountFrom = this.accountFrom,
        accountTo = this.accountTo,
        createdTime = this.createdTime
    )
}
