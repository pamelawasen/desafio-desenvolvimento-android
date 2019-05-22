package com.example.testedois

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Room


object DatabaseManager {

    // singleton
    private var dbInstance: GDSDatabase
    init {
        val appContext = DadoApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(appContext, GDSDatabase::class.java, "gds.sqlite"
        ).build()
    }

    fun getDadosDAO(): DadosDAO {
        return dbInstance.getDadosDAO()
    }

}