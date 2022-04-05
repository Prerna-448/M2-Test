package com.example.m2test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.math.MathContext

class MyAdapter(
    var context: Context,
    var data: ArrayList<ModelClass>
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {



        // Define click listener for the ViewHolder's View.
        var text1 = view.findViewById<TextView>(R.id.text1)
        var text2 = view.findViewById<TextView>(R.id.text2)
        var text3 = view.findViewById<TextView>(R.id.text3)
        var text4 = view.findViewById<TextView>(R.id.text4)
        var image = view.findViewById<ImageView>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_my_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userData = data[position]

        holder.text1.text = userData.text1
        holder.text2.text = userData.text2
        holder.text3.text = userData.text3
        holder.text4.text = userData.text4
        Glide.with(context).load(userData.image).into(holder.image);
    }

    override fun getItemCount(): Int {
        return data.size
    }
}