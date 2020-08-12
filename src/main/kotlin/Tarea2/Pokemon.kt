package Tarea2
import kotlin.math.pow

infix fun Int.elevado(exponente: Int): Int = toDouble().pow(exponente).toInt()

interface Pokemon {
    val nombre: String
    var apodo: String
    var vida: Int
    val tipo: String get() = "Normal"
    var contadorDamage: Int
    var ataquePrimario: Int
    var ataqueSecundario: Int
    var ataqueSeleccionado: Int
    var nivel: Int
    var experienciaAcumuladaEnNivel: Int

    fun ponerApodo(nuevoApodo: String) {
        this.apodo = nuevoApodo
    }

    fun iniciarAtaque(pokemon: Pokemon?): Pokemon? {
        if (pokemon != null) {
            pokemon.observarOponenteYEntregarDatos(this)
            return pokemon
        }
        else {
            return null
        }
    }

    fun observarOponenteYEntregarDatos(pokemon: Pokemon) {
        pokemon.atacar(this)
    }

    fun atacar(oponente: Pokemon) {
        when {
            this.fueraDeCombate() -> println("${this.nombre}: No puedo atacar, fui derrotado")
            oponente.fueraDeCombate() -> println("${this.nombre}: Enemigo ya fue derrotado")
            else -> this.realizarAtaque(oponente, this.ataqueSeleccionado)
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

    fun vidaRestante(): Int {
        return when {
            this.contadorDamage >= this.vida -> 0
            else -> this.vida - this.contadorDamage
        }
    }

    fun restaurarPkmAlMaximo() {
        this.contadorDamage = 0
    }

    fun modDamageAtaquePrimario(pokemon: Pokemon, modificador: Int) {
        when (pokemon.ataqueSeleccionado) {
            1 -> this.contadorDamage += pokemon.ataquePrimario + modificador
        }
    }

    fun experienciaRequeridaSubirNivel(): Int {
        return ((this.nivel + 1) elevado 3) - (this.nivel elevado 3)
    }

    fun verificarRequisitoExpSubirNivel(): Boolean {
        return this.experienciaAcumuladaEnNivel >= this.experienciaRequeridaSubirNivel()
    }

    fun subirNivel() {
        when {
            verificarRequisitoExpSubirNivel() && this.nivel < 100 && this.nivel >= 1 -> {
                this.experienciaAcumuladaEnNivel = this.experienciaAcumuladaEnNivel - this.experienciaRequeridaSubirNivel()
                this.nivel += 1
                println("¡${this.nombre} ha subido a nivel ${this.nivel}!")
                val listaAumentoParametros = listOf(1, 2, 3)
                this.vida += listaAumentoParametros.random()
                this.ataquePrimario += listaAumentoParametros.random()
                this.ataqueSecundario += listaAumentoParametros.random()
            }
            !verificarRequisitoExpSubirNivel() -> {}
            else -> this.experienciaAcumuladaEnNivel = 0
        }
    }

    fun confirmarBatallaPokemonSalvaje(batallaPKM: Batalla): Pokemon {
        return this
    }

    fun recibeExperiencia(batallaPKM: Batalla) {
        batallaPKM.darExperienciaPKM(this)
    }
}
