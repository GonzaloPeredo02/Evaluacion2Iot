package com.example.sgalert_version_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ingreso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingreso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usernameEditText = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.ingresaUsuario)
        val passwordEditText = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.ingresaContraseña)
        val loginButton = findViewById<Button>(R.id.elevatedButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.editText?.text.toString()
            val password = passwordEditText.editText?.text.toString()

            try {
                if (username == "admin" && password == "1234") {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {

                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {

                Toast.makeText(this, "Error al iniciar sesión: ${e.message}", Toast.LENGTH_LONG).show()
            }

        }

    }
}



