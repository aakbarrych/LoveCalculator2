package com.example.lovecalculator2.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.lovecalculator2.databinding.ItemHistoryBinding
import com.example.lovecalculator2.remote.LoveModel

class HistoryAdapter : Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val modelList = arrayListOf<LoveModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addSortedItems(list: List<LoveModel>) {
        modelList.clear()
        modelList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel){
            with(binding){
                tvFname.text = loveModel.firstName
                tvSname.text = loveModel.secondName
                tvPercentage.text = loveModel.percentage
            }
        }
    }
}