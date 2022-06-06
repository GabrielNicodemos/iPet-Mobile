package com.example.iPet.adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.telagabriel.R
import com.example.telagabriel.databinding.PedidosItemBinding
import com.example.iPet.model.Pedido

class AdapterPedido(
    private val context: Context,
    private val pedidoList: MutableList<Pedido>,
    var onClickListener: (pedido: Pedido) -> Unit = {}
    ): RecyclerView.Adapter<AdapterPedido.PedidoViewHolder>() {


//  Responsavel por criar as visualizações
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder =
    PedidoViewHolder.from(parent)

    //  Responsavel exibir as visualizações em tela
    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val item = pedidoList[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = pedidoList.size

    class PedidoViewHolder(val biding: PedidosItemBinding) : RecyclerView.ViewHolder(biding.root) {
        fun bind(item: Pedido, onClickListener: (pedido: Pedido) -> Unit) {
            with(biding) {
                petshopPedido.setImageResource(item.fotoPetshop)
                nomePetshop.text = item.nomePetshopPedido
                valorPedido.text = item.valorPedido
                statusPedido.text = item.statusPedido
                numeroPedido.text = item.numeroPedido
                llItemPedido.setOnClickListener{
                    onClickListener(item)
                }
            }
        }
        companion object {
            fun from(parent: ViewGroup) : PedidoViewHolder {
                val biding: PedidosItemBinding = PedidosItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return PedidoViewHolder(biding)
            }
        }

    }
}