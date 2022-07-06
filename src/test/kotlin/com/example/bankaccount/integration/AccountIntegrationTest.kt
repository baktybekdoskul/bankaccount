package com.example.bankaccount.integration

import com.example.bankaccount.domain.account.AccountDto
import com.example.bankaccount.domain.account.AccountEntity
import com.example.bankaccount.domain.account.AccountRepository
import com.example.bankaccount.domain.user.UserEntity
import com.example.bankaccount.domain.user.UserRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.util.concurrent.atomic.AtomicLong

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountIntegrationTest{
    @LocalServerPort
    private val port: Int = 0

    private val BASE_URL = "http://localhost"

    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    private val restTemplate: RestTemplate = RestTemplate()
    private var URL: String = ""


    @BeforeEach
    fun setUp() {
        URL = "$BASE_URL:$port/account"
    }

    private val idSequence = AtomicLong(0)
    private fun uniqueNumber() = idSequence.incrementAndGet()
    @Test
    fun `getAccountById - should return account by its ID`() {
        val account = account()
        val response = restTemplate.getForEntity("$URL/${account.id}", String::class.java)
        val result = jacksonObjectMapper().readValue<AccountDto>(response.body.toString())
        Assertions.assertEquals(account.id, result.id)
        Assertions.assertEquals(account.balance, result.balance)
        Assertions.assertEquals(account.user.surname, result.user.surname)
    }

    private fun account() = AccountEntity(
            user = user(),
            balance = 12500.0
        ).let { accountRepository.save(it) }

    private fun user() = uniqueNumber().let { ID ->
        UserEntity(
            name = "Oleg$ID",
            surname = "Pavlov$ID"
        ).let { userRepository.save(it) }
    }
}