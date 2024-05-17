package com.sevdindagdelen.languagelegend

import android.content.ContentValues
import com.sevdindagdelen.languagelegend.Activities.Point

class WordsDao {
    fun allWords(db:DatabaseHelper):ArrayList<Words>{
        val wordlist=ArrayList<Words>()

        val query=db.writableDatabase
        val c=query.rawQuery("SELECT * FROM sozluk ORDER BY RANDOM() LIMIT 2 ",null)

        val wordId=c.getColumnIndex("id")
        val english=c.getColumnIndex("ingilizce")
        val turkhis=c.getColumnIndex("turkce")

        while (c.moveToNext()){
            val word=Words(c.getInt(wordId),c.getString(english),c.getString(turkhis))
            wordlist.add(word)
        }
        query.close()
        return wordlist
    }

    fun rightWords(db:DatabaseHelper):ArrayList<Words>{
        val wordlist=ArrayList<Words>()

        val query=db.writableDatabase
        val c=query.rawQuery("SELECT * FROM sozluk ORDER BY RANDOM() LIMIT 1 ",null)

        val wordId=c.getColumnIndex("id")
        val english=c.getColumnIndex("ingilizce")
        val turkhis=c.getColumnIndex("turkce")

        while (c.moveToNext()){
            val word=Words(c.getInt(wordId),c.getString(english),c.getString(turkhis))
            wordlist.add(word)
        }
        query.close()
        return wordlist
    }

    fun addPerson(db:DatabaseHelper2,ingilizce:String,turkce:String){
        val database=db.writableDatabase
        val values=ContentValues()


        values.put("ingilizce",ingilizce)
        values.put("turkce",turkce)

        database.insertOrThrow("kelimeler",null,values)
    }

    fun kelimeler(db:DatabaseHelper2):ArrayList<Words>{
        val wordlist=ArrayList<Words>()

        val query=db.writableDatabase
        val c=query.rawQuery("SELECT * FROM kelimeler ",null)

        val wordId=c.getColumnIndex("id")
        val english=c.getColumnIndex("ingilizce")
        val turkhis=c.getColumnIndex("turkce")

        while (c.moveToNext()){
            val word=Words(c.getInt(wordId),c.getString(english),c.getString(turkhis))
            wordlist.add(word)
        }
        query.close()
        return wordlist
    }

    fun kelimesil(db: DatabaseHelper2,id:Int){
        val sil=db.writableDatabase
        sil.delete("kelimeler","id=?", arrayOf(id.toString()))
        sil.close()
    }

    fun addScore(db:DatabaseHelper3,puan:Int){
        val database=db.writableDatabase
        val values=ContentValues()

        values.put("skor",puan)

        database.insertOrThrow("skorlar",null,values)
    }

    fun Scores(db:DatabaseHelper3):ArrayList<Point>{
        val skorlist=ArrayList<Point>()

        val query=db.writableDatabase
        val c=query.rawQuery("SELECT * FROM skorlar ",null)

        val wordscore=c.getColumnIndex("skor")


        while (c.moveToNext()){
            val score=Point(c.getInt(wordscore))
            skorlist.add(score)
        }
        query.close()
        return skorlist
    }

    fun skorsil(db: DatabaseHelper3,puan:Int){
        val sil=db.writableDatabase
        sil.delete("skorlar","skor=?", arrayOf(puan.toString()))
        sil.close()
    }

}