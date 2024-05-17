package com.sevdindagdelen.languagelegend.Activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.isInvisible
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.sevdindagdelen.languagelegend.DatabaseHelper
import com.sevdindagdelen.languagelegend.DatabaseHelper3
import com.sevdindagdelen.languagelegend.WordsDao
import com.sevdindagdelen.languagelegend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: DatabaseHelper
    //private lateinit var soru:ArrayList<Words>
    //private lateinit var sorugoster: Words
    private lateinit var db3: DatabaseHelper3
    var skorlist:ArrayList<Point>?=null
    var sayac=0
    private lateinit var liste:List<ImageView>

    private val restartReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            recreate()
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        // BroadcastReceiver'ı kaldır
        unregisterReceiver(restartReceiver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        databasecopy()
        setContentView(binding.root)
        liste= listOf(binding.image1,binding.image2,binding.image3)
        db3= DatabaseHelper3(this@MainActivity)
        skorlist=WordsDao().Scores(db3)
        db= DatabaseHelper(this@MainActivity)
        highestScore()
        intents()
        gorulebilirlik()
        ileri()
        geri()
        val filter = IntentFilter("com.example.RESTART_ACTIVITY")
        registerReceiver(restartReceiver, filter)
        //test()

    }

    fun highestScore(){
        val skorlistpuan = ArrayList<Int>()
        if (skorlist != null) {
            for (i in 0 until minOf(skorlist!!.size, 10)) {
                val puan = skorlist!![i]?.puan ?: 0
                skorlistpuan.add(puan)
            }
            // puan değerleri null değilse ve skorlistpuan boş değilse
            if (skorlistpuan.isNotEmpty()) {
                binding.yuksekskor.text = skorlistpuan.max().toString()
            } else {
                // puan değerleri null ise veya skorlistpuan boşsa
                binding.yuksekskor.text = "0"
            }
        }else{
            binding.yuksekskor.text="0"
        }

    }

    fun ileri(){
        binding.ileri.setOnClickListener {
            if (sayac < 2) {
                sayac++
            }
            liste[sayac-1].isInvisible=true
            liste[sayac].isInvisible=false
            if(sayac==2) binding.ileri.isInvisible=true
            binding.geri.isInvisible=false
        }
    }

    fun geri(){
        binding.geri.setOnClickListener {
            if (sayac > 0) {
                sayac--
            }
            liste[sayac+1].isInvisible=true
            liste[sayac].isInvisible=false
            if(sayac==0) binding.geri.isInvisible=true
            binding.ileri.isInvisible=false
        }
    }

    fun gorulebilirlik(){
        if (sayac==0){
            binding.geri.isInvisible=true
        }
    }


    fun intents(){
        binding.image3.setOnClickListener {
            val intent=Intent(this@MainActivity,ScoreActivity::class.java)
            startActivity(intent)
        }
        binding.image2.setOnClickListener {
            val intent=Intent(this@MainActivity,NotesActivity::class.java)
            startActivity(intent)
        }
        binding.image1.setOnClickListener {
            val intent=Intent(this@MainActivity,QuizActivity::class.java)
            startActivity(intent)
        }
    }

    fun test(){
        var soru=ArrayList<Point>()
        soru= WordsDao().Scores(db = DatabaseHelper3(this@MainActivity))

        for (i in 0 until minOf(soru.size, 11)) {
            val m=soru[i].puan
            WordsDao().skorsil(db = DatabaseHelper3(this@MainActivity),m)
        }


    }



    fun databasecopy(){
        val copyhelper=DatabaseCopyHelper(this@MainActivity)

        try {
            copyhelper.createDataBase()
            copyhelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}