package com.example.bankaccount.domain.transfer

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/transfer")
@Tag(name = "Controller for transfers.")
class TransferController(
    private val transferService: TransferService
) {

    @Operation(summary = "Add new transfer")
    @PostMapping
    fun addTransfer(
        @Valid @RequestBody request: TransferRequest
    ): TransferDto {
        return transferService.save(request)
    }
}
