package com.example.bankaccount.integration

import com.example.bankaccount.domain.account.AccountEntity
import com.example.bankaccount.domain.account.AccountRepository
import com.example.bankaccount.domain.user.UserEntity
import com.example.bankaccount.domain.user.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal
import java.util.concurrent.atomic.AtomicLong

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTestSetup {
    @LocalServerPort
    protected val port: Int = 0

    protected val BASE_URL = "http://localhost"

    protected val restTemplate: RestTemplate = RestTemplate()
    protected var URL: String = ""

    @Autowired
    protected lateinit var accountRepository: AccountRepository

    @Autowired
    protected lateinit var userRepository: UserRepository

    protected val idSequence = AtomicLong(0)
    protected fun uniqueNumber() = idSequence.incrementAndGet()

    protected fun account(balance: BigDecimal) = AccountEntity(
        user = user(),
        balance = balance
    ).let { accountRepository.save(it) }

    protected fun user() = uniqueNumber().let { ID ->
        UserEntity(
            name = "Oleg$ID",
            surname = "Pavlov$ID"
        ).let { userRepository.save(it) }
    }
}
