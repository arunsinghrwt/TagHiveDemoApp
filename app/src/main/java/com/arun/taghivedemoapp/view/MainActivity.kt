package com.arun.taghivedemoapp.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arun.taghivedemoapp.R
import com.arun.taghivedemoapp.databinding.ActivityMainBinding
import com.arun.taghivedemoapp.network.ApiResponse
import com.arun.taghivedemoapp.network.MainViewModel
import org.koin.android.ext.android.inject
import javax.xml.datatype.DatatypeFactory.newInstance
import javax.xml.xpath.XPathFactory.newInstance

class MainActivity : AppCompatActivity() {
    private val mainViewModel by inject<MainViewModel>()
    private lateinit var mainAdapter : MainAdapter
    private val dataList: ArrayList<ApiResponse> = ArrayList()

    lateinit var root: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        root = ActivityMainBinding.inflate(layoutInflater)
        setContentView(root.root)
        mainViewModel.liveData.observe(this){
              if (it == null){
                  return@observe
              }
               dataList.addAll(it)
               mainAdapter.notifyDataSetChanged()
               root.progressCircular.visibility = View.GONE
        }
        initView()
    }

    private fun initView() {
        root.progressCircular.visibility = View.VISIBLE
        mainViewModel.getData()
        addAdapter()
    }
    private fun addAdapter() {
            mainAdapter = MainAdapter(dataList ){
                val detailsFragment = DetailsFragment()
                mainViewModel.setDetails(dataList[it])
                supportFragmentManager.beginTransaction().add(R.id.rootView, detailsFragment, "details")
                    .addToBackStack("details")
                    .commit()

            }
            root.mainRv.layoutManager = LinearLayoutManager(this)
            root.mainRv.adapter = mainAdapter
        }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount > 0 ){
             supportFragmentManager.popBackStackImmediate()
        }else{
            super.onBackPressed()
        }

    }

}