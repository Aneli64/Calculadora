package com.example.calculadora
class Error {
    companion object {
        /**
         * funcion que utilizamos para comprobar el correcto formato de nuuestra operacion
         * @param valores numeros a pasar
         * @return Boolean que nos muestra si se cumple o no la excepcion
         */
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