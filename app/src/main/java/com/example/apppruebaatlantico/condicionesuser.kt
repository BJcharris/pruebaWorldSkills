package com.example.apppruebaatlantico

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.apppruebaatlantico.DataBase.AdminSQLiteOpenHelper

class condicionesuser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condicionesuser)
        val preferencias=getSharedPreferences("politicas", Context.MODE_PRIVATE)
        val texto=preferencias.getString("politics",null)
        findViewById<TextView>(R.id.tvpoliticas).setText(texto)
        findViewById<Button>(R.id.btnaceptar).setOnClickListener {
            val bundle=intent.extras
            val admin= AdminSQLiteOpenHelper(this,"restaurante",null,1)
            val bd=admin.writableDatabase
            var registro= ContentValues()
            registro.put("nombres",bundle?.getString("name"))
            registro.put("email",bundle?.getString("email"))
            registro.put("contraseña",bundle?.getString("contraseña"))
            registro.put("ciudad",bundle?.getString("ciudad"))
            registro.put("activo",false)
            bd.insert("usuarios",null, registro)
            bd.close()
            Toast.makeText(this,"Usuario registrado con exito",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,especialidadCasa::class.java).apply {
                putExtra("nombres",bundle?.getString("name"))
                putExtra("mail",bundle?.getString("email"))
            }
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.btnrechazar).setOnClickListener {
            Toast.makeText(this,"Su cuenta no pudo ser creada",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,Login::class.java))
        }
    }
    fun alertDialog(title:String,message:String){
        val alerta= AlertDialog.Builder(this)
        alerta.setTitle(title)
        alerta.setMessage(message)
        alerta.show()
    }
}