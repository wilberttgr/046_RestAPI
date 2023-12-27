package com.example.consrestapi.repository

import com.example.consrestapi.service_api.KontakService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val kontakRepository: KontakRepository
}

class KontakContainer : AppContainer{
    private val baseUrl = "http://10.0.2.2:8080"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val kontakService: KontakService by lazy {
        retrofit.create(KontakService::class.java)
    }

    override val kontakRepository: KontakRepository by lazy {
        NetworkKontakRepository(kontakService)
    }
}