package com.arun.taghivedemoapp.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import com.arun.taghivedemoapp.BR
import com.arun.taghivedemoapp.R
import com.arun.taghivedemoapp.databinding.ItemRowBinding
import com.arun.taghivedemoapp.network.ApiResponse


/**
// Created by Arun Singh Rawat on 02-07-2022.
 **/

class MainAdapter(private val dataList: List<ApiResponse> , private var onClick: (Int) -> Unit ) :  RecyclerView.Adapter<BindAbleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindAbleViewHolder  {
        val binding: ItemRowBinding? = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_row,
            parent,
            false)
        return BindAbleViewHolder(binding!!)

    }

    override fun onBindViewHolder(holder: BindAbleViewHolder, position: Int) {
        if(!dataList.isNullOrEmpty()){
            val apiResponse: ApiResponse = dataList[position]
            holder.bind(apiResponse)
            holder.itemView.setOnClickListener {
                onClick(position)
                }
            }
        }

    override fun getItemCount(): Int {
        return dataList.size
    }
}





class BindAbleViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(itemViewModel: ApiResponse) {
        binding.setVariable(BR.dataList , itemViewModel)
        binding.executePendingBindings()
    }
}