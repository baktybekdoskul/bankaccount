package com.example.bankaccount.domain.transfer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransferRepository : JpaRepository<TransferEntity, Long>
