package Tarea2

import org.junit.Test
import org.junit.Assert.*

class PokemonTest {
    @Test fun testInstancias() {
        val pidgey: NormalPokemon? = null
        val charmander = FirePokemon("Charmander")
        val charmy = FirePokemon("Charmander")
        val mantine = WaterPokemon("Mantine")
        assertNull("Pídgey es nulo", pidgey)
        assertNotNull("Revisar que el objeto charmy no sea nulo", charmy)
        assertEquals("Asegurar que el objeto charmander sobreescribió el nombre correctamente al que corresponde",
                     charmander.nombre, "Charmander")
        assertEquals("La propiedad tipo de los objetos charmander y charmy al ser ambos FirePokemon debe ser igual",
                     charmander.tipo, charmy.tipo)
        assertTrue("Se espera que charmander y charmy sean de la misma clase", charmander::class == charmy::class)
        assertTrue("Se espera que mantine y charmander sean de distinta clase", charmander::class != mantine::class)
        assertEquals("Atacar a un Pokemon no inicializado da Null", null, charmander.iniciarAtaque(pidgey))
        assertEquals("Atacar a un Pokemon inicialiado correctamente, entrega al pokemon atacado",
                     charmy, mantine.iniciarAtaque(charmy))
    }

    @Test fun testChequeoExperienciaRequeridaYAumentoNivel() {
        val sandslash = GroundPokemon("Sandslash")
        assertEquals("A nivel 1 se requiere 7 puntos de experiencia para subir a nivel 2",
                     7, sandslash.experienciaRequeridaSubirNivel())
        sandslash.experienciaAcumuladaEnNivel += 7
        assertTrue("Al aumentar la experiencia acumulada en nivel 1 a 7 debe poder subir de nivel",
                   sandslash.verificarRequisitoExpSubirNivel())
        sandslash.subirNivel()
        assertEquals("Al aplicar subirNivel el nivel debe aumentar en 1", 2, sandslash.nivel)
        assertTrue("La vida debió aumentar al subir de nivel", sandslash.vida > 40)
        assertTrue("El ataque primario debió aumentar al subir de nivel", sandslash.ataquePrimario > 50)
        assertTrue("El ataque secundario debió aumentar al subir de nivel", sandslash.ataqueSecundario > 30)
        assertEquals("Al subir de nivel debe researtearse en 0 la experiencia acumulada para subir de nivel",
                     0, sandslash.experienciaAcumuladaEnNivel)
        sandslash.subirNivel()
        assertEquals("Sin experiencia acumulada en el nivel 2 no puede subir de nivel", 2, sandslash.nivel)
        sandslash.experienciaAcumuladaEnNivel += 10
        assertEquals("Sandslash ganó 10 puntos de experiencia", 10, sandslash.experienciaAcumuladaEnNivel)
        assertFalse("Con 10 puntos de experiencia aún no puede subir de nivel", sandslash.verificarRequisitoExpSubirNivel())
        sandslash.experienciaAcumuladaEnNivel += 20
        assertEquals("Sandslash ganó 20 puntos de experiencia, acumulando 30", 30, sandslash.experienciaAcumuladaEnNivel)
        assertTrue("Con 30 puntos de experiencia puede subir de nivel", sandslash.verificarRequisitoExpSubirNivel())
        sandslash.subirNivel()
        assertEquals("Como cumplia el requisito ahora tiene nivel 3", 3, sandslash.nivel)
        assertEquals("Al subir de nivel, sobraron 11 puntos de experiencia, ahora aplicados a la barra en nivel 3",
                     11, sandslash.experienciaAcumuladaEnNivel)
        var c = 3
        while (c <= 100) {
            sandslash.experienciaAcumuladaEnNivel += sandslash.experienciaRequeridaSubirNivel()
            sandslash.subirNivel()
            c += 1
        }
        assertEquals("Sandslash debe ser de nivel 100 ahora", 100, sandslash.nivel)
        sandslash.experienciaAcumuladaEnNivel += sandslash.experienciaRequeridaSubirNivel()
        sandslash.subirNivel()
        assertEquals("100 es el nivel máximo. No puede subir más de nivel", 100, sandslash.nivel)
        assertEquals("Como se esta en nivel máximo se resetea a 0 la experiencia acumulada del nivel y se mantiene asi",
                     0, sandslash.experienciaAcumuladaEnNivel)
    }

    @Test fun testPruebaVida() {
        val chikorita = GrassPokemon("Chikorita")
        assertFalse("Se espera que con un contador de daño en 0, no este fuera de combate", chikorita.fueraDeCombate())
        chikorita.contadorDamage += 210
        assertTrue("Se espera que con un contador de daño en 210 y una vida de 40, este fuera de combate",
                   chikorita.fueraDeCombate())
    }

    @Test fun testAtaquePostderrota() {
        val mew = PsychicPokemon("Mew")
        val ratatta = NormalPokemon("Ratatta")
        ratatta.contadorDamage += 100
        assertEquals("Daño actual acumulado en mew deberia ser 0 porque no se ha modificado", 0, mew.contadorDamage)
        ratatta.iniciarAtaque(mew)
        assertEquals("Daño acumulado en Ratatta lo deja fuera de combate y no puede atacar a Mew", 0, mew.contadorDamage)
        mew.iniciarAtaque(ratatta)
        assertEquals("Mew no puede atacar más a Ratatta porque ya está fuera de combate", 100, ratatta.contadorDamage)
    }

    @Test fun testBatallaConDebilidad() {
        val squirtle = WaterPokemon("Squirtle", vida = 200)
        val pikachu = ElectricPokemon("Pikachu", vida = 200)
        assertEquals("Sin recibir daño, el contador de daño debe valer 0 para ambos", 0, squirtle.contadorDamage)
        assertEquals("Sin recibir daño, el contador de daño debe valer 0 para ambos", 0, pikachu.contadorDamage)
        assertEquals("No se ha modificado el ataque de Pikachu seleccionado, por lo que deberia ser 1",
                     1, pikachu.ataqueSeleccionado)
        pikachu.iniciarAtaque(squirtle)
        assertEquals("Squirtle es debil frente a Pikachu, aumenta su contador de daño en 70", 70, squirtle.contadorDamage)
        assertEquals("Pikachu no tiene daño aun, su contador se mantiene en 0", 0, pikachu.contadorDamage)
        squirtle.iniciarAtaque(pikachu)
        assertEquals("Pikachu no es debil pero tampoco resistente a Squirtle, se espera daño normal, aumenta en 50 el contador de daño",
                     50, pikachu.contadorDamage)
        pikachu.seleccionarAtaqueAUsar(2)
        assertEquals("Pikachu cambio su ataque al secundario, por lo que ataque seleccionado deberia ser 2",
                     2, pikachu.ataqueSeleccionado)
        pikachu.iniciarAtaque(squirtle)
        assertEquals("Squirtle no es debil ni resistente a un ataque de tipo Normal, aumenta el contador en 30, dado que es ataque secundario",
                     100, squirtle.contadorDamage)
        squirtle.seleccionarAtaqueAUsar(2)
        assertEquals("Squirtle selecciona su ataque secundario, por lo que el ataque seleccionado es 2 ahora",
                     2, squirtle.ataqueSeleccionado)
        squirtle.iniciarAtaque(pikachu)
        assertEquals("El contador de daño de Pikachu deberia subir en 30, dado ataque secundario normal de Squirtle",
                     80, pikachu.contadorDamage)
        pikachu.seleccionarAtaqueAUsar(1)
        pikachu.iniciarAtaque(squirtle)
        pikachu.iniciarAtaque(squirtle)
        assertEquals("2 ataques primarios seguidos de Pikachu que aumentan el contador de daño de Squirtle a 240",
                     240, squirtle.contadorDamage)
        squirtle.iniciarAtaque(pikachu)
        assertEquals("Squirtle no tiene mas vida, no deberia causar daño a Pikachu", 80, pikachu.contadorDamage)
    }

    @Test fun testBatallaConFortaleza() {
        val lucario = FightPokemon("Lucario", vida = 200)
        val diglett = GroundPokemon("Diglett", vida = 200)
        assertEquals("Sin recibir daño, el contador de daño debe valer 0 para ambos", 0, lucario.contadorDamage)
        assertEquals("Sin recibir daño, el contador de daño debe valer 0 para ambos", 0, diglett.contadorDamage)
        assertEquals("No se ha modificado el ataque de Diglett seleccionado, por lo que deberia ser 1",
                     1, diglett.ataqueSeleccionado)
        diglett.iniciarAtaque(lucario)
        assertEquals("Lucario es resistente al ataque primario de Diglett, aumenta su contador de daño en 30",
                     30, lucario.contadorDamage)
        assertEquals("Diglett no tiene daño aun, su contador se mantiene en 0", 0, diglett.contadorDamage)
        lucario.iniciarAtaque(diglett)
        assertEquals("Diglett no es debil pero tampoco resistente a Lucario, se espera daño normal, aumenta en 50 el contador de daño",
                     50, diglett.contadorDamage)
        diglett.seleccionarAtaqueAUsar(2)
        assertEquals("Diglett cambio su ataque al secundario, por lo que ataque seleccionado deberia ser 2",
                     2, diglett.ataqueSeleccionado)
        diglett.iniciarAtaque(lucario)
        assertEquals("Lucario no es debil ni resistente a un ataque de tipo Normal, aumenta el contador en 30, dado que es ataque secundario",
                     60, lucario.contadorDamage)
        lucario.seleccionarAtaqueAUsar(2)
        assertEquals("Lucario selecciona su ataque secundario, por lo que el ataque seleccionado es 2 ahora",
                     2, lucario.ataqueSeleccionado)
        lucario.iniciarAtaque(diglett)
        assertEquals("El contador de daño de Diglett deberia subir en 10, dado ataque secundario normal de Lucario al cual es resistente",
                     60, diglett.contadorDamage)
        lucario.seleccionarAtaqueAUsar(1)
        diglett.seleccionarAtaqueAUsar(1)
        diglett.iniciarAtaque(lucario)
        lucario.iniciarAtaque(diglett)
        diglett.iniciarAtaque(lucario)
        lucario.iniciarAtaque(diglett)
        diglett.iniciarAtaque(lucario)
        lucario.iniciarAtaque(diglett)
        assertEquals("Finalmente, diglett fue el primero en tener un contador de daño superior a 200, quedando fuera de combate",
                     210, diglett.contadorDamage)
        assertEquals("El contador de daño final de Lucario en esta batalla es de 150", 150, lucario.contadorDamage)
        diglett.iniciarAtaque(lucario)
        assertEquals("Diglett está fuera de combate y ha sido derrotado, por lo que no deberia causar daño a Lucario",
                     150, lucario.contadorDamage)
    }

    @Test fun testBatallaSinVentajas() {
        val treecko = GrassPokemon("Treecko", vida = 200)
        val abra = PsychicPokemon("Abra", vida = 200)
        assertEquals("Sin recibir daño, el contador de daño debe valer 0 para ambos", 0, abra.contadorDamage)
        assertEquals("Sin recibir daño, el contador de daño debe valer 0 para ambos", 0, treecko.contadorDamage)
        assertEquals("No se ha modificado el ataque de treecko seleccionado, por lo que deberia ser 1", 1, treecko.ataqueSeleccionado)
        treecko.iniciarAtaque(abra)
        assertEquals("Abra no es resistente ni debil a ataques de tipo hierba, por lo que recibe el daño normal de 50",
                     50, abra.contadorDamage)
        assertEquals("Treecko no tiene daño aun, su contador de daño se mantiene en 0", 0, treecko.contadorDamage)
        abra.iniciarAtaque(treecko)
        assertEquals("Treecko no es resistente ni debil a ataques de tipo psiquico, aumenta en 50 el contador de daño",
                     50, treecko.contadorDamage)
        treecko.seleccionarAtaqueAUsar(2)
        assertEquals("Treecko cambio su ataque al secundario, por lo que ataque seleccionado deberia ser 2", 2, treecko.ataqueSeleccionado)
        treecko.iniciarAtaque(abra)
        assertEquals("Abra no es debil ni resistente a un ataque de tipo Normal, aumenta el contador en 30, dado que es ataque secundario",
                     80, abra.contadorDamage)
        abra.seleccionarAtaqueAUsar(2)
        assertEquals("Abra selecciona su ataque secundario, por lo que el ataque seleccionado es 2 ahora", 2, abra.ataqueSeleccionado)
        abra.iniciarAtaque(treecko)
        assertEquals("Treecko no es resistente ni debil a un ataque de tipo Normal, aumenta el contador en 30, dado que es ataque secundario",
                     80, treecko.contadorDamage)
        treecko.seleccionarAtaqueAUsar(1)
        treecko.iniciarAtaque(abra)
        abra.iniciarAtaque(treecko)
        treecko.iniciarAtaque(abra)
        abra.iniciarAtaque(treecko)
        treecko.iniciarAtaque(abra)
        assertEquals("Finalmente, Abra fue el primero en tener un contador de daño superior a 200, quedando fuera de combate",
                     230, abra.contadorDamage)
        assertEquals("El contador de daño final de Treecko en esta batalla es de 170", 140, treecko.contadorDamage)
        abra.iniciarAtaque(treecko)
        assertEquals("Abra está fuera de combate y ha sido derrotado, por lo que no deberia causar daño a Treecko",
                     140, treecko.contadorDamage)
    }
}
