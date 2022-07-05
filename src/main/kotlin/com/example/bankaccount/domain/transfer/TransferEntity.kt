package com.example.bankaccount.domain.transfer

import java.time.ZonedDateTime
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
    val id: Long,
    val amount: Double,
    val accountFrom: Long,
    val accountTo: Long,
    val createdTime: ZonedDateTime
)
