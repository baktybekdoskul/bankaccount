package com.example.bankaccount.domain.user

import javax.persistence.*

@Entity
@Table(name = "s_user")
data class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val surname: String
)
