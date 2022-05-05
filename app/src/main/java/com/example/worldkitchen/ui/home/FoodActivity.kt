package com.example.worldkitchen.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.worldkitchen.R

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)


        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textRecept)
        val title_kitchen =  findViewById<TextView>(R.id.title_kitchen)
        val text_kitchen =  findViewById<TextView>(R.id.textView_kitchen)

        val position = getIntent().getIntExtra("position", 0)
        val title = getIntent().getIntExtra("name", R.string.food1)
        val image = getIntent().getIntExtra("image", R.drawable.image1)
        val text  = getIntent().getIntExtra("text", R.string.text1)

        title_kitchen.setText(title)
        imageView.setImageResource(image)
        text_kitchen.setText(text)

        when(position){
            0-> {
                textView.setText(R.string.recept1)
            }
            1-> textView.setText(R.string.recept2)
            2-> textView.setText(R.string.recept3)
            3-> textView.setText(R.string.recept4)
            4-> textView.setText(R.string.recept5)

        }
    }
}