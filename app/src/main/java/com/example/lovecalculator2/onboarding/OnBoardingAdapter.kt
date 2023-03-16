package com.example.lovecalculator2.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator2.R
import com.example.lovecalculator2.databinding.ItemOnboardingBinding

class OnBoardingAdapter(private val onClick: () -> Unit) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>()  {

    private val data = arrayListOf(
        OnBoard( "It's funs and many more.", R.raw.laptop),
        OnBoard( "It's funs and i wanna eat.",R.raw.task),
        OnBoard( "It's funs and thats all.", R.raw.task2),
        OnBoard( "It's funs and i dislike adabiyat.", R.raw.laptop)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            binding.apply {
                binding.tvDesc.text = onBoard.desc
                onBoard.image?.let {
                    binding.ivOnBoard.setAnimation(it)
                }
            }
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
        }
    }

}