package Tarea2

class NormalPokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Normal"
    override var ataqueSeleccionado = 1

    override fun atacarContrincanteDefinido(pokemon: Pokemon): Pokemon {
        return pokemon.atacar(this)
    }

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when (ataque) {
            1, 2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeFightDamage(oponente: FightPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = 20)
    }

    override fun recibePsychicDamage(oponente: PsychicPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = -20)
    }
}

class FirePokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Fuego"
    override var ataqueSeleccionado = 1

    override fun atacarContrincanteDefinido(pokemon: Pokemon): Pokemon{
        return pokemon.atacar(this)
    }

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeFireDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeWaterDamage(oponente: WaterPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = 20)
    }

    override fun recibeGroundDamage(oponente: GroundPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = 20)
    }

    override fun recibeGrassDamage(oponente: GrassPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = -20)
    }
}

class WaterPokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Agua"
    override var ataqueSeleccionado = 1

    override fun atacarContrincanteDefinido(pokemon: Pokemon): Pokemon {
        return pokemon.atacar(this)
    }

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeWaterDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeFireDamage(oponente: FirePokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = -20)
    }

    override fun recibeElectricDamage(oponente: ElectricPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = 20)
    }

    override fun recibeGrassDamage(oponente: GrassPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = 20)
    }
}

class ElectricPokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Electrico"
    override var ataqueSeleccionado = 1

    override fun atacarContrincanteDefinido(pokemon: Pokemon): Pokemon {
        return pokemon.atacar(this)
    }

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibeElectricDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibeElectricDamage(oponente: ElectricPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = -20)
    }

    override fun recibeGroundDamage(oponente: GroundPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = 20)
    }
}

class PsychicPokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Psiquico"
    override var ataqueSeleccionado = 1

    override fun atacarContrincanteDefinido(pokemon: Pokemon): Pokemon {
        return pokemon.atacar(this)
    }

    override fun realizarAtaque(oponente: Pokemon, ataque: Int) {
        when(ataque) {
            1 -> oponente.recibePsychicDamage(this)
            2 -> oponente.recibeNormalDamage(this)
        }
    }

    override fun recibePsychicDamage(oponente: PsychicPokemon) {
        modDamageAtaquePrimario(pokemon = oponente, modificador = 20)
    }
}

class GroundPokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Tierra"
    override val debilidad = listOf("Agua", "Hierba")
    override val fortaleza = listOf("Normal", "Electrico")
}

class FightPokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Lucha"
    override val debilidad = listOf("Psiquico")
    override val fortaleza = listOf("Tierra")
}

class GrassPokemon(override val nombre: String): Pokemon {
    override var contadorDamage = 0
    override val tipo = "Hierba"
    override val debilidad = listOf("Fuego")
    override val fortaleza = listOf("Agua", "Tierra")
}