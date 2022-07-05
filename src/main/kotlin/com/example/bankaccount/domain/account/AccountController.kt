package com.example.bankaccount.domain.account

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(
    private val accountService: AccountService
) {
    @GetMapping("/{accountId}")
    fun getAccountDetails(
        @PathVariable accountId: Long
    ): AccountDto {
        return accountService.getAccountDetails(accountId)
    }
}
