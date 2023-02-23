package com.example.lovecalculator2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator2.databinding.FragmentNamesBinding
import retrofit2.Call
import retrofit2.Response

class NamesFragment : Fragment() {

    private lateinit var binding: FragmentNamesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            calculateBtn.setOnClickListener{
                LoveService().api.calculatePercentage(
                    firstName = firstEd.text.toString(),
                    secondName = secondEd.text.toString()
                ).enqueue(object :retrofit2.Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if(response.isSuccessful){
                            findNavController().navigate(R.id.resultFragment, bundleOf("loveModel" to response.body()))
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }
}