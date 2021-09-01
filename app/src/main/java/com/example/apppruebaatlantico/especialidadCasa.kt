package com.example.apppruebaatlantico

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.apppruebaatlantico.ComsumeApis.EndPointsEspecialidad
import com.example.apppruebaatlantico.ComsumeApis.NetworksUtils
import com.example.apppruebaatlantico.ComsumeApis.PostEspecialidad
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class especialidadCasa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidad_casa)
        //getdata()
        val preferencias=getSharedPreferences("especialidad", Context.MODE_PRIVATE)
        findViewById<TextView>(R.id.tvdescripcion). setText("nombre: ${preferencias.getString("nombre",null)}\n" +
                "descripcion : ${preferencias.getString("descripcion", null)}\n" +
                "precio : ${preferencias.getInt("precio", 0)}")
        findViewById<Button>(R.id.btncontinuar3).setOnClickListener {
            startActivity(Intent(this,Home::class.java))
        }
        findViewById<Button>(R.id.btniniciar2).setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }
    }
    fun getdata(){
        val retrofitClie=NetworksUtils
            .getRetrofirInstace("https://wsc.fabricasoftware.co/")
        val endpoint=retrofitClie.create(EndPointsEspecialidad::class.java)
        val callback=endpoint.getPosts()
        callback.enqueue(object :Callback<PostEspecialidad>{
            override fun onFailure(call: Call<PostEspecialidad>, t: Throwable) {
                Toast.makeText(baseContext,"ERROR, ${t.message}",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<PostEspecialidad>,
                response: Response<PostEspecialidad>
            ) {
                println(response.body())
            }
        })
    }
}