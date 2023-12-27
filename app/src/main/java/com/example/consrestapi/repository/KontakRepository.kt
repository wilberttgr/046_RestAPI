package com.example.consrestapi.repository

import com.example.consrestapi.model.Kontak
import com.example.consrestapi.service_api.KontakService

interface KontakRepository{
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository{
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}