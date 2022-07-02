package com.arun.taghivedemoapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arun.taghivedemoapp.databinding.DetailsFragmentBinding
import com.arun.taghivedemoapp.network.ApiResponse
import com.arun.taghivedemoapp.network.MainViewModel
import org.koin.android.ext.android.inject


/**
// Created by Arun Singh Rawat on 02-07-2022.



 **/

class DetailsFragment : Fragment() {
    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel by inject<MainViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(DetailsFragmentBinding.inflate(inflater, container, false)) {
        _binding = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mainViewModel.liveDetails.observe(viewLifecycleOwner){
            if (it == null)
                return@observe
                setData(it)
        }

    }

    private fun setData(apiResponse: ApiResponse) {
        binding.viewAsset.text = apiResponse.baseAsset
        binding.viewAsk.text = apiResponse.askPrice
        binding.viewBid.text = apiResponse.bidPrice
        binding.viewHigh.text = apiResponse.highPrice
        binding.viewLow.text = apiResponse.lowPrice
        binding.viewLast.text = apiResponse.lastPrice
        binding.viewOpenPrice.text = apiResponse.openPrice


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}