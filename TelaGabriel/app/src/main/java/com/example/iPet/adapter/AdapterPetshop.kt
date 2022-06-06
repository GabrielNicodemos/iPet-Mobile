package com.example.iPet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iPet.adapter.AdapterPetshop.*
import com.example.telagabriel.databinding.PetshopItemBinding
import com.example.iPet.model.PetshopModel

class AdapterPetshop (private val context: Context,
                      private val petshopList: MutableList<PetshopModel>,
                      var onClickListener: (petshop: PetshopModel) -> Unit = {}
): RecyclerView.Adapter<PetshopViewHolder>() {

    //  Responsavel por criar as visualizações
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPetshop.PetshopViewHolder = AdapterPetshop.PetshopViewHolder.from(parent)

    //  Responsavel exibir as visualizações em tela
    override fun onBindViewHolder(holder: AdapterPetshop.PetshopViewHolder, position: Int) {
        val item = petshopList[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount() = petshopList.size


    class PetshopViewHolder(val biding: PetshopItemBinding) : RecyclerView.ViewHolder(biding.root) {
        fun bind(item: PetshopModel, onClickListener: (petshop: PetshopModel) -> Unit) {
            with(biding) {
                imagemPetshop.setImageResource(item.fotoPetshop!!)
                nomePetshop.text = item.nome
                statusPetshop.text = item.status
                kmPetshop.text = item.km
                numeroPetshop.text = item.telefone.toString()
                llItemPetshop.setOnClickListener{
                    onClickListener(item)
                }
            }
        }
        companion object {
            fun from(parent: ViewGroup) : PetshopViewHolder {
                val biding: PetshopItemBinding = PetshopItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return PetshopViewHolder(biding)
            }
        }

    }




}