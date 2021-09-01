package com.example.apppruebaatlantico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import com.example.apppruebaatlantico.Clases.Categorias
import com.example.apppruebaatlantico.JSON.CategoriasJSON
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val lista=findViewById<ListView>(R.id.listacate)
        val gson= Gson()
        val categorias:Categorias=gson.fromJson(CategoriasJSON().onCreate(),Categorias::class.java)
        val array= arrayListOf<String>()
        for (i in 0 downTo categorias.datos.count()){
            array[i]=categorias.datos.get(i).nombre
        }
        val adapatador=ArrayAdapter(this,android.R.layout.simple_list_item_1,array)
        lista.adapter=adapatador
    }

}