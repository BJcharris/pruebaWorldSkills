package com.example.apppruebaatlantico.ComsumeApis

import retrofit2.Call
import retrofit2.http.GET

interface EndPointsEspecialidad {
    @GET("api/especialidad")
    fun getPosts():Call<PostEspecialidad>
}