package com.example.iPet

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telagabriel.R
import com.example.iPet.adapter.AdapterProdutos
import com.example.iPet.model.PetshopModel
import com.example.iPet.model.ProdutosModel
import java.io.Serializable

class ProdutoPetshop : AppCompatActivity()  {


    val listaProdutoPetshop: MutableList<ProdutosModel> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos_petshop)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        getConfiguracaoAdapter()

        val dadosPetshop = intent.extras
        var nomePetshop = dadosPetshop?.getString("nomePet")
        var imagemPetshop = dadosPetshop?.getInt("fotoPetshop")
        var kmPetshop = dadosPetshop?.getString("km")
        var telPetshop = dadosPetshop?.getInt("telefone")
        var idPetshop = dadosPetshop?.getInt("idPetshop")

        val titlePetshop = findViewById<TextView>(R.id.tv_nome_petshop_produtos)
        titlePetshop.setText(nomePetshop)

        val TvkmPetshop = findViewById<TextView>(R.id.tv_km_pet)
        TvkmPetshop.setText(kmPetshop)

        val TvTelPetshop = findViewById<TextView>(R.id.tv_telefone_pet)
        TvTelPetshop.setText("(11) ${telPetshop.toString()}")

        val imagemPet = findViewById<ImageView>(R.id.iv_imagem_petshop)
        imagemPet.setImageResource(imagemPetshop!!)
    }

    private fun getConfiguracaoAdapter() {
        val recyclerView_produtos_petshop = findViewById<RecyclerView>(R.id.rc_produtos_petshop)
        recyclerView_produtos_petshop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_produtos_petshop.setHasFixedSize(true)
        val adapterProdutos = AdapterProdutos(this, listaProdutoPetshop)

        adapterProdutos.onClickListener = { produtos ->
            clickbtn(produtos)
        }
        recyclerView_produtos_petshop.adapter = adapterProdutos
        itensListaProdutos()
    }

    private fun itensListaProdutos() {
        val p1 = ProdutosModel(1,
            "Ra????o GranPlus Menu Frango e Arroz para C??es Adultos",
            199.99,
            "Ra????o",
            "- Manuten????o da massa muscular, com fontes nobres de prote??na;\n" +
                    "- ??timo equil??brio intestinal, com polpa de beterraba e prebi??tico MOS;",
            "GranPlus",
            R.drawable.racao1,
            )
        val p2 = ProdutosModel(1,
            "Ra????o Magnus Todo Dia Sabor Carne para C??es Adultos",
            179.00,
            "Ra????o",
            "- Cont??m sel??nio org??nico e antioxidantes que combatem os radicais livres;\n" +
                    "- Indicado para cachorros acima de 12 meses;",
            "Magnus",
            R.drawable.racao2,
        )
        listaProdutoPetshop.add(p1)
        listaProdutoPetshop.add(p2)
    }

    private fun clickbtn(produtos: ProdutosModel) {
        val telaProdutoDatalhe = Intent(this, Produto::class.java)

        telaProdutoDatalhe.putExtra("idProduto", produtos.idProduto)
        telaProdutoDatalhe.putExtra("nomeProduto", produtos.nomeProduto)
        telaProdutoDatalhe.putExtra("preco", produtos.preco)
        telaProdutoDatalhe.putExtra("descricao", produtos.descricao)
        telaProdutoDatalhe.putExtra("marca", produtos.marca)
        telaProdutoDatalhe.putExtra("categoria", produtos.categoria)
        telaProdutoDatalhe.putExtra("fotoProduto", produtos.fotoProduto)
        telaProdutoDatalhe.putExtra("idPetshop", produtos.idPetshop)
        startActivity(telaProdutoDatalhe)
    }
}