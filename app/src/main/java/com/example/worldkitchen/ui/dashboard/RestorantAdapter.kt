package com.example.worldkitchen.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldkitchen.R

class RestorantAdapter: RecyclerView.Adapter<RestorantAdapter.RestorantViewHolder>() {
    var list = listOf<RestoranItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onItemClickListener:((RestoranItem) ->Unit)? = null

    class RestorantViewHolder (view: View):RecyclerView.ViewHolder(view){
        val name: TextView = itemView.findViewById(R.id.name)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val rating: TextView = itemView.findViewById(R.id.rating)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val price: TextView = itemView.findViewById(R.id.priceTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestorantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restorant_layout, parent, false)
        return RestorantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestorantViewHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.imageView.setImageResource(item.image)
        holder.rating.text = item.rating.toString()
        holder.ratingBar.numStars = 5
        holder.ratingBar.rating = item.rating.toFloat()
        holder.price.text = item.price
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(item)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}