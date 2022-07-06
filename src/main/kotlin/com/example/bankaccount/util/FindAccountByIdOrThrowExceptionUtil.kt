package com.example.bankaccount.util

import com.example.bankaccount.error.AccountNotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

inline fun <reified T : Any, IDType> JpaRepository<T, IDType>.findByIdOrThrowException(id: IDType): T =
    findByIdOrNull(id) ?: throw AccountNotFoundException("there is no ${T::class.java.simpleName} with id $id")
