package com.muscode.scrollbasics.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muscode.scrollbasics.R
import com.muscode.scrollbasics.model.FruitModel

class FruitAdapter(ctx: Context, private val imageModelArrayList: ArrayList<FruitModel>) :
    RecyclerView.Adapter<FruitAdapter.MyViewHolder>() {

    override fun getItemCount(): Int = imageModelArrayList.size

    private val inflater: LayoutInflater = LayoutInflater.from(ctx)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.iv.setImageResource(imageModelArrayList[position].imageDrawable)
        holder.time.text = imageModelArrayList[position].name
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var time: TextView = itemView.findViewById(R.id.tv) as TextView
        var iv: ImageView = itemView.findViewById(R.id.iv) as ImageView
    }
}