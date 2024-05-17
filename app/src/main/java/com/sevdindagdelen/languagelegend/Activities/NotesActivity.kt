package com.sevdindagdelen.languagelegend.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevdindagdelen.languagelegend.DatabaseHelper2
import com.sevdindagdelen.languagelegend.WordsDao
import com.sevdindagdelen.languagelegend.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotesBinding
    private lateinit var db2: DatabaseHelper2
    private lateinit var adapter: RVadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db2= DatabaseHelper2(this@NotesActivity)
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager= LinearLayoutManager(this@NotesActivity)
        val kelimeListe=WordsDao().kelimeler(db2)
        adapter= RVadapter(applicationContext,kelimeListe)
        binding.rv.adapter=adapter


        /*
        binding.button.setOnClickListener {
            val no=binding.editTextNumber.text.toString().toInt()
            WordsDao().kelimesil(db2,no)
            val kelimeListe=WordsDao().kelimeler(db2)
            for (k in kelimeListe){
                println(k.id.toString()+"/ "+k.ingilizce +"/ "+k.turkce)
            }
        }
         */

    }
}