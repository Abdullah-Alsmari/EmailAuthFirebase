package com.example.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.auth.AuthUI

class HomeActivity : AppCompatActivity() {

    private lateinit var signOut : Button
    private lateinit var name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        signOut = findViewById(R.id.signOut)
        name = findViewById(R.id.name)
        val user = intent.getStringExtra("user")
        name.setText(user)
        signOut.setOnClickListener {
            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    finish()
                    Toast.makeText(this,"You have been successfully signed out",Toast.LENGTH_LONG).show()
                }
        }
    }
}