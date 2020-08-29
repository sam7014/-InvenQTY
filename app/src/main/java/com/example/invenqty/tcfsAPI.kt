package com.example.invenqty

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface tcfsAPI {
    @GET("api/intranet/GetQTY")
    fun getStock(
        @Query("keyword") keyword: String
    ): Call<Res_Stock>
}