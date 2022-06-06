package com.example.iPet

import android.content.Intent
import android.icu.number.IntegerWidth
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView
import com.example.telagabriel.R

class Produto: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val dadosProduto = intent.extras
        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var imagemProduto = dadosProduto?.getInt("fotoProduto")
        var preco = dadosProduto?.getDouble("preco")
        var descricao = dadosProduto?.getString("descricao")
        var marca = dadosProduto?.getString("marca")
        var categoria = dadosProduto?.getString("categoria")
        var idPetshop = dadosProduto?.getInt("idPetshop")
        var idProduto = dadosProduto?.getInt("idProduto")

        val iv_imagemProduto = findViewById<ImageView>(R.id.iv_imagem_produto)
        iv_imagemProduto.setImageResource(imagemProduto!!)

        val tv_nomeProduto = findViewById<TextView>(R.id.tv_nome_produto)
        tv_nomeProduto.text = nomeProduto

        val tv_descProduto = findViewById<TextView>(R.id.tv_desc_produto)
        tv_descProduto.text = descricao

        val tv_preco_produto = findViewById<TextView>(R.id.tv_preco_produto)
        tv_preco_produto.text = preco.toString()
    }

    fun adicionarProduto(view: View) {
        val quantidade = findViewById<TextView>(R.id.tv_quantidade_produto)
        val valorProduto = findViewById<TextView>(R.id.tv_preco_produto)
        val qtd = Integer.parseInt(quantidade.text.toString()) + 1
        quantidade.text = qtd.toString()
        val dadosProduto = intent.extras
        var preco = dadosProduto?.getDouble("preco")
        var somaValorTotal = preco.toString().toFloat() * quantidade.text.toString().toInt()
        valorProduto.text = somaValorTotal.toString()
    }

    fun subtrairProduto(view: View) {
        val quantidade = findViewById<TextView>(R.id.tv_quantidade_produto)
        val valorProduto = findViewById<TextView>(R.id.tv_preco_produto)
        var qtd = 0
        if (quantidade.text.toString().toInt() > 1) {
            qtd = Integer.parseInt(quantidade.text.toString()) - 1
        }
        quantidade.text = qtd.toString()

        val dadosProduto = intent.extras
        var preco = dadosProduto?.getDouble("preco")
        var somaValorTotal = preco.toString().toFloat() * quantidade.text.toString().toInt()
        valorProduto.text = somaValorTotal.toString()
    }

    fun irTelaCarrinho(v: View) {

        val telaCarrinho = Intent(this, Carrinho::class.java)

        val dadosProduto = intent.extras
        var nomeProduto = dadosProduto?.getString("nomeProduto")
        var imagemProduto = dadosProduto?.getInt("fotoProduto")
        var preco = dadosProduto?.getDouble("preco")
        var descricao = dadosProduto?.getString("descricao")
        var marca = dadosProduto?.getString("marca")
        var categoria = dadosProduto?.getString("categoria")
        var idPetshop = dadosProduto?.getInt("idPetshop")
        var idProduto = dadosProduto?.getInt("idProduto")
        telaCarrinho.putExtra("idProduto", idProduto)
        telaCarrinho.putExtra("nomeProduto",nomeProduto)
        telaCarrinho.putExtra("preco", preco)
        telaCarrinho.putExtra("descricao", descricao)
        telaCarrinho.putExtra("marca", marca)
        telaCarrinho.putExtra("categoria", categoria)
        telaCarrinho.putExtra("fotoProduto", imagemProduto)
        telaCarrinho.putExtra("idPetshop", idPetshop)


        startActivity(telaCarrinho)
    }
}