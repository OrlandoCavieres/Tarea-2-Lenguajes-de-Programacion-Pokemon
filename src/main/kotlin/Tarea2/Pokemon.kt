package Tarea2

interface Pokemon {
    val nombre: String
    val vida: Int get() = 200
    val tipo: String
    var contadorDamage: Int
    val ataquePrimario: Int get() = 50
    val ataqueSecundario: Int get() = 30
    var ataqueSeleccionado: Int

    fun iniciarAtaque(pokemon: Pokemon) {
        pokemon.observarOponente(this)
    }

    fun observarOponente(pokemon: Pokemon) {
        pokemon.atacar(this)
    }

    fun atacar(oponente: Pokemon) {
        if (fueraDeCombate()) {
            println("No puedo atacar")
        }
        else {
            this.realizarAtaque(oponente, this.ataqueSeleccionado)
        }
    }

    fun seleccionarAtaqueAUsar(decision: Int) {
        this.ataqueSeleccionado = decision
    }

    fun realizarAtaque(oponente: Pokemon, ataque: Int)

    fun recibeNormalDamage(oponente: Pokemon) {
        when (oponente.ataqueSeleccionado) {
            1 -> this.contadorDamage += oponente.ataquePrimario
            2 -> this.contadorDamage += oponente.ataqueSecundario
        }
    }

    fun recibeFireDamage(oponente: FirePokemon) {this.recibeNormalDamage(oponente)}
    fun recibeWaterDamage(oponente: WaterPokemon) {this.recibeNormalDamage(oponente)}
    fun recibeElectricDamage(oponente: ElectricPokemon) {this.recibeNormalDamage(oponente)}
    fun recibePsychicDamage(oponente: PsychicPokemon) {this.recibeNormalDamage(oponente)}
    fun recibeGroundDamage(oponente: GroundPokemon) {this.recibeNormalDamage(oponente)}
    fun recibeFightDamage(oponente: FightPokemon) {this.recibeNormalDamage(oponente)}
    fun recibeGrassDamage(oponente: GrassPokemon) {this.recibeNormalDamage(oponente)}

    fun fueraDeCombate(): Boolean {
        return this.contadorDamage >= this.vida
    }

    fun modDamageAtaquePrimario(pokemon: Pokemon, modificador: Int) {
        when (pokemon.ataqueSeleccionado) {
            1 -> this.contadorDamage += pokemon.ataquePrimario + modificador
        }
    }
}
