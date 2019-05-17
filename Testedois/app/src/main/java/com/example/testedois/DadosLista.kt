package com.example.testedois

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable
import org.json.JSONObject


@Entity(tableName = "dados")
class DadosLista :Serializable{


            @PrimaryKey
            var codCartao:Long = 0
            var nomeEmpresa = ""
            var saldo = ""
            var dtUltimoUpdate = ""
            var nome = ""
            var CodEmpresa = ""
            var movimentos = ""

            override fun toString(): String {
                return "DadosList $nomeEmpresa"
            }


            fun toJson(): String {
                return GsonBuilder().create().toJson(this)
            }


}