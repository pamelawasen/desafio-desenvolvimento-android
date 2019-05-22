package com.example.testedois

import android.arch.persistence.room.*
import com.google.gson.GsonBuilder
import java.io.Serializable
import org.json.JSONObject


@Entity(tableName = "dados")
@TypeConverters(convertet::class)
class DadosLista :Serializable{


            @PrimaryKey
            var codCartao:Long = 0
            var nomeEmpresa = ""
            var saldo = ""
            var dtUltimoUpdate = ""
            var nome = ""
            var CodEmpresa = ""
            var movimentos =  arrayOf<String>()
            /*@Ignore
            var movimentos = arrayOf<String>()*/

            override fun toString(): String {
                return "DadosList $nomeEmpresa"
            }


            fun toJson(): String {
                return GsonBuilder().create().toJson(this)
            }


}