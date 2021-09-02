package com.example.apppruebaatlantico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.apppruebaatlantico.Clases.Especialidad
import com.example.apppruebaatlantico.Clases.categoria
import com.example.apppruebaatlantico.Clases.categorias
import com.example.apppruebaatlantico.ComsumeApis.EndPoints
import com.example.apppruebaatlantico.ComsumeApis.NetworksUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {
    val registro= mutableListOf<categoria>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bundle=intent.extras
        findViewById<TextView>(R.id.tvuser).setText(bundle?.getString("nombres"))

        getdataCategorias()

        findViewById<ListView>(R.id.listcategorias).setOnItemClickListener { adapterView, view, i, l ->
            val intent=Intent(this,Verproductodecategoria::class.java).apply {
                putExtra("ID",registro.get(i).id)
            }
            startActivity(intent)
        }

        //val lista= listOf<categoria>(categoria)
        //val adaptador=ListAdapter(this,lista)
        //findViewById<ListView>(R.id.listcategorias).adapter=adaptador
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item1->{
                true
            }
            R.id.item2->{
                startActivity(Intent(this,Login::class.java))
                finish()
                true
            }
            R.id.itembag->{
                true
            }
            else->super.onContextItemSelected(item)
        }
    }
    private fun getdataCategorias() {
        val retrofitClie= NetworksUtils.getRetrofitInstance()
        val endpoints=retrofitClie.create(EndPoints::class.java)
        val callback=endpoints.getcategorias()
        callback.enqueue(object: Callback<categorias> {
            override fun onResponse(call: Call<categorias>, response: Response<categorias>) {
                val registros=response?.body()?.datos
                for (i in 0..3){
                    val cat=categoria(registros?.get(i)?.id,registros?.get(i)?.nombre,registros?.get(i)?.descripcion,registros?.get(i)?.url_imagen)
                    registro.add(cat)
                }
                val adaptadorlista=ListAdapter(baseContext,registro)
                findViewById<ListView>(R.id.listcategorias).adapter=adaptadorlista
            }

            override fun onFailure(call: Call<categorias>, t: Throwable) {
                Toast.makeText(baseContext,"ERROR,${t.message}",Toast.LENGTH_SHORT).show()
                println("No funciona ERROR ${t.message}")
            }
        })
    }
}