package com.example.apppruebaatlantico

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread.sleep(1000)
        startActivity(Intent(this,Login::class.java))
        val preferencias=getSharedPreferences("politicas", Context.MODE_PRIVATE)
        val editor=preferencias.edit()
        editor.putString("texto","Entiendo que, en consecuencia, el Restaurante es responsable por asegurar la concordancia entre los datos que le han sido suministrado y los que registra/divulga, pero no tiene ninguna responsabilidad por la calidad y veracidad de los datos reportados.\\nEs claro para mí que, por medio de esta consulta de datos, el Restaurante pone a mi alcance los mecanismos necesarios para que pueda ejercer el derecho de habeas data, de acuerdo con lo establecido en el artículo 15 de la Constitución Política de Colombia, la Ley 1581 de 2012 y de acuerdo con la doctrina de la Corte Constitucional de Colombia.\\nPuede consultar nuestra Política de Privacidad y Protección de Datos Personales")
        val preferencias2=getSharedPreferences("especialidad", Context.MODE_PRIVATE)
        val editor2=preferencias2.edit()
        editor2.putString("nombre","Bandeja montañera")
        editor2.putString("descripcion","Con frijol, carne asada, carne molida o chicharrón, huevo frito, papa, yuca, ensalada, tajada de maduro, arroz y arepa.")
        editor2.putInt("precio",21400)
        editor2.commit()
    }
}