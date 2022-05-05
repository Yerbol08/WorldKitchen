package com.example.worldkitchen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Choice : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    var currentUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        mAuth = FirebaseAuth.getInstance()
        currentUser = mAuth!!.currentUser
    }


    fun gotosignuppage(view: View?) {
        val intent = Intent(applicationContext, Register::class.java)
        startActivity(intent)
    }

    fun gotosigninpage(view: View?) {
        val intent = Intent(applicationContext, Login::class.java)
        startActivity(intent)
    }
}