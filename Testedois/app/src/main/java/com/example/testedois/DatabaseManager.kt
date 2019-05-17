package com.example.testedois

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Room


object DatabaseManager {

    // singleton
    private var dbInstance: LMSDatabase
    init {
        val appContext = DadoApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            LMSDatabase::class.java, // Referência da classe do banco
            "lms.sqlite" // nome do arquivo do banco
        ).build()
    }

    fun getDadosDAO(): DadosDAO {
        return dbInstance.disciplinaDAO()
    }
}