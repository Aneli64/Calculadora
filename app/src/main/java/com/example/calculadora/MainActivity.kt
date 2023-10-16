package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Context
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast que nos proporciona un mensaje ante error general
        val contexto: Context = this
        val mens = "Debe introducir 2 números y una operación " +
                "para mostrar un resultado."
        val durac = Toast.LENGTH_LONG
        val tErrorGeneral = Toast.makeText(contexto, mens, durac)


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
        var valores = ""
        var tipoOp = ""

        //variable que cuenta los operandos
        var numOP = 0

        /**
         * Bucle For que nos intera en los indices delos botones para realizar sus Listener
         */
        for (i in botones.indices) {
            botones[i].setOnClickListener {
                when (i) {
                    in 0..9 -> {
                        valores += botones[i].text
                        texto.hint = valores
                    }

                    in 10..13 -> {

                        if (numOP >= 1) { //realizamos misma operacion de "="(14) en cuanto introducimos un segundo operador
                            while (Error.excepFormato(valores)) {
                                tErrorGeneral.show()
                                valores = ""
                                return@setOnClickListener //volvemos al listener para seguir usando app
                            }
                            val res = calc.doOperation(valores, tipoOp)
                            texto.hint = res.toString()
                            valores = res.toString() //igualamos al resultado -> num1 = resultado

                            //lo volvemos a dejar en 1 para continuar desde inicio
                            numOP = 1

                            valores += botones[i].text
                            texto.hint = valores

                            tipoOp = botones[i].text.toString() //guardamos tipo de operacion

                        } else {
                            valores += botones[i].text
                            texto.hint = valores

                            tipoOp = botones[i].text.toString() //guardamos tipo de operacion
                            numOP++ //incrementamos operando para saber con cuantos estamos tratando
                        }
                    }

                    14 -> {
                        while (Error.excepFormato(valores)) {
                            tErrorGeneral.show()
                            valores = ""
                            return@setOnClickListener //volvemos al listener para seguir usando app
                        }
                        val res = calc.doOperation(valores, tipoOp)
                        texto.hint = res.toString()
                        valores = res.toString() //igualamos al resultado -> num1 = resultado

                        //resetamos contador
                        numOP = 0

                    }

                    //limpiamos con CE
                    15 -> {
                        texto.hint = ""
                        valores = ""

                        //resetamos contador
                        numOP = 0
                    }
                }
            }
        }
    }
}
