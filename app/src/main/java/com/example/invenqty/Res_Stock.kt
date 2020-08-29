package com.example.invenqty

import com.google.gson.annotations.SerializedName

data class Res_Stock(
    @SerializedName("Response_Data") var reponse_Data : List<StockInfo>,
    @SerializedName("Result_Code") var result_Code : Int,
    @SerializedName("Result_Msg") var result_Msg : String,
    @SerializedName("TotalCount") var totalCount : Int
)