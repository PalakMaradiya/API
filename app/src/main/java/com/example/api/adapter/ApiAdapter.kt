package com.example.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.activity.MainActivity
import com.example.api.response.ResponseItem

class ApiAdapter(var context: MainActivity, var result: List<ResponseItem>) :
    RecyclerView.Adapter<ApiAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtId: TextView = itemView.findViewById(R.id.txtId)
        var txtAlbumId: TextView = itemView.findViewById(R.id.txtAlbumId)
        var txtTitle: TextView = itemView.findViewById(R.id.txtTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var View = LayoutInflater.from(context).inflate(R.layout.item_file, parent, false)
        return MyViewHolder(View)
    }

    override fun getItemCount(): Int {
        return result.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtId.text = result.get(position)!!.id.toString()
        holder.txtAlbumId.text = result.get(position)!!.title.toString()
        holder.txtTitle.text = result.get(position)!!.title.toString()


    }
}