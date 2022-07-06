package com.example.bankaccount.domain.account

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Optional
import javax.persistence.LockModeType

@Repository
interface AccountRepository : JpaRepository<AccountEntity, Long> {
    @Transactional
    @Lock(value = LockModeType.PESSIMISTIC_WRITE) // TODO Pessimistic read or write
    override fun findById(id: Long): Optional<AccountEntity>
}
