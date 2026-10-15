package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        // Intent explícito hacia la pantalla Noticias
        btnIngresar.setOnClickListener {
            val intent = Intent(this, NoticiasActivity::class.java)
            startActivity(intent)
        }
    }
}