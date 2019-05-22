package com.example.testedois

import android.app.Application
import java.lang.IllegalStateException

class DadoApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        // singleton
        private var appInstance: DadoApplication?  = null
        fun getInstance(): DadoApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }
    override fun onTerminate() {
        super.onTerminate()
    }

}