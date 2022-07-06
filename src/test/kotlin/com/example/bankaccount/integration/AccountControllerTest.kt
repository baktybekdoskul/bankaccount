package com.example.bankaccount.integration

import com.example.bankaccount.domain.account.AccountDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AccountControllerTest : IntegrationTestSetup() {
    @BeforeEach
    fun setUp() {
        URL = "$BASE_URL:$port/account"
    }
    @Test
    fun `getAccountById - should return account by its ID`() {
        val account = account(9879.0)
        val response = restTemplate.getForEntity("$URL/${account.id}", String::class.java)
        val result = jacksonObjectMapper().readValue<AccountDto>(response.body.toString())
        Assertions.assertEquals(account.id, result.id)
        Assertions.assertEquals(account.balance, result.balance)
        Assertions.assertEquals(account.user.surname, result.user.surname)
    }
}
