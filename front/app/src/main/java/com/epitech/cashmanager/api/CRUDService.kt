package com.epitech.cashmanager.api

interface CRUDService {
    val path : String

    suspend fun <T> create(query : T)

    suspend fun <T> read(query : T)

    suspend fun <T> update(query : T)

    suspend fun <T> delete(query : T)
}