package com.sevdindagdelen.languagelegend

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper3(context:Context):SQLiteOpenHelper(context,"skor",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE \"skorlar\" (\n" +
                "\t\"skor\"\tINTEGER\n" +
                ")")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS skorlar")
        onCreate(db)
    }
}