package com.example.testedois.Rest

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import com.example.testedois.DadoApplication
import com.example.testedois.DadosLista
import com.example.testedois.DatabaseManager
import com.example.testedois.Response
import com.example.testedois.Rest.DadosService.host
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DadosService {

    val host = "https://app.gdscartao.com.br"
    val TAG = "WS_LMSApp"

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getDados(context: Context): List<DadosLista> {
        var dados = ArrayList<DadosLista>()
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/unisabor?querycard=16150001503&pin=N6E4F7KIC6&qcapi"
            val json = HttpHelper.get(url)
            dados = parserJson(json)

            for (d in dados) {
                saveOffline(d)
            }

            return dados
        } else {
            val dao = DatabaseManager.getDadosDAO()
            val dados = dao.findAll()
            return dados
        }
    }

    fun save(dados: DadosLista): Response {
        var json = HttpHelper.post("$host/unisabor?querycard=16150001503&pin=N6E4F7KIC6&qcapi", dados.toJson())
        return parserJson(json)
    }

    fun saveOffline(dados: DadosLista): Boolean {
        val dao = DatabaseManager.getDadosDAO()

        if (!existeDado(dados)) {
            dao.insert(dados)
        }

        return true

    }

    fun existeDado(dados: DadosLista): Boolean {
        val dao = DatabaseManager.getDadosDAO()
        return dao.getById(dados.codCartao) != null
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun delete(dados: DadosLista): Response {
        if (AndroidUtils.isInternetDisponivel(DadoApplication.getInstance().applicationContext)) {
            val url = "$host/unisabor?querycard=16150001503&pin=N6E4F7KIC6&qcapi/${dados.codCartao}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = DatabaseManager.getDadosDAO()
            dao.delete(dados)
            return Response(status = "OK", msg = "Dados salvos ")
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }
}
