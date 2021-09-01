package com.example.apppruebaatlantico.ComsumeApis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworksUtils {
    companion object{
        fun getRetrofirInstace(path:String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}