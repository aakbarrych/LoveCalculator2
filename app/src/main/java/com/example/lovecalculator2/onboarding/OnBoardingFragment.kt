package com.example.lovecalculator2.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator2.R
import com.example.lovecalculator2.databinding.FragmentOnBoardingBinding
import com.example.lovecalculator2.preferences.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var adapter: OnBoardingAdapter
    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        adapter = OnBoardingAdapter(this::onClick)
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewpager)
        if(pref.isUserSeen()){
            findNavController().navigate(R.id.namesFragment)
        }
    }

    private fun onClick() {
        pref.saveSeen()
        findNavController().navigate(R.id.namesFragment)
    }

}