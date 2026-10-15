package com.example.newsapp

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ContactosActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        val toolbar = findViewById<Toolbar>(R.id.toolbarContactos)
        setSupportActionBar(toolbar)

        // Habilita la flecha de regresar en la barra superior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listView = findViewById(R.id.listViewContactos)

        val contactos = arrayOf(
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987",
            "Prensa Editorial: +51 1 987987987"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactos)
        listView.adapter = adapter

        registerForContextMenu(listView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return true
    }

    // Maneja la acción de regresar y el menú superior
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // Menú contextual para los contactos
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_llamar -> true
            R.id.action_enviar_mensaje -> true
            else -> super.onContextItemSelected(item)
        }
    }
}