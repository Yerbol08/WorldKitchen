package com.example.worldkitchen.ui.dashboard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.worldkitchen.R

class RestorantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restorant)

        val imageView = findViewById<ImageView>(R.id.placeImage)
        val title =  findViewById<TextView>(R.id.title)
        val rating = findViewById<TextView>(R.id.rating)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val phone = findViewById<TextView>(R.id.phone)
        val about = findViewById<TextView>(R.id.textViewAbout)
        val hours = findViewById<TextView>(R.id.hours)
        val location = findViewById<TextView>(R.id.directions)

        //val position = getIntent().getIntExtra("position", 0)
        val titleString = getIntent().getStringExtra("name")
        val image = getIntent().getIntExtra("image", R.drawable.rest1)
        val ratingDouble  = getIntent().getDoubleExtra("rating", 4.0)
        imageView.setImageResource(image)
        title.setText(titleString)
        rating.setText(ratingDouble.toString())
        ratingBar.numStars = 5
        ratingBar.rating = ratingDouble.toFloat()
        phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone.text as String))
            startActivity(intent)
        }
        when(titleString){
            "Астау"-> {
                about.setText(R.string.rest_info1)
                location.setText(R.string.rest_address1)
                phone.setText(R.string.rest_phone1)
                hours.setText(R.string.rest_time1)
            }
            "Ак Тілек"-> {
                about.setText(R.string.rest_info4)
                location.setText(R.string.rest_address4)
                phone.setText(R.string.rest_phone4)
                hours.setText(R.string.rest_time4)
            }
            "Arnau"-> {
                about.setText(R.string.rest_info2)
                location.setText(R.string.rest_address2)
                phone.setText(R.string.rest_phone2)
                hours.setText(R.string.rest_time2)
            }
            "Жибек-Жолы"-> {
                about.setText(R.string.rest_info3)
                location.setText(R.string.rest_address3)
                phone.setText(R.string.rest_phone3)
                hours.setText(R.string.rest_time3)
            }
            "Jumbaktas"-> {
                about.setText(R.string.rest_info5)
                location.setText(R.string.rest_address5)
                phone.setText(R.string.rest_phone5)
                hours.setText(R.string.rest_time5)
            }
        }
    }
}