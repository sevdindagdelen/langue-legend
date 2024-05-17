package com.sevdindagdelen.languagelegend.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sevdindagdelen.languagelegend.DatabaseHelper3
import com.sevdindagdelen.languagelegend.WordsDao
import com.sevdindagdelen.languagelegend.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    private lateinit var db3: DatabaseHelper3
    var skorlist:ArrayList<Point>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db3= DatabaseHelper3(this@ScoreActivity)
        skorlist=WordsDao().Scores(db3)
        //test()
        test1()
        }

    fun test1() {
        val skorlistpuan = ArrayList<Int>()
        if (skorlist != null) {
            for (i in 0 until minOf(skorlist!!.size, 10)) {
                val puan = skorlist!![i]?.puan ?: 0
                skorlistpuan.add(puan)
            }
            skorlistpuan.sortDescending()
            val textViews = arrayOf(
                binding.textView1, binding.textView2, binding.textView3, binding.textView4,
                binding.textView5, binding.textView6, binding.textView7, binding.textView8,
                binding.textView9, binding.textView10
            )

            for (i in textViews.indices) {
                val text = if (skorlistpuan.size > i) skorlistpuan[i].toString() else "0"
                textViews[i].text = text
            }
        } else {
            // skorlist null ise, varsayılan olarak 0 kullan
            for (textView in arrayOf(
                binding.textView1, binding.textView2, binding.textView3, binding.textView4,
                binding.textView5, binding.textView6, binding.textView7, binding.textView8,
                binding.textView9, binding.textView10
            )) {
                textView.text = "0"
            }


        }

    }



}