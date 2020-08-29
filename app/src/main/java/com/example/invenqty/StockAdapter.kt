package com.example.invenqty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*

class StockAdapter : RecyclerView.Adapter<Holder>() {

    var stockList = mutableListOf<StockInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // 레이아웃을 인플레이트하고 홀더에 담아서 리턴
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val stock = stockList.get(position)
        holder.setStock(stock)
    }

    override fun getItemCount(): Int {
        return stockList.size
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun setStock(stockInfo: StockInfo){
        itemView.textView_Place.text = stockInfo.shopName
        itemView.textView_ProductCode.text = stockInfo.productCode
        itemView.textView_ProductName.text = stockInfo.productName
        itemView.textView_ManageCode.text = stockInfo.managerCode
        itemView.textView_ProductPrice.text = stockInfo.productPrice.toString()
        itemView.textView_QTY.text = stockInfo.QTY.toString()
    }
}