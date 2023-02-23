package com.example.lovecalculator2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator2.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loveModel = arguments?.getSerializable("loveModel") as LoveModel
        with(binding){
            nameFirst.text = loveModel.firstName
            nameSecond.text = loveModel.secondName
            percent.text = loveModel.percentage
            tryAgainBtn.setOnClickListener{
                findNavController().navigateUp()
            }
        }
    }
}