package com.example.lovecalculator2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator2.databinding.FragmentNamesBinding
import com.example.lovecalculator2.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NamesFragment : Fragment() {

    private lateinit var binding: FragmentNamesBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            binding.historyBtn.setOnClickListener{
                findNavController().navigate(R.id.historyFragment)
            }
            calculateBtn.setOnClickListener{
                viewModel.getLiveLove(firstEd.text.toString(), secondEd.text.toString())
                    .observe(viewLifecycleOwner,
                        Observer { loveModel-> findNavController().navigate(R.id.resultFragment, bundleOf("loveModel" to loveModel))
                            App.appDataBase.loveDao().insert(loveModel)
                    })
            }
        }
    }
}