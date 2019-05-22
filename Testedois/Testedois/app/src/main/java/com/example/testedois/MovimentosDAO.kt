package com.example.testedois

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface MovimentosDAO {
    @Query("SELECT*FROM movimentos where numId = :numId")
    fun getByIdM(numId:Long):Movimentos?

    @Query("SELECT*FROM movimentos")
    fun findallM():List<Movimentos>

    @Insert
    fun insertM(movimentos:Movimentos)

    @Delete
    fun deleteM(movimentos:Movimentos)
}