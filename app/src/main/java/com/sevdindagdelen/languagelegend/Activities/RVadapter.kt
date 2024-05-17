package com.sevdindagdelen.languagelegend.Activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.sevdindagdelen.languagelegend.DatabaseHelper2
import com.sevdindagdelen.languagelegend.R
import com.sevdindagdelen.languagelegend.Words
import com.sevdindagdelen.languagelegend.WordsDao

class RVadapter(private val mContext: Context, private val NotListesi:MutableList<Words>)
    :RecyclerView.Adapter<RVadapter.CardViewdekiTasarimNesneTutucusu>() {
    val db=DatabaseHelper2(mContext)

    inner class CardViewdekiTasarimNesneTutucusu(view: View): RecyclerView.ViewHolder(view){

        val ingilizce:TextView=view.findViewById(R.id.textEnglish)
        val turkce:TextView=view.findViewById(R.id.textTurkhis)
        val trash:ImageView=view.findViewById(R.id.trash)
        val card_view:CardView=view.findViewById(R.id.card_view)
        val id:TextView=view.findViewById(R.id.textid)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewdekiTasarimNesneTutucusu {
        val tasarim= LayoutInflater.from(mContext).inflate(R.layout.cardview_tasarimi,parent,false)
        return  CardViewdekiTasarimNesneTutucusu(tasarim)
    }

    override fun getItemCount(): Int {
        return NotListesi.size
    }

    override fun onBindViewHolder(holder: CardViewdekiTasarimNesneTutucusu, position: Int) {
        val kelimeler=NotListesi[position]
        holder.id.text=kelimeler.id.toString()
        holder.ingilizce.text=kelimeler.ingilizce
        holder.turkce.text=kelimeler.turkce
        holder.trash.setImageResource(R.drawable.baseline_delete_24)
        holder.trash.setOnClickListener {
            WordsDao().kelimesil(db,holder.id.text.toString().toInt())
            NotListesi.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, NotListesi.size)

        }
    }

}