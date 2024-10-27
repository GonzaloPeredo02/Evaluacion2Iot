package com.example.sgalert_version_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cambiarPantalla: Button = findViewById(R.id.btnIntegrantes)
        cambiarPantalla.setOnClickListener {
            //variable para llamar a otra pantalla, con this veo a que activity ir.
            val intent = Intent(this,Integrantes::class.java)
            startActivity(intent)
        }
        val cambiarPantalla2: Button = findViewById(R.id.btnEmergencia)
        cambiarPantalla2.setOnClickListener {
            val intent = Intent(this,Emergencia::class.java)
            startActivity(intent)
        }
        val cambiarPantalla3: Button = findViewById(R.id.btnRegistro)
        cambiarPantalla3.setOnClickListener {
            val intent = Intent(this,Registro::class.java)
            startActivity(intent)
        }
        val buttonDialH = findViewById<Button>(R.id.numeroHogar)
        buttonDialH.setOnClickListener {
            val phoneNumber = "9 3234 4312"
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(dialIntent)
        }
        val salir: Button = findViewById(R.id.btnSalir)
        salir.setOnClickListener {
            val intent = Intent(this,Ingreso::class.java)
            startActivity(intent)
        }
    }
}