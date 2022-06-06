package com.example.iPet

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telagabriel.R
import com.example.iPet.adapter.AdapterPetshop
import com.example.iPet.api.ApiServices
import com.example.iPet.model.PetshopModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Petshop : AppCompatActivity() {
    val listaPetshops: MutableList<PetshopModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petshop)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        itensListaPetshop()

        val recyclerView_petshop = findViewById<RecyclerView>(R.id.lista_petshops)

        recyclerView_petshop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_petshop.setHasFixedSize(true)
        val adapterPet = AdapterPetshop(this, listaPetshops)
        adapterPet.onClickListener = { pet ->
            clickbtn(pet)
        }
        recyclerView_petshop.adapter = adapterPet


    }

    private fun clickbtn(petshop: PetshopModel) {
        val telaProdutosPetshop = Intent(this, ProdutoPetshop::class.java)
        telaProdutosPetshop.putExtra("nomePet", petshop.nome)
        telaProdutosPetshop.putExtra("km", petshop.km)
        telaProdutosPetshop.putExtra("telefone", petshop.telefone)
        telaProdutosPetshop.putExtra("idPetshop", petshop.idPetshop)
        telaProdutosPetshop.putExtra("fotoPetshop", petshop.fotoPetshop)
        startActivity(telaProdutosPetshop)
    }

    private fun itensListaPetshop() {
        println("Entrou aqui")

        val pet1 = PetshopModel(1, "Cobasi", 955554444, "Aberto", "6 KM", R.drawable.cobasi)
        val pet2 = PetshopModel(2, "Pets", 999994444, "Aberto", "14 KM", R.drawable.petz)
        val pet3 = PetshopModel(3, "Petlove", 959994444, "Fechado", "2 KM", R.drawable.petlove)
        listaPetshops.add(pet1)
        listaPetshops.add(pet2)
        listaPetshops.add(pet3)
    }
}





