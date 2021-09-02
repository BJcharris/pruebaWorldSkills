package com.example.apppruebaatlantico

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.apppruebaatlantico.Clases.categoria
import kotlinx.android.synthetic.main.listapersonalizada.view.*

class ListAdaptadorProducto(context: Context, private val listaproducto:List<categoria>):
    ArrayAdapter<categoria>(context,0,listaproducto) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout= LayoutInflater.from(context).inflate(R.layout.listapersonalizada,parent,false)
        val lista=listaproducto[position]

        layout.tvnombrecat.text=lista.nombre
        layout.tvdescripcioncat.text=lista.descripcion
        Glide.with(context).load(lista.url_imagen).into(layout.imagenProd)

        return layout
    }
}