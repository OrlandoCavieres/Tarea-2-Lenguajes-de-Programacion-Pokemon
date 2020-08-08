package Tarea2

import org.junit.Test
import org.junit.Assert.*

class PokemonTest {
    @Test fun testInstancias() {
        val charmander = FirePokemon("Charmander")
        val charmy = FirePokemon("Charmander")
        assertEquals(charmander.nombre, "Charmander")
        assertEquals(charmander.tipo, charmy.tipo)
        assertEquals("Normal", charmander.tipoAtaqueSecundario)
        assertEquals("Fuego", charmander.tipoAtaquePrimario)
    }

    @Test fun testPruebaVida() {
        val chikorita = GrassPokemon("Chikorita")
        assertFalse("Se espera que si no tiene vida aun no este fuera de combate", chikorita.fueraDeCombate())
        chikorita.contadorDamage += 210
        assertTrue("Se espera que con un contador de daño en 210 y una vida de 200, este fuera de combate", chikorita.fueraDeCombate())
    }
}
