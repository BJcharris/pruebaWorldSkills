package com.example.apppruebaatlantico

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.apppruebaatlantico.Clases.categoria
import com.example.apppruebaatlantico.Clases.productos
import kotlinx.android.synthetic.main.listapersonalizada.view.*
import kotlinx.android.synthetic.main.listapersonalizada.view.imagenProd
import kotlinx.android.synthetic.main.listapersonalizada.view.tvnombrecat
import kotlinx.android.synthetic.main.listapersonalizada2.view.*

class ListAdapterprod(context: Context, private val listaproducto:List<productos>):
    ArrayAdapter<productos>(context,0,listaproducto) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout= LayoutInflater.from(context).inflate(R.layout.listapersonalizada2,parent,false)
        val lista=listaproducto[position]

        layout.tvnombrecat.text=lista.nombre
        layout.tvdescripcioncat.text=lista.descripcion
        layout.tvprecio.text=lista.precio.toString()
        Glide.with(context).load(lista.url_imagen).into(layout.imagenProd)

        return layout
    }
}