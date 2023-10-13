package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numeros
        val boton0 = findViewById<Button>(R.id.boton0)
        val boton1 = findViewById<Button>(R.id.boton1)
        val boton2 = findViewById<Button>(R.id.boton2)
        val boton3 = findViewById<Button>(R.id.boton3)
        val boton4 = findViewById<Button>(R.id.boton4)
        val boton5 = findViewById<Button>(R.id.boton5)
        val boton6 = findViewById<Button>(R.id.boton6)
        val boton7 = findViewById<Button>(R.id.boton7)
        val boton8 = findViewById<Button>(R.id.boton8)
        val boton9 = findViewById<Button>(R.id.boton9)

        //Tipo operacion
        val botonMas = findViewById<Button>(R.id.botonMas)
        val botonMenos = findViewById<Button>(R.id.botonMenos)
        val botonPor = findViewById<Button>(R.id.botonPor)
        val botonEntre = findViewById<Button>(R.id.botonEntre)
        val botonEquals = findViewById<Button>(R.id.botonEquals)
        val botonCE = findViewById<Button>(R.id.botonCE)

        //lista de botones
        val botones = listOf<Button>(
            boton0, boton1, boton2, boton3, boton4, boton5, boton6,
            boton7, boton8, boton9, botonMas, botonMenos, botonPor, botonEntre, botonEquals, botonCE
        )

        //texto donde van apareciendo nuestros parametros
        val texto = findViewById<TextView>(R.id.texto)

        val calc = Calculo()
        var cifrasLinea = ""
        var tipoOp = ""

        for (i in botones.indices) {
            botones[i].setOnClickListener {
                when (i) {
                    in 0..9 -> {
                        cifrasLinea += botones[i].text //podemos hacer funcion
                        texto.hint = cifrasLinea // de esto en Calculo()
                    }

                    in 10..13 -> {
                        cifrasLinea += botones[i].text //podemos hacer funcion
                        texto.hint = cifrasLinea // de esto en Calculo()

                        tipoOp = botones[i].text.toString() //guardamos tipo de operacion
                    }

                    14 -> {
                        val op = cifrasLinea.split("+", "-", "x", "/")
                        val res = calc.doOperation(op[0].toFloat(), tipoOp, op[1].toFloat())
                        texto.hint = res.toString()
                        cifrasLinea = res.toString() //igualamos al resultado -> num1 = resultado

                    }

                    //limpiamos con CE
                    15 -> {
                        texto.hint = ""
                        cifrasLinea = ""
                    }
                }
            }
        }
    }
}
