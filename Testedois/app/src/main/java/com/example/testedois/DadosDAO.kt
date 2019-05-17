package com.example.testedois

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface DadosDAO {

    @Query("SELECT * FROM dados where codCartao = :codCartao")
    fun getById(codCartao: Long) : DadosLista?
    @Query("SELECT * FROM dados")
    fun findAll(): List<DadosLista>
    @Insert
    fun insert(disciplina: DadosLista)
    @Delete
    fun delete(disciplina: DadosLista)
}