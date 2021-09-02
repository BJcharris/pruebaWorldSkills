package com.example.apppruebaatlantico

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.apppruebaatlantico.Clases.categoria
import kotlinx.android.synthetic.main.listapersonalizada.view.*

class ListAdapter(context: Context,private val listacategoria:List<categoria>):ArrayAdapter<categoria>(context,0,listacategoria) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout=LayoutInflater.from(context).inflate(R.layout.listapersonalizada,parent,false)
        val lista=listacategoria[position]

        layout.tvnombrecat.text=lista.nombre
        layout.tvdescripcioncat.text=lista.descripcion
        Glide.with(context).load(lista.url_imagen).into(layout.imagenProd)

        return layout
    }
}