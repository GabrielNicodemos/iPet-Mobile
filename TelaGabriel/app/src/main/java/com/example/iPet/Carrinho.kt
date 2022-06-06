package com.example.iPet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telagabriel.R
import com.example.iPet.adapter.AdapterPetshop
import com.example.iPet.adapter.AdapterProdutos
import com.example.iPet.model.PetshopModel
import com.example.iPet.model.ProdutosModel

class Carrinho: AppCompatActivity() {


    val listaProdutosCarrinho: MutableList<ProdutosModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        val recyclerView_produtosCarrinho = findViewById<RecyclerView>(R.id.rv_produtos_carriho)

        val dadosProduto = intent.extras
        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var imagemProduto = dadosProduto?.getInt("fotoProduto")
        var preco = dadosProduto?.getDouble("preco")
        var descricao = dadosProduto?.getString("descricao")
        var marca = dadosProduto?.getString("marca")
        var categoria = dadosProduto?.getString("categoria")
        var idPetshop = dadosProduto?.getInt("idPetshop")
        var idProduto = dadosProduto?.getInt("idProduto")


        recyclerView_produtosCarrinho.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_produtosCarrinho.setHasFixedSize(true)
        val adapterProduto = AdapterProdutos(this, listaProdutosCarrinho)
        adapterProduto.onClickListener = { produto ->
            clickbtn(produto)
        }
        recyclerView_produtosCarrinho.adapter = adapterProduto

        itensListaProdutos()

    }

    private fun itensListaProdutos() {
        val dadosProduto = intent.extras
        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var imagemProduto = dadosProduto?.getInt("fotoProduto")
        var preco = dadosProduto?.getDouble("preco")
        var descricao = dadosProduto?.getString("descricao")
        var marca = dadosProduto?.getString("marca")
        var categoria = dadosProduto?.getString("categoria")
        var idPetshop = dadosProduto?.getInt("idPetshop")
        var idProduto = dadosProduto?.getInt("idProduto")
        val p1 = ProdutosModel(idProduto, nomeProduto, preco, categoria, descricao, marca,imagemProduto, idPetshop)
        listaProdutosCarrinho.add(p1)
    }

    fun irTelaProdutos(view: View) {
        val telaProdutos = Intent(this, ProdutoPetshop::class.java)
        Toast.makeText(baseContext, "Compra realizada com sucesso", Toast.LENGTH_SHORT).show()
        startActivity(telaProdutos)
    }
    fun irTelaPedidos(view: View) {
        val telaPedidos = Intent(this, Pedidos::class.java)
        Toast.makeText(baseContext, "Compra cancelada", Toast.LENGTH_SHORT).show()
        startActivity(telaPedidos)
    }


    private fun clickbtn(produtos: ProdutosModel) {

    }

}