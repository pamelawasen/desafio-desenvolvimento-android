package com.example.testedois

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.adapterdados.view.*

class adapterDados(
    val dados:List<DadosLista>,
    val onclick:(DadosLista)->Unit):RecyclerView.Adapter<adapterDados.DadoslistaViewHolder>(){

    class DadoslistaViewHolder(view: View):RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardBody: TextView
        val cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.cardNome
            cardProgress = view.cardprogress
            cardView = view.cardlistap
            cardBody = view.cardbody
        }
    }
    override fun getItemCount()= this.dados.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):DadoslistaViewHolder{

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapterdados,parent,false)
        val holder = DadoslistaViewHolder(view)
        return holder
    }
    override fun onBindViewHolder(holder: DadoslistaViewHolder, position: Int) {
        val context = holder.itemView.context
        val dados1 = this.dados[position]

        holder.cardNome.text = dados1.nomeEmpresa
        holder.cardBody.text = dados1.nome
        holder.cardProgress.visibility = View.GONE
        holder.itemView.setOnClickListener {onclick(dados1)}
    }
}