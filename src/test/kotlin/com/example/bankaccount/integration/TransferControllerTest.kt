package com.example.bankaccount.integration

import com.example.bankaccount.domain.account.AccountDto
import com.example.bankaccount.domain.transfer.TransferDto
import com.example.bankaccount.domain.transfer.TransferRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.math.BigDecimal

class TransferControllerTest: IntegrationTestSetup() {
    @BeforeEach
    fun setUp() {
        URL = "$BASE_URL:$port"
    }

    @Test
    fun `addTransfer - should perform money transfer between accounts` () {
        val account1 = account(BigDecimal(1200.0))
        val account2 = account(BigDecimal(2000.0))
        val request = TransferRequest(
            accountFrom = account1.id,
            accountTo = account2.id,
            amount = BigDecimal(300.0)
        )
        val objectMapper = jacksonObjectMapper()
        val response = restTemplate.postForEntity("$URL/transfer", request, String::class.java)
        val transferRes = objectMapper.readValue<TransferDto>(response.body.toString())
        val account1Response = restTemplate.getForEntity("$URL/account/${account1.id}", String::class.java)
        val account2Response = restTemplate.getForEntity("$URL/account/${account2.id}", String::class.java)
        val account1Res = objectMapper.readValue<AccountDto>(account1Response.body.toString())
        val account2Res = objectMapper.readValue<AccountDto>(account2Response.body.toString())
        Assertions.assertEquals(BigDecimal(300.0), transferRes.amount)
        Assertions.assertEquals(account1Res.balance, account1.balance - transferRes.amount)
        Assertions.assertEquals(account2Res.balance, account2.balance + transferRes.amount)
    }
}
