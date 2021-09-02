package com.example.apppruebaatlantico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.apppruebaatlantico.Clases.Especialidad
import com.example.apppruebaatlantico.ComsumeApis.EndPoints
import com.example.apppruebaatlantico.ComsumeApis.NetworksUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class especialidadCasa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidad_casa)
        findViewById<Button>(R.id.btncontinuar3).setOnClickListener {
            val bundle=intent.extras
            val intent=Intent(this,Home::class.java).apply {
                putExtra("nombres",bundle?.getString("nombres"))
                putExtra("email",bundle?.getString("mail"))
            }
            startActivity(intent)
        }
        findViewById<Button>(R.id.btniniciar2).setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }
        getdata()
    }

    private fun getdata() {
        val retrofitClie=NetworksUtils.getRetrofitInstance()
        val endpoints=retrofitClie.create(EndPoints::class.java)
        val callback=endpoints.getEspecialidad()
        callback.enqueue(object:Callback<Especialidad>{
            override fun onResponse(call: Call<Especialidad>, response: Response<Especialidad>) {
                val info=response.body()
                findViewById<TextView>(R.id.tvdescripcion).setText("Nombre: ${info?.datos?.nombre}\n" +
                                                                    "Descripcion: '${info?.datos?.descripcion}' \n" +
                                                                    "Precio:  $ ${info?.datos?.precio.toString()}")
            }

            override fun onFailure(call: Call<Especialidad>, t: Throwable) {
                Toast.makeText(baseContext,"ERROR,${t.message}",Toast.LENGTH_SHORT).show()
            }
        })
    }
}