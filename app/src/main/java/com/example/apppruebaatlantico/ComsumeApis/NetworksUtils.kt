package com.example.apppruebaatlantico.ComsumeApis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworksUtils {
    companion object{
        fun getRetrofitInstance():Retrofit{
            return Retrofit.Builder().baseUrl("https://wsc.fabricasoftware.co")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}