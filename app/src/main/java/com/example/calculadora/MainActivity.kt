package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Context
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //texto donde van apareciendo nuestros parametros
    private lateinit var texto: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lista de botones
        val botones = listOf<Button>(
            findViewById(R.id.boton0),
            findViewById(R.id.boton1),
            findViewById(R.id.boton2),
            findViewById(R.id.boton3),
            findViewById(R.id.boton4),
            findViewById(R.id.boton5),
            findViewById(R.id.boton6),
            findViewById(R.id.boton7),
            findViewById(R.id.boton8),
            findViewById(R.id.boton9),
            findViewById(R.id.botonMas),
            findViewById(R.id.botonMenos),
            findViewById(R.id.botonPor),
            findViewById(R.id.botonEntre),
            findViewById(R.id.botonEquals),
            findViewById(R.id.botonCE),
            findViewById(R.id.botonCE1),
            findViewById(R.id.botonPunto)
        )
        fun mensError(msj: String){
            Toast.makeText(this, msj, Toast.LENGTH_LONG).show()
        }

        texto = findViewById(R.id.texto)
        val calc = Calculo()

        for (i in botones.indices) {
            botones[i].setOnClickListener {
                val resultado = calc.BotonClick(i, botones[i].text.toString())
                if (resultado == ""){
                    mensError("Error de cifras")
                }
                texto.hint = resultado
            }
        }
    }
}

