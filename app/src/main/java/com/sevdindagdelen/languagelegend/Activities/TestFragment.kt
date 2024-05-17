package com.sevdindagdelen.languagelegend.Activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevdindagdelen.languagelegend.Words
import com.sevdindagdelen.languagelegend.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private lateinit var adapter: RVadapterForFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //val myData = arguments?.getStringArray("data")
        val mySerialiazableData= arguments?.getSerializable("data") as? ArrayList<Words>
        binding= FragmentTestBinding.inflate(layoutInflater, container, false)
        binding.rvFragment.setHasFixedSize(true)
        binding.rvFragment.layoutManager=LinearLayoutManager(requireContext())
        adapter=RVadapterForFragment(requireContext(), (mySerialiazableData)!!)
        binding.rvFragment.adapter=adapter






        binding.imageView3.setOnClickListener {
            (requireActivity() as QuizActivity).DeleteFragment()
        }

        //binding.textView12.text= mySerialiazableData?.get(0)?.turkce ?: "yanlış cevap yok"

        return binding.root

    }


}