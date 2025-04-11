package com.redditizie.receitasvovo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class ReceitasAdapter(val cliqueBotao: (Receita) -> Unit) : Adapter<ReceitasAdapter.ReceitaViewHolder>() {

    private var listaReceitas = listOf<Receita>()

    fun configurarLista(lista: List<Receita>){

        listaReceitas = lista
        notifyDataSetChanged()

    }


    inner class ReceitaViewHolder(val itemView: View ) : ViewHolder(itemView){


        private var textTitulo: TextView
        private var textTempo: TextView
        private var imgReceita: ImageView
        private var clItem: ConstraintLayout


        init {


            textTitulo = itemView.findViewById(R.id.text_titulo)
            textTempo = itemView.findViewById(R.id.text_tempo)
            imgReceita = itemView.findViewById(R.id.img_receitas)
            clItem = itemView.findViewById(R.id.cl_item)


        }

        fun bind(receita: Receita){

            textTitulo.text = receita.titulo
            textTempo.text = receita.tempo

            imgReceita.setImageDrawable(ContextCompat.getDrawable(itemView.context, receita.idImagem))

            // Evento de clique

            clItem.setOnClickListener {

                cliqueBotao(receita)

            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(
            R.layout.item_receitas,
            parent,
            false
        )
        return ReceitaViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {

        val receita = listaReceitas[position]
        holder.bind( receita)



    }


    override fun getItemCount(): Int {

        return listaReceitas.size

    }

}