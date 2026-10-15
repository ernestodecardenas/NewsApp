package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // Asignar la Toolbar como la barra de acción
        val toolbar = findViewById<Toolbar>(R.id.toolbarPerfil)
        setSupportActionBar(toolbar)

        // Habilita la flecha de regresar (<-)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Infla el menú de opciones (3 puntos)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return true
    }

    // Maneja la acción de regresar y las opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Regresa a la pantalla anterior (Noticias)
                true
            }
            R.id.action_privacidad -> {
                startActivity(Intent(this, PrivacidadActivity::class.java))
                true
            }
            R.id.action_contactos -> {
                startActivity(Intent(this, ContactosActivity::class.java))
                true
            }
            R.id.action_central -> {
                // Opción sin función requerida
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}