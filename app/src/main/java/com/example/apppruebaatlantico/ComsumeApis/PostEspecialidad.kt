package com.example.apppruebaatlantico.ComsumeApis

import com.google.gson.annotations.SerializedName

data class PostEspecialidad(
    @SerializedName("respuesta") val respuesta:String,
    @SerializedName("datos") val datos:String
    )
