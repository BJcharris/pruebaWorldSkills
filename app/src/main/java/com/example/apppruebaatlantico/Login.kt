package com.example.apppruebaatlantico

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.apppruebaatlantico.DataBase.AdminSQLiteOpenHelper

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val preferencias=getSharedPreferences("usuarios", Context.MODE_PRIVATE)
        val email=findViewById<EditText>(R.id.etemail)
        val pass=findViewById<EditText>(R.id.etcontraseña)
        email.setText(preferencias.getString("user",null))
        pass.setText(preferencias.getString("pass",null))
        findViewById<Button>(R.id.ingresar).setOnClickListener {
            if (!email.text.isEmpty() && !pass.text.isEmpty()){
                val admin= AdminSQLiteOpenHelper(this,"restaurante",null,1)
                val bd=admin.writableDatabase
                val consulta=bd.rawQuery("SELECT contraseña FROM usuarios WHERE email='${email.text}'",null)
                if(consulta.moveToFirst()){
                    if (consulta.getString(0).equals(pass.text.toString())){
                        val editor=preferencias.edit()
                        editor.putString("user",email.text.toString())
                        editor.putString("pass",pass.text.toString())
                        editor.commit()
                        Toast.makeText(this,"se le a activado el recuerdame en su cuenta",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,especialidadCasa::class.java))
                    }else{
                        Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this,"Este usuario no fue encontrado",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Faltan campos por llenar!",Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.registrar).setOnClickListener {
            val intent=Intent(this,Registrar::class.java)
            startActivity(intent)
            findViewById<EditText>(R.id.etemail).setText(null)
            findViewById<EditText>(R.id.etcontraseña).setText(null)
        }
    }

}