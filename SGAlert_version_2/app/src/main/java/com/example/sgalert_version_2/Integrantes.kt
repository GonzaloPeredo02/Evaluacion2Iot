package com.example.sgalert_version_2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sgalert_version_2.MainActivity
import com.example.sgalert_version_2.R

class Integrantes : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonEdit: Button
    private lateinit var buttonDelete: Button
    private lateinit var listViewNames: ListView
    private val namesList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>
    private var selectedIndex: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_integrantes)

        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonEdit = findViewById(R.id.buttonEdit)
        buttonDelete = findViewById(R.id.buttonDelete)
        listViewNames = findViewById(R.id.listViewNames)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesList)
        listViewNames.adapter = adapter

        buttonAdd.setOnClickListener {
            if (namesList.size < 3) {
                val name = editTextName.text.toString()
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
                    val entry = "Nombre: $name, Correo: $email, Teléfono: $phone"
                    namesList.add(entry)
                    adapter.notifyDataSetChanged()
                    editTextName.text.clear()
                    editTextEmail.text.clear()
                    editTextPhone.text.clear()
                }
            } else {
                Toast.makeText(this, "Solo se permiten 3 ingresos.", Toast.LENGTH_SHORT).show()
            }
        }

        buttonEdit.setOnClickListener {
            selectedIndex?.let {
                val name = editTextName.text.toString()
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
                    val entry = "Nombre: $name, Correo: $email, Teléfono: $phone"
                    namesList[it] = entry
                    adapter.notifyDataSetChanged()
                    editTextName.text.clear()
                    editTextEmail.text.clear()
                    editTextPhone.text.clear()
                    selectedIndex = null
                }
            }
        }

        buttonDelete.setOnClickListener {
            selectedIndex?.let {
                namesList.removeAt(it)
                adapter.notifyDataSetChanged()
                editTextName.text.clear()
                editTextEmail.text.clear()
                editTextPhone.text.clear()
                selectedIndex = null
                Toast.makeText(this, "Elemento eliminado.", Toast.LENGTH_SHORT).show()
            }
        }

        listViewNames.setOnItemClickListener { _, _, position, _ ->
            val selectedEntry = namesList[position]
            val parts = selectedEntry.split(", ")
            editTextName.setText(parts[0].substringAfter(": "))
            editTextEmail.setText(parts[1].substringAfter(": "))
            editTextPhone.setText(parts[2].substringAfter(": "))
            selectedIndex = position
        }
        val cambiarPantalla: Button = findViewById(R.id.btnAtrasMenu)
        cambiarPantalla.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}



