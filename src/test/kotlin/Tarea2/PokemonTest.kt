package Tarea2

import org.junit.Test
import org.junit.Assert.*

class PokemonTest {
    @Test fun testInstancias() {
        val charmander = FirePokemon("Charmander")
        val charmy = FirePokemon("Charmander")
        assertNotNull("Revisar que el objeto charmy no sea nulo", charmy)
        assertEquals("Asegurar que el objeto charmander sobreescribió el nombre correctamente al que corresponde", charmander.nombre, "Charmander")
        assertEquals("La propiedad tipo de los objetos charmander y charmy al ser ambos FirePokemon debe ser igual", charmander.tipo, charmy.tipo)
        assertTrue("Se espera que charmander y charmy sean de la misma clase", charmander::class == charmy::class)
    }

    @Test fun testPruebaVida() {
        val chikorita = GrassPokemon("Chikorita")
        assertFalse("Se espera que si un contador de daño en 0, no este fuera de combate", chikorita.fueraDeCombate())
        chikorita.contadorDamage += 210
        assertTrue("Se espera que con un contador de daño en 210 y una vida de 200, este fuera de combate", chikorita.fueraDeCombate())
    }

    @Test fun testBatallaConDebilidad() {
        val squirtle = WaterPokemon("Squirtle")
        val pikachu = ElectricPokemon("Pikachu")
        assertEquals("Sin recibir daño, el contador de daño debe valer 0", 0, squirtle.contadorDamage)
        assertEquals("No se ha modificado el ataque seleccionado de 1", 1, pikachu.ataqueSeleccionado)
        pikachu.iniciarAtaque(squirtle)
        assertEquals("Squirtle es debil frente a Pikachu, se espera un daño de 70", 70, squirtle.contadorDamage)
        assertEquals("Pikachu no tiene daño aun", 0, pikachu.contadorDamage)
        squirtle.iniciarAtaque(pikachu)
        assertEquals("Pikachu no es debil pero tampoco resistente a Squirtle, se espera daño normal", 50, pikachu.contadorDamage)
        pikachu.seleccionarAtaqueAUsar(2)
        assertEquals("Pikachu cambio su ataque al secundario, por lo que ataque seleccionado deberia ser 2", 2, pikachu.ataqueSeleccionado)
        pikachu.iniciarAtaque(squirtle)
        assertEquals("Squirtle no es debil ni resistente a un ataque de tipo Normal, aumenta el contador en 30", 100, squirtle.contadorDamage)
        squirtle.seleccionarAtaqueAUsar(2)
        assertEquals("Squirtle selecciono su ataque secundario, por lo que el ataque seleccionado es 2 ahora", 2, squirtle.ataqueSeleccionado)
        squirtle.iniciarAtaque(pikachu)
        assertEquals("El contador de daño de Pikachu deberia subir en 30", 80, pikachu.contadorDamage)
        pikachu.seleccionarAtaqueAUsar(1)
        pikachu.iniciarAtaque(squirtle)
        pikachu.iniciarAtaque(squirtle)
        assertEquals("2 ataques seguidos de Pikachu que aumentan el contador de daño de Squirtle a 240", 240, squirtle.contadorDamage)
        squirtle.iniciarAtaque(pikachu)
        assertEquals("Squirtle no tiene mas vida, no deberia causar daño a Pikachu", 80, pikachu.contadorDamage)
    }
}
