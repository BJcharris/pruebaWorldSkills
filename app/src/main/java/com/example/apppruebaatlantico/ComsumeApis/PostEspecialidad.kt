package com.example.apppruebaatlantico.ComsumeApis

import com.google.gson.annotations.SerializedName
import java.util.*

data class PostEspecialidad(
    @SerializedName("respuesta") val respuesta:String,
    @SerializedName("datos") val datos:String
    )
