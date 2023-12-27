package com.example.consrestapi

import android.app.Application
import com.example.consrestapi.repository.AppContainer
import com.example.consrestapi.repository.KontakContainer

class KontakAplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}