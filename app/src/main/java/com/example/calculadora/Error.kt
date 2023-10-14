package com.example.calculadora
class Error {
    companion object {
        fun excepFormato(valores: String): Boolean {
            //utilizamos una Regex para verificar el formato -> numero,operador,numero
            val operRegul = "\\d+[-+x/]\\d+".toRegex()
            //comprobamos 1- Si esta vacío || 2- Si cumple con nuestro formato
            //en el caso de que no se cumplan, nos devuelve un Boolean que utilizaremos para soltar la excepcion
            when {
                valores.isEmpty() -> return true
                !operRegul.containsMatchIn(valores) -> return true
            }
            return false
        }
    }
}