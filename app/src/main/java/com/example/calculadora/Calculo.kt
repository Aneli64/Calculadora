package com.example.calculadora

class Calculo {
    private var resultado = 0.0F

    /**
     * Funcion suma
     * @param num1 Primer valor a sumar
     * @param num2 Segundo valor a sumar
     * @return Suma de ambos numeros
     */
    private fun sumar(num1: Float, num2: Float) = num1 + num2

    /**
     * Funcion restar
     * @param num1 Primer valor a restar
     * @param num2 Segundo valor a restar
     * @return Resta de ambos numeros
     */
    private fun restar(num1: Float, num2: Float) = num1 - num2

    /**
     * Funcion multiplicar
     * @param num1 Primer valor a multiplicar
     * @param num2 Segundo valor a multiplicar
     * @return Producto de ambos numeros
     */
    private fun multiplicar(num1: Float, num2: Float) = num1 * num2

    /**
     * Funcion dividir
     * @param num1 Primer valor a dividir
     * @param num2 Segundo valor a dividir
     * @return Division de ambos numeros
     */
    private fun dividir(num1: Float, num2: Float) = num1 / num2

    /**
     * Funcion que nos realiza una operacion basandonos en un metodo privado y usando su operacion
     * @param num1 Primer valor a operar
     * @param operacion Tipo de operacion
     * @param num2 Segundo valor a operar
     * @return Resultado de operacion de ambos numeros
     */
    private fun Operation(num1: Float, operacion: String, num2: Float): Float {
        when (operacion) {
            "+" -> resultado = sumar(num1, num2)
            "-" -> resultado = restar(num1, num2)
            "x" -> resultado = multiplicar(num1, num2)
            "/" -> resultado = dividir(num1, num2)
        }
        return resultado
    }

    //Hacemos la operacion, haciendo uso de split (obtenemos unicamente los numeros), y con la private fun Operation realizamos la operacion
    /**
     * Funcion publica que nos realiza la operacio con el uso de los valores y el tipo de operacion
     * @param valores Valores a procesar en nuestra calculadora
     * @param tipoOp Tipo de operacion (+,-,x,/)
     * @return Resultado final que vamos a ir introduciendo en nuestra calculadora
     */
    fun doOperation(valores: String, tipoOp: String): Float {
        val op = valores.split("+", "-", "x", "/", "=")
        return Operation(op[0].toFloat(), tipoOp, op[1].toFloat())
    }
}