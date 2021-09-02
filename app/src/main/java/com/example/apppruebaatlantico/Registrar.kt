package com.example.apppruebaatlantico

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.apppruebaatlantico.DataBase.AdminSQLiteOpenHelper

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        findViewById<Button>(R.id.btnregistrar).setOnClickListener {
            val nombre=findViewById<EditText>(R.id.etname)
            val correo=findViewById<EditText>(R.id.etcorreo)
            val ciudad=findViewById<EditText>(R.id.etciudad)
            val contraseña=findViewById<EditText>(R.id.etcontraseña2)
            val confirmar=findViewById<EditText>(R.id.etvuelvecontraseña)
            if (!nombre.text.isEmpty() && !correo.text.isEmpty() && !contraseña.text.isEmpty() && !confirmar.text.isEmpty() && !ciudad.text.isEmpty()){
                if (contraseña.text.toString().equals(confirmar.text.toString())){
                    val intent=Intent(this,condicionesuser::class.java).apply {
                        putExtra("name",nombre.text.toString())
                        putExtra("email",correo.text.toString())
                        putExtra("ciudad",ciudad.text.toString())
                        putExtra("contraseña",contraseña.text.toString())
                    }
                    startActivity(intent)
                    finish()
                }else{
                    alertDialog("INFROMACION","CONTRASEÑA NO COINCIDEN")
                }
            }else{
                Toast.makeText(this,"Faltan campos por llenar",Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btniniciar).setOnClickListener {
            finish()
        }

    }
    //Alertas
     fun alertDialog(title:String,message:String){
        val alerta=AlertDialog.Builder(this)
        alerta.setTitle(title)
        alerta.setMessage(message)
        alerta.show()
    }
}