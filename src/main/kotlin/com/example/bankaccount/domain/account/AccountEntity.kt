package com.example.bankaccount.domain.account

import com.example.bankaccount.domain.user.UserEntity
import javax.persistence.*

@Entity
@Table(name = "account")
data class AccountEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val balance: Double,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserEntity
)
