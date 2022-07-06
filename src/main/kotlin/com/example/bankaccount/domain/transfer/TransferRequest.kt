package com.example.bankaccount.domain.transfer

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.validation.constraints.Positive

@Schema(name = "Transfer's request object")
data class TransferRequest(
    @Schema(example = "100.0")
    @get:Positive
    val amount: BigDecimal,
    @Schema(example = "2")
    val accountFrom: Long,
    @Schema(example = "9")
    val accountTo: Long
) {
    fun toEntity(): TransferEntity = TransferEntity(
        amount = this.amount,
        accountFrom = this.accountFrom,
        accountTo = this.accountTo,
        createdTime = LocalDateTime.now()
    )
}
