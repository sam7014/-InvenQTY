package com.example.invenqty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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

        // 문자열 배열과 기본 스피너 레이아웃을 사용하여 ArrayAdapter만들기
        val spinnerAdapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.select_Gubun,android.R.layout.simple_spinner_item)
        // 선택 목록이 나타날 때 사용할 레이아웃 지정
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // 스피너에 어댑터 적용
        spinner_gubun.adapter = spinnerAdapter
        //
        spinner_gubun.setSelection(0)


        val keyword = editText_keyword.text.toString() // 왜 변수에 넣어서 던지면 안되지?
        val adapter = StockAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        button_getQTY.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://test.toocool.co.kr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val api = retrofit.create(tcfsAPI::class.java)
            val callGetStock = api.getStock(editText_keyword.text.toString()) // 왜 변수에 넣어서 던지면 안되지? 여기? 쿼리타입이여서?

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
}