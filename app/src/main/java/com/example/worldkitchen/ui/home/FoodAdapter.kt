package com.example.worldkitchen.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldkitchen.R

class FoodAdapter(private val list: List<Food>, var context: Context):
    RecyclerView.Adapter<FoodAdapter.ViewHolder>()  {

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val title = itemView.findViewById<TextView>(R.id.title_tort)
        val imageView = itemView.findViewById<ImageView>(R.id.imageview)
        val text = itemView.findViewById<TextView>(R.id.text_tort)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        val items = list[position]
        holder.imageView.setImageResource(items.image)
        holder.title.setText(items.name)
        holder.text.setText(items.text)
        holder.itemView.setOnClickListener{
            var intent: Intent = Intent(context, FoodActivity::class.java)
            intent.putExtra("name", items.name)
            intent.putExtra("image", items.image)
            intent.putExtra("text", items.text)
            intent.putExtra("position", position)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}