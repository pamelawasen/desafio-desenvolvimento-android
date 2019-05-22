package com.example.testedois

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "movimentos")
@TypeConverters(convertet::class)
class Movimentos: Serializable {

        @PrimaryKey
        var numId = ""
        var codProduto = ""
        var quantidade = ""
        var vlTotal = ""
        var dtOcorrencia = ""
        var operacaoDC = ""
        var descricao = ""
        var cancelado = ""

        override fun toString(): String {
                return "DadosList $numId"
        }


        fun toJson(): String {
                return GsonBuilder().create().toJson(this)
        }
}