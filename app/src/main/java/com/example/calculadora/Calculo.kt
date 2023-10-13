package com.example.calculadora

class Calculo() {
    private var resultado = 0.0F

    private fun sumar(num1: Float, num2: Float) = num1 + num2
    private fun restar(num1: Float, num2: Float) = num1 - num2
    private fun multiplicar(num1: Float, num2: Float) = num1 * num2
    private fun dividir(num1: Float, num2: Float) = num1 / num2

    fun doOperation(num1: Float, operacion: String, num2: Float): Float {
        when (operacion) {
            "+" -> resultado = sumar(num1, num2)
            "-" -> resultado = restar(num1, num2)
            "x" -> resultado = multiplicar(num1, num2)
            "/" -> resultado = dividir(num1, num2)
        }
        return resultado
    }
}