package com.example.consrestapi.repository

import com.example.consrestapi.model.Kontak
import com.example.consrestapi.service_api.KontakService

interface KontakRepository{
    suspend fun getKontak(): List<Kontak>
    suspend fun deleteKontak(id: Int): Boolean
    suspend fun insertKontak(kontak: Kontak): Boolean
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository{
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
    override suspend fun deleteKontak(id: Int): Boolean {
        // Implementasi penghapusan kontak melalui kontakApiService dengan menggunakan id
        val response = kontakApiService.deleteKontak(id)

        // Mengembalikan nilai true jika penghapusan berhasil, false sebaliknya
        return response.isSuccessful
    }

    override suspend fun insertKontak(kontak: Kontak): Boolean {
        // Implementasi penambahan kontak melalui kontakApiService
        val response = kontakApiService.insertKontak(kontak)

        // Mengembalikan nilai true jika penambahan berhasil, false sebaliknya
        return response.isSuccessful
    }
}