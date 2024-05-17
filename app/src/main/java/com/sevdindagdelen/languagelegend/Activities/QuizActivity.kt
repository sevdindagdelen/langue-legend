package com.sevdindagdelen.languagelegend.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isInvisible
import com.sevdindagdelen.languagelegend.DatabaseHelper
import com.sevdindagdelen.languagelegend.DatabaseHelper2
import com.sevdindagdelen.languagelegend.DatabaseHelper3
import com.sevdindagdelen.languagelegend.R
import com.sevdindagdelen.languagelegend.Words
import com.sevdindagdelen.languagelegend.WordsDao
import com.sevdindagdelen.languagelegend.databinding.ActivityQuizBinding
import kotlin.properties.Delegates

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var db: DatabaseHelper
    private lateinit var db2: DatabaseHelper2
    private lateinit var db3: DatabaseHelper3
    private lateinit var dogrusoru:ArrayList<Words>
    private lateinit var dogrusorugoster: Words
    private lateinit var tumSecenekler:HashSet<Words>
    private lateinit var yanlisSecenekler:ArrayList<Words>
    private var yanlissayac by Delegates.notNull<Int>()

    var textScore=0
    var pas=3
    public var Aid by Delegates.notNull<Int>()
    public var Bid by Delegates.notNull<Int>()
    public var Cid by Delegates.notNull<Int>()
    public lateinit var skorlist:ArrayList<Point>
    private lateinit var mistakenAnswer:ArrayList<Words>
    private lateinit var countDownTimer:CountDownTimer
    private var totalTimeInMillis by Delegates.notNull<Long>()
    //public var savedInstanceState by Delegates.notNull<Bundle>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mistakenAnswer= ArrayList<Words>()
        yanlissayac=3
        totalTimeInMillis= 9000
        db= DatabaseHelper(this@QuizActivity)
        db2= DatabaseHelper2(this@QuizActivity)
        db3= DatabaseHelper3(this@QuizActivity)
        countDown()
        test()
        check()

    }

    fun test(){
        tumSecenekler=HashSet()
        yanlisSecenekler=WordsDao().allWords(db)
        dogrusoru= WordsDao().rightWords(db)
        dogrusorugoster=dogrusoru[0]
        binding.textQuiz.text=dogrusorugoster.ingilizce

        tumSecenekler.add(dogrusorugoster)
        tumSecenekler.add(yanlisSecenekler[0])
        tumSecenekler.add(yanlisSecenekler[1])


        binding.textViewA.text=tumSecenekler.elementAt(0).turkce
        Aid=tumSecenekler.elementAt(0).id.toInt()
        binding.textViewB.text=tumSecenekler.elementAt(1).turkce
        Bid=tumSecenekler.elementAt(1).id.toInt()
        binding.textViewC.text=tumSecenekler.elementAt(2).turkce
        Cid=tumSecenekler.elementAt(2).id.toInt()

        binding.fabAdd.setOnClickListener {

            WordsDao().addPerson(db2,dogrusorugoster.ingilizce,dogrusorugoster.turkce)
        }

    }

    fun check(){
        binding.cardA.setOnClickListener{
            onCardClick(Aid)
            if (Aid==dogrusorugoster.id){
                textScore=textScore+10
                binding.textViewSkor.text=textScore.toString()

                Handler().postDelayed({
                    //binding.textViewB.setTextColor(Color.GREEN)
                    binding.cardA.setCardBackgroundColor(Color.GREEN)

                    Handler().postDelayed({
                        binding.cardA.setCardBackgroundColor(Color.WHITE)
                        //binding.textViewB.setTextColor(Color.BLACK)
                        test()
                    }, 150)

                }, 150)
            }else{
                var dogrusoru=Words(dogrusorugoster.id,dogrusorugoster.ingilizce,dogrusorugoster.turkce)
                mistakenAnswer.add(dogrusoru)
                if(yanlissayac!=0){
                    yanlissayac--
                    binding.textSayac.text=yanlissayac.toString()
                }else{
                    binding.textSayac.text=yanlissayac.toString()
                }
                Handler().postDelayed({
                    binding.cardA.setCardBackgroundColor(Color.RED)
                    //binding.textViewB.setTextColor(Color.RED)
                    Handler().postDelayed({
                        binding.cardA.setCardBackgroundColor(Color.WHITE)
                        //binding.textViewB.setTextColor(Color.BLACK)
                        test()
                    }, 150)
                }, 150)
            }
        }
        binding.cardB.setOnClickListener{
            onCardClick(Bid)
            if (Bid==dogrusorugoster.id){
                textScore=textScore+10
                binding.textViewSkor.text=textScore.toString()

                Handler().postDelayed({
                    //binding.textViewB.setTextColor(Color.GREEN)
                    binding.cardB.setCardBackgroundColor(Color.GREEN)

                    Handler().postDelayed({
                        binding.cardB.setCardBackgroundColor(Color.WHITE)
                        //binding.textViewB.setTextColor(Color.BLACK)
                        test()
                    }, 150)

                }, 150)
            }else{
                var dogrusoru=Words(dogrusorugoster.id,dogrusorugoster.ingilizce,dogrusorugoster.turkce)
                mistakenAnswer.add(dogrusoru)
                if(yanlissayac!=0){
                    yanlissayac--
                    binding.textSayac.text=yanlissayac.toString()
                }else{
                    binding.textSayac.text=yanlissayac.toString()
                }
                Handler().postDelayed({
                    binding.cardB.setCardBackgroundColor(Color.RED)
                    //binding.textViewB.setTextColor(Color.RED)
                    Handler().postDelayed({
                        binding.cardB.setCardBackgroundColor(Color.WHITE)
                        //binding.textViewB.setTextColor(Color.BLACK)
                        test()
                    }, 150)
                }, 150)
            }
        }
        binding.cardC.setOnClickListener{
            onCardClick(Cid)
            if (Cid==dogrusorugoster.id){
                textScore=textScore+10
                binding.textViewSkor.text=textScore.toString()
                Handler().postDelayed({
                    //binding.textViewC.setTextColor(Color.GREEN)
                    binding.cardC.setCardBackgroundColor(Color.GREEN)

                    Handler().postDelayed({
                        binding.cardC.setCardBackgroundColor(Color.WHITE)
                        //binding.textViewC.setTextColor(Color.BLACK)
                        test()
                    }, 150)

                }, 150)
                //textScore=textScore+10
                //binding.textViewSkor.text=textScore.toString()
                //binding.textViewC.setTextColor(Color.BLACK)

                //test()
            }else{
                var dogrusoru=Words(dogrusorugoster.id,dogrusorugoster.ingilizce,dogrusorugoster.turkce)
                mistakenAnswer.add(dogrusoru)
                if(yanlissayac!=0){
                    yanlissayac--
                    binding.textSayac.text=yanlissayac.toString()
                }else{
                    binding.textSayac.text=yanlissayac.toString()
                }
                Handler().postDelayed({
                    //binding.textViewC.setTextColor(Color.RED)
                    binding.cardC.setCardBackgroundColor(Color.RED)
                    Handler().postDelayed({
                        //binding.textViewC.setTextColor(Color.BLACK)
                        binding.cardC.setCardBackgroundColor(Color.WHITE)
                        test()
                    }, 150)
                }, 150)
                //binding.textViewC.setTextColor(Color.BLACK)
                //test()
            }
        }
        binding.cardPas.setOnClickListener {

            if (pas!=0){
                pas--
                if (pas==0){
                    binding.cardPas.isClickable=false
                    binding.cardPas.setCardBackgroundColor(Color.BLACK)
                    binding.textViewPas.setTextColor(Color.RED)
                }
                binding.textViewPas.text="Pas($pas)"
                test()

            }
            else{
                binding.cardPas.isClickable=false
                binding.cardPas.setCardBackgroundColor(Color.BLACK)
                binding.textViewPas.setTextColor(Color.RED)
            }


        }
    }
    fun countDown(){


        countDownTimer = object : CountDownTimer(totalTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                totalTimeInMillis=secondsLeft*1000
                if(yanlissayac==1){
                    totalTimeInMillis=0
                }
                binding.textViewDuration.text = "$secondsLeft"

            }

            override fun onFinish() {
                val skor=binding.textViewSkor.text.toString().toInt()
                skorlist=WordsDao().Scores(db3)
                val skorpuan = ArrayList<Int>()
                if (skorlist!=null){
                    for (i in 0 until minOf(skorlist.size, 11)) {
                        skorpuan.add(skorlist[i].puan)
                    }
                    if(!skorpuan.contains(skor)){
                        WordsDao().addScore(db3,skor)
                    }
                }else{
                    WordsDao().addScore(db3,skor)
                }


                skorlist=WordsDao().Scores(db3)

                if (skorlist.size==11){

                    val skorlistpuan=ArrayList<Int>()
                    for (i in 0 until minOf(skorlist.size, 11)) {
                         skorlistpuan.add(skorlist[i].puan)
                    }

                    val min=skorlistpuan.min()
                    skorlistpuan.remove(min)
                    WordsDao().skorsil(db3,min)
                }
                binding.cardA.isInvisible=true
                binding.cardB.isInvisible=true
                binding.cardC.isInvisible=true
                binding.cardPas.isInvisible=true
                binding.sayackontrol.isInvisible=true
                binding.cardView2.isInvisible=true
                binding.fabAdd.isInvisible=true
                binding.image2.isInvisible=true
                binding.textQuiz.isInvisible=true


                val fragment = TestFragment()

                if ((mistakenAnswer!=null) and(mistakenAnswer.isNotEmpty()==true)){
                    val bundle = Bundle()
                    val mistakenAnswerArray=mistakenAnswer.toTypedArray()
                    //bundle.putStringArray("data", mistakenAnswerArray.map { it.toString() }.toTypedArray())
                    bundle.putSerializable("data",mistakenAnswer)
                    fragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, fragment)
                        .commit()
                }else{
                    finish()
                }



                val intent = Intent("com.example.RESTART_ACTIVITY")
                sendBroadcast(intent)
                //finish()

                Toast.makeText(applicationContext, "Skorunuz:$skor", Toast.LENGTH_SHORT).show()

            }
        }
        countDownTimer.start()




    }

    fun ForAddTime(){
        binding.addtime.visibility = View.VISIBLE // TextView'ı görünür yap

        Handler().postDelayed({
            binding.addtime.visibility = View.INVISIBLE

        }, 200)

    }

    fun ForDecreaseTime(){
        binding.decreasetime.visibility = View.VISIBLE // TextView'ı görünür yap

        Handler().postDelayed({
            binding.decreasetime.visibility = View.INVISIBLE

        }, 200)

    }

    private fun onCardClick(selectedId: Int) {
        countDownTimer.cancel()
        if (selectedId == dogrusorugoster.id) {
            ForAddTime()
            totalTimeInMillis += 3000
        } else {
            ForDecreaseTime()
            totalTimeInMillis -= 1000
            if (totalTimeInMillis < 0) {
                totalTimeInMillis = 0
            }
        }
        countDown()
    }
    fun DeleteFragment() {
        finish()
        val fragment = supportFragmentManager.findFragmentById(R.id.frameLayout)
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
        }

    }

    /* if(totalTimeInMillis.toString()=="0"){
            val fragment = TestFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit()
        }*/

}

