package com.example.consrestapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kontak(
    val id: Int,
    val nama: String,
    @SerialName("email")
    val email: String,
    @SerialName("nohp")
    val telpon: String,
)
