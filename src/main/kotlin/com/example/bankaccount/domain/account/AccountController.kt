package com.example.bankaccount.domain.account

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
@Tag(name = "Controller for account operations.")
class AccountController(
    private val accountService: AccountService
) {
    @Operation(summary = "Get account details by id")
    @GetMapping("/{accountId}")
    fun getAccountDetails(
        @PathVariable accountId: Long
    ): AccountDto {
        return accountService.getAccountDetails(accountId)
    }
}
