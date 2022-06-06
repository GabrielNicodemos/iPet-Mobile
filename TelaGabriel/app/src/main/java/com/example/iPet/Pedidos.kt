package com.example.iPet

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telagabriel.R
import com.example.iPet.adapter.AdapterPedido
import com.example.iPet.model.Pedido

class Pedidos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        //      Listando Horizontalmente
        recyclerView_pedidos_abertos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //      Melhora o desempenho da RecycleView
        recyclerView_pedidos_abertos.setHasFixedSize(true)
        //     Configurar Adpater
        val listaPedidoAberto: MutableList<Pedido> = mutableListOf()
        val adapterPedidoAberto = AdapterPedido(this, listaPedidoAberto)
        adapterPedidoAberto.onClickListener = { pedido ->
            clickbtn(pedido)
        }
        recyclerView_pedidos_abertos.adapter = adapterPedidoAberto


        

        //      Listando Horizontalmente
        recyclerView_pedidos_andamento.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //      Melhora o desempenho da RecycleView
        recyclerView_pedidos_andamento.setHasFixedSize(true)
        //     Configurar Adpater
        val listaPedidoAndamento: MutableList<Pedido> = mutableListOf()
        val adapterPedidoAndamento = AdapterPedido(this, listaPedidoAndamento)
        adapterPedidoAndamento.onClickListener = { pedido ->
            clickbtn(pedido)
        }
        recyclerView_pedidos_andamento.adapter = adapterPedidoAndamento

        //      Listando Horizontalmente
        recyclerView_pedidos_finalizados.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //      Melhora o desempenho da RecycleView
        recyclerView_pedidos_finalizados.setHasFixedSize(true)
//     Configurar Adpater
        val listaPedidoFinalizado: MutableList<Pedido> = mutableListOf()
        val adapterProdutoFinalizado = AdapterPedido(this, listaPedidoFinalizado)
        adapterProdutoFinalizado.onClickListener = { pedido ->
            clickbtn(pedido)
        }
        recyclerView_pedidos_finalizados.adapter = adapterProdutoFinalizado

//      Pedidos com status Aberto
        val pedido1 = Pedido(
            R.drawable.cobasi,
            "Cobasi",
            "Aberto",
            "R$ 120,00",
            "Nº 1344"
        )

        val pedido2 = Pedido(
            R.drawable.petz,
            "Petz",
            "Andamento",
            "R$ 3020,00",
            "Nº 1345"
        )

        val pedido3 = Pedido(
            R.drawable.petlove,
            "Petlove",
            "Aberto",
            "R$ 300,00",
            "Nº 1349"
        )

        //      Pedidos com status Andamento
        val pedido4 = Pedido(
            R.drawable.cobasi,
            "Cobasi",
            "Andamento",
            "R$ 120,00",
            "Nº 1344"
        )

        //      Pedidos com status Finalizado
        val pedido5 = Pedido(
            R.drawable.petz,
            "Petz",
            "Finalizado",
            "R$ 3020,00",
            "Nº 1345"
        )
        val pedido6 = Pedido(
            R.drawable.petlove,
            "Petlove",
            "Finalizado",
            "$ 300,00",
            "Nº 1349"
        )


        listaPedidoAberto.add(pedido1)
        listaPedidoAberto.add(pedido2)
        listaPedidoAberto.add(pedido3)
        listaPedidoAndamento.add(pedido4)
        listaPedidoFinalizado.add(pedido5)
        listaPedidoFinalizado.add(pedido6)
    }
    fun irStatusAberto(v: View) {
        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        recyclerView_pedidos_abertos.visibility = View.VISIBLE
        recyclerView_pedidos_andamento.visibility = View.INVISIBLE
        recyclerView_pedidos_finalizados.visibility = View.INVISIBLE
    }

    fun irStatusAndamento(v: View) {
        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        recyclerView_pedidos_abertos.visibility = View.INVISIBLE
        recyclerView_pedidos_andamento.visibility = View.VISIBLE
        recyclerView_pedidos_finalizados.visibility = View.INVISIBLE
    }

    fun irStatusFinalizado(v: View) {
        //      Recuperando recycleView da Activity
        val recyclerView_pedidos_abertos = findViewById<RecyclerView>(R.id.lista_pedidos_aberto)
        val recyclerView_pedidos_andamento = findViewById<RecyclerView>(R.id.lista_pedidos_andamento)
        val recyclerView_pedidos_finalizados = findViewById<RecyclerView>(R.id.lista_pedidos_finalizado)

        recyclerView_pedidos_abertos.visibility = View.INVISIBLE
        recyclerView_pedidos_andamento.visibility = View.INVISIBLE
        recyclerView_pedidos_finalizados.visibility = View.VISIBLE
    }

    fun clickbtn(pedido: Pedido) {
        println("Cliquei aqui"+ pedido.toString())
    }

}