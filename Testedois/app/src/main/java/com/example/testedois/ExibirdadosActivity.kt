package com.example.testedois

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.testedois.Rest.DadosService
import kotlinx.android.synthetic.main.activity_exibirdados.*

class ExibirdadosActivity : AppCompatActivity() {

    private val context: Context get() = this
    private var dados = listOf<DadosLista>()
    var recyclerpedidos: RecyclerView? = null

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibirdados)

        recyclerpedidos = recyclePedido
        recyclerpedidos?.layoutManager = LinearLayoutManager(context)
        recyclerpedidos?.itemAnimator = DefaultItemAnimator()
        recyclerpedidos?.setHasFixedSize(true)

        taskDados()
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun taskDados() {

        Thread {

            this.dados = DadosService.getDados(context)
            runOnUiThread {
                recyclerpedidos?.adapter = adapterDados(this.dados) {onClickdados(it) }
            }
        }.start()

    }
    fun onClickdados(dado:DadosLista){
        Toast.makeText(context, " ${dado.nomeEmpresa}", Toast.LENGTH_SHORT).show()

    }
}
