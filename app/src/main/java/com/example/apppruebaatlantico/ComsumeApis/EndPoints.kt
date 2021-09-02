package com.example.apppruebaatlantico.ComsumeApis

import com.example.apppruebaatlantico.Clases.Especialidad
import com.example.apppruebaatlantico.Clases.categorias
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {
    @GET("api/especialidad")
    fun getEspecialidad():Call<Especialidad>
    @GET("api/categorias")
    fun getcategorias():Call<categorias>

}