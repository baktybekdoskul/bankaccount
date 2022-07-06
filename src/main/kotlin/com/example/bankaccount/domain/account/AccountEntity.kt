package com.example.bankaccount.domain.account

import com.example.bankaccount.domain.user.UserEntity
import com.example.bankaccount.domain.user.toDto
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "account")
data class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var balance: BigDecimal,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserEntity
)

fun AccountEntity.toDto(): AccountDto {
    return AccountDto(this.id, this.balance, this.user.toDto())
}
