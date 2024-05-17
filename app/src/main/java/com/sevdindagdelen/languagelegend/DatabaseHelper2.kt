package com.sevdindagdelen.languagelegend

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper2(context: Context): SQLiteOpenHelper(context,"sozluk2",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE \"kelimeler\" (\n" +
                "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,\n" +
                "\t\"ingilizce\"\tTEXT,\n" +
                "\t\"turkce\"\tTEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS kelimeler")
        onCreate(db)
    }

}