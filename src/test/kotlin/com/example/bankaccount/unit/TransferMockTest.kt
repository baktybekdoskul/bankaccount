package com.example.bankaccount.unit

import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class TransferMockTest {
//    @MockK
//    private lateinit var transferRepository: TransferRepository
//
//    @MockK
//    private lateinit var accountRepository: AccountRepository
//
//    @InjectMockKs
//    private lateinit var transferService: TransferService
//
//    companion object {
//        const val ACCOUNT_FROM_ID = 1L
//        const val ACCOUNT_TO_ID = 2L
//    }
//    @Test
//    fun `save - should perform money transfer between accounts`() {
//        val request = mockk<TransferRequest>(relaxed = true) {
//            every { accountFrom } returns ACCOUNT_FROM_ID
//            every { accountTo } returns ACCOUNT_TO_ID
//            every { amount } returns BigDecimal(500.0)
//        }
//        val account1 = mockk<AccountEntity>(relaxed = true) {
//            every { id } returns ACCOUNT_FROM_ID
//            every { balance } returns BigDecimal(1000.0)
//        }
//        val account2 = mockk<AccountEntity>(relaxed = true) {
//            every { id } returns ACCOUNT_TO_ID
//            every { balance } returns BigDecimal(0.0)
//        }
//        every { accountRepository.findByIdOrNull(ACCOUNT_FROM_ID) } returns account1
//        every { accountRepository.findByIdOrNull(ACCOUNT_TO_ID) } returns account2
//        transferService.save(request)
//        verify {
//            accountRepository.save(account1)
//            accountRepository.save(account2)
//        }
//    }
}
