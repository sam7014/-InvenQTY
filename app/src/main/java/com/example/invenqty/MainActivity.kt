package com.example.invenqty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = StockAdapter()
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://svc.toocool.co.kr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(tcfsAPI::class.java)
        val callGetStock = api.getStock("다이노플라츠바치오브라키오8호")

        callGetStock.enqueue(object : Callback<Res_Stock> {
            override fun onResponse(call: Call<Res_Stock>, response: Response<Res_Stock>) {
                Log.d("결과","성공 : ${response.raw()}")
                adapter.stockList.addAll(response.body()!!.reponse_Data)
                adapter.notifyDataSetChanged()
                println(adapter.stockList)
            }

            override fun onFailure(call: Call<Res_Stock>, t: Throwable) {
                Log.d("결과","실패 : $t")
            }
        })
    }
}