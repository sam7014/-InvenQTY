package com.example.invenqty

import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

data class StockInfo (
    @SerializedName("shopCode") var shopCode : String,
    @SerializedName("shopName") var shopName : String,
    @SerializedName("productCode") var productCode : String,
    @SerializedName("productName") var productName : String,
    @SerializedName("managerCode") var managerCode : String,
    @SerializedName("productPrice") var productPrice : Int,
    @SerializedName("stockCount") var QTY : Int
)

class StockInfo2{
    @SerializedName("shopCode") var shopCode : String = ""
    @SerializedName("shopName") var shopName : String = ""
    @SerializedName("productCode") var productCode : String = ""
    @SerializedName("productName") var productName : String = ""
    @SerializedName("managerCode") var managerCode : String = ""
    @SerializedName("productPrice") var productPrice : Int = 0
    @SerializedName("stockCount") var QTY : Int = 0

    val getManagerCode2Korean : String
        get() {
        return when(this.managerCode){
            "01" -> "운영"
            "02" -> "단종"
            "03" -> "단예"
            "04" -> "해외"
            else -> this.managerCode
        }
    }

    val getProductPriceWithComma : String
        get() {
        val formatter = DecimalFormat("###,###")
        return formatter.format(this.productPrice)
    }

    val getShopName : String get() {
        return this.shopName.replace("창고","")
    }
}