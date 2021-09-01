package com.example.apppruebaatlantico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
    fun getdata(){
        val retrofitClie=NetworksUtils
            .getRetrofirInstace("https://wsc.fabricasoftware.co/")
        val endpoint=retrofitClie.create(EndPointsEspecialidad::class.java)
        val callback=endpoint.getPosts()
        callback.enqueue(object :Callback<PostEspecialidad>{
            override fun onFailure(call: Call<PostEspecialidad>, t: Throwable) {
                Toast.makeText(baseContext,"ERROR ${t.message}",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<PostEspecialidad>,
                response: Response<PostEspecialidad>
            ) {

            }
        })
    }
}