package com.example.lovecalculator2.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator2.App
import com.example.lovecalculator2.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val list = App.appDataBase.loveDao().getAll()
//        var data = ""
//        list.forEach{
//            data += "${it.firstName} \n ${it.secondName} \n ${it.percentage} \n ${it.result}"
//        }
        binding.historyRv.adapter = adapter
        adapter.addSortedItems(App.appDataBase.loveDao().getSortedNames())
        
        binding.homeBtn.setOnClickListener{
            findNavController().navigate(R.id.namesFragment)
        }
    }
}
