package com.example.apppruebaatlantico.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper(context: Context,name:String,factory:SQLiteDatabase.CursorFactory?,version:Int):SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL("CREATE TABLE usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT,nombres VARCHAR(50),email VARCHAR(50),contraseña VARCHAR(50),ciudad VARCHAR(50),activo BOOLEAN)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}