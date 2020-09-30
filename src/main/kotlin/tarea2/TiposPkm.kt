package tarea2

/**
 * Clase para pokemon de tipo Normal.
 * @constructor Inicializa una instancia de clase para pokemon tipo Normal.
 */
class NormalPokemon(override val nombre: String,
                    override var vida: Int = 40,
                    override var ataquePrimario: Int = 50,
                    override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when (ataque) {
            1, 2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeFightDamage(oponente: FightPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }

    override fun recibePsychicDamage(oponente: PsychicPokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }
}

/**
 * Clase para pokemon de tipo Fuego.
 * @constructor Inicializa una instancia de clase para pokemon tipo Fuego.
 */
class FirePokemon(override val nombre: String,
                  override var vida: Int = 40,
                  override var ataquePrimario: Int = 50,
                  override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override val tipo = "Fuego"
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeFireDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeWaterDamage(oponente: WaterPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }

    override fun recibeGroundDamage(oponente: GroundPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }

    override fun recibeGrassDamage(oponente: GrassPokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }
}

/**
 * Clase para pokemon de tipo Agua.
 * @constructor Inicializa una instancia de clase para pokemon tipo Agua.
 */
class WaterPokemon(override val nombre: String,
                   override var vida: Int = 40,
                   override var ataquePrimario: Int = 50,
                   override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override val tipo = "Agua"
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeWaterDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeFireDamage(oponente: FirePokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }

    override fun recibeElectricDamage(oponente: ElectricPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }

    override fun recibeGrassDamage(oponente: GrassPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }
}

/**
 * Clase para pokemon de tipo Eléctrico.
 * @constructor Inicializa una instancia de clase para pokemon tipo Eléctrico.
 */
class ElectricPokemon(override val nombre: String,
                      override var vida: Int = 40,
                      override var ataquePrimario: Int = 50,
                      override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override val tipo = "Eléctrico"
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeElectricDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeElectricDamage(oponente: ElectricPokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }

    override fun recibeGroundDamage(oponente: GroundPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }
}

/**
 * Clase para pokemon de tipo Psíquico.
 * @constructor Inicializa una instancia de clase para pokemon tipo Psíquico.
 */
class PsychicPokemon(override val nombre: String,
                     override var vida: Int = 40,
                     override var ataquePrimario: Int = 50,
                     override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override val tipo = "Psíquico"
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibePsychicDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibePsychicDamage(oponente: PsychicPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }
}

/**
 * Clase para pokemon de tipo Tierra
 * @constructor Inicializa una instancia de clase para pokemon tipo Tierra.
 */
class GroundPokemon(override val nombre: String,
                    override var vida: Int = 40,
                    override var ataquePrimario: Int = 50,
                    override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override val tipo = "Tierra"
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeGroundDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeNormalDamage(oponente: Pokemon) {
        when (oponente.ataqueSeleccionado) {
            1 -> this.contadorDamage += oponente.ataquePrimario - 20
            2 -> this.contadorDamage += oponente.ataqueSecundario - 20
        }
    }

    override fun recibeFireDamage(oponente: FirePokemon) {
        modDamageAtaquePrimario(oponente, 0)
    }

    override fun recibeWaterDamage(oponente: WaterPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }

    override fun recibeElectricDamage(oponente: ElectricPokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }

    override fun recibePsychicDamage(oponente: PsychicPokemon) {
        modDamageAtaquePrimario(oponente, 0)
    }

    override fun recibeGroundDamage(oponente: GroundPokemon) {
        modDamageAtaquePrimario(oponente, 0)
    }

    override fun recibeFightDamage(oponente: FightPokemon) {
        modDamageAtaquePrimario(oponente, 0)
    }

    override fun recibeGrassDamage(oponente: GrassPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }
}

/**
 * Clase para pokemon de tipo Lucha.
 * @constructor Inicializa una instancia de clase para pokemon tipo Lucha.
 */
class FightPokemon(override val nombre: String,
                   override var vida: Int = 40,
                   override var ataquePrimario: Int = 50,
                   override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override val tipo = "Lucha"
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeFightDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibePsychicDamage(oponente: PsychicPokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }

    override fun recibeGroundDamage(oponente: GroundPokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }
}

/**
 * Clase para pokemon de tipo Hierba
 * @constructor Inicializa una instancia de clase para pokemon tipo Hierba.
 */
class GrassPokemon(override val nombre: String,
                   override var vida: Int = 40,
                   override var ataquePrimario: Int = 50,
                   override var ataqueSecundario: Int = 30): Pokemon {

    override var contadorDamage = 0
    override val tipo = "Hierba"
    override var ataqueSeleccionado = 1
    override var nivel = 1
    override var experienciaAcumuladaEnNivel = 0
    override var apodo = nombre

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeGrassDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeFireDamage(oponente: FirePokemon) {
        modDamageAtaquePrimario(oponente, 20)
    }

    override fun recibeWaterDamage(oponente: WaterPokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }

    override fun recibeGroundDamage(oponente: GroundPokemon) {
        modDamageAtaquePrimario(oponente, -20)
    }
}