package com.example.testedois


import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

// anotação define a lista de entidades e a versão do banco
@Database(entities = arrayOf(DadosLista::class), version = 1)
abstract class LMSDatabase: RoomDatabase() {
    abstract fun disciplinaDAO(): DadosDAO
}