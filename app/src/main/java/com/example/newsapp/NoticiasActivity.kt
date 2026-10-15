package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticiasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        // Aplica margen automático según la barra de estado y la cámara del dispositivo
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnPerfil = findViewById<ImageView>(R.id.btnPerfil)
        val btnShare = findViewById<FloatingActionButton>(R.id.btnShare)

        btnPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "https://developer.android.com/training/sharing/")
            }
            startActivity(Intent.createChooser(shareIntent, "Share"))
        }
    }
}