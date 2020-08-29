package com.example.invenqty

import com.google.gson.annotations.SerializedName

data class StockInfo (
    @SerializedName("shopCode") var shopCode : String = "",
    @SerializedName("shopName") var shopName : String = "",
    @SerializedName("productCode") var productCode : String = "",
    @SerializedName("productName") var productName : String = "",
    @SerializedName("managerCode") var managerCode : String = "",
    @SerializedName("productPrice") var productPrice : Int = 0,
    @SerializedName("stockCount") var QTY : Int = 0
)