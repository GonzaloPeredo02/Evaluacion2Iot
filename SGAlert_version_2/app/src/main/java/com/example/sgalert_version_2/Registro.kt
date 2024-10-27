package com.example.sgalert_version_2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity() {

    private lateinit var buttonDelete: Button
    private lateinit var listViewNames: ListView
    private val namesList = mutableListOf(
        "Fecha: 29/03/24, Hora: 20:32, Gas: CO, Rango: 60",//agregamos registros para que esten disponibles para poder borrarlos.
        "Fecha: 30/03/24, Hora: 10:23, Gas: CO, Rango: 65",
        "Fecha: 01/04/24, Hora: 21:45, Gas: CO, Rango: 70",
        "Fecha: 02/04/24, Hora: 22:36, Gas: CO, Rango: 50",
        "Fecha: 04/04/24, Hora: 23:46, Gas: CO, Rango: 55",
        "Fecha: 07/04/24, Hora: 09:21, Gas: CO, Rango: 57",
        "Fecha: 10/04/24, Hora: 10:12, Gas: CO, Rango: 60",

        )
    private lateinit var adapter: ArrayAdapter<String>
    private var selectedIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        buttonDelete = findViewById(R.id.buttonDelete)
        listViewNames = findViewById(R.id.listViewNames)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesList)
        listViewNames.adapter = adapter

        buttonDelete.setOnClickListener {
            selectedIndex?.let {
                namesList.removeAt(it)
                adapter.notifyDataSetChanged()
                selectedIndex = null
                Toast.makeText(this, "Elemento eliminado.", Toast.LENGTH_SHORT).show()
            }
        }

        listViewNames.setOnItemClickListener { _, _, position, _ ->
            selectedIndex = position
        }
        val cambiarPantalla: Button = findViewById(R.id.btnAtrasMenu)
        cambiarPantalla.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}

