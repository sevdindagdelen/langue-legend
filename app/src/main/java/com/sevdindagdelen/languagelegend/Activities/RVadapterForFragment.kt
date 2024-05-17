package com.sevdindagdelen.languagelegend.Activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.sevdindagdelen.languagelegend.DatabaseHelper2
import com.sevdindagdelen.languagelegend.R
import com.sevdindagdelen.languagelegend.Words
import com.sevdindagdelen.languagelegend.WordsDao

class RVadapterForFragment(private val mContext: Context, private val yanlisListesi:MutableList<Words>)
    :RecyclerView.Adapter<RVadapterForFragment.designForMistakensObejects>(){
    val db= DatabaseHelper2(mContext)

    inner class designForMistakensObejects(view:View):RecyclerView.ViewHolder(view){

        val ingilizce:TextView=view.findViewById(R.id.textingilizce1)
        val turkce:TextView=view.findViewById(R.id.textturkce1)
        val add:ImageView=view.findViewById(R.id.add_word)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): designForMistakensObejects {
        val tasarim=LayoutInflater.from(mContext).inflate(R.layout.design_for_mistaken_answers,parent,false)
        return designForMistakensObejects(tasarim)
    }

    override fun getItemCount(): Int {
        return yanlisListesi.size
    }

    override fun onBindViewHolder(holder: designForMistakensObejects, position: Int) {
        val kelimeler=yanlisListesi[position]
        holder.ingilizce.text=kelimeler.ingilizce  //bu sondaki ingilizce Words() teki ingilizce
        holder.turkce.text=kelimeler.turkce
        holder.add.setImageResource(R.drawable.add_notes)
        holder.add.setOnClickListener {
            WordsDao().addPerson(db,kelimeler.ingilizce,kelimeler.turkce)
            holder.add.isInvisible=true
            Toast.makeText(mContext, "${kelimeler.ingilizce} eklendi", Toast.LENGTH_SHORT).show()
        }

    }
}