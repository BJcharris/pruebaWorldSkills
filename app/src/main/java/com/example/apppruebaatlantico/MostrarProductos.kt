package com.example.apppruebaatlantico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.apppruebaatlantico.Clases.categoria
import kotlinx.android.synthetic.main.activity_mostrar_productos.*

class MostrarProductos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_productos)
        //val bundle=intent.extras

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemhome->{
                finish()
                true
            }
            R.id.item1->{
                true
            }
            R.id.item2->{
                startActivity(Intent(this,Login::class.java))
                true
            }
            R.id.itembag->{
                true
            }
            else->super.onContextItemSelected(item)
        }
    }
}