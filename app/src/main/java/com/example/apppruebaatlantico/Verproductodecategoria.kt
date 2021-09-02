package com.example.apppruebaatlantico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class Verproductodecategoria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verproductodecategoria)
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
                finish()
                true
            }
            R.id.itembag->{
                true
            }
            else->super.onContextItemSelected(item)
        }
    }
}