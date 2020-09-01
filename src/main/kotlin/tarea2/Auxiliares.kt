package tarea2

import kotlin.math.pow

/**
 * Función infija que permite emplear 'elevado' como conector entre dos elementos en una expresión y calcula
 * la potencia del primer numero con exponente el segundo numero.
 * @Sample 4 elevado 7
 */
infix fun Int.elevado(exponente: Int): Int = toDouble().pow(exponente).toInt()
