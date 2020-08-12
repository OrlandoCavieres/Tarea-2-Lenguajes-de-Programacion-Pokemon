package Tarea2
import kotlin.math.round

class BatallaContraPokemonSalvaje(override val jugador: Jugador, override val salvaje: Pokemon): Batalla {
    override val oponente: Entrenador? = null
    override var participanteActivo = 1
    override var turnoProgresoBatalla = 0
    override var condicionFinalBatalla = ""

    override fun mensajeInicioBatalla(): String {
        return "¡Ha aparecido un ${salvaje.nombre} salvaje y te ha cortado el paso!"
    }

    override fun primerTurno() {
        println(this.mensajeInicioBatalla())
        this.quienEmpieza()
        this.desarrolloTurnoAtaque(this.confirmarJugador(this.jugador), this.confirmarOponente(this.salvaje))
    }

    override fun escaparBatalla(jugador: Jugador) {
        jugador.escaparBatalla(this)
    }

    override fun turnoAtaqueJugador(jugador: Jugador) {
        val pkmActivo = jugador.recuperarPokemonEnCabecera()
        when (this.verificarDerrotaOponente()) {
            true -> this.finBatalla("OponenteDerrotado")
            false -> {pkmActivo!!.iniciarAtaque(this.salvaje)
                      this.cambiarParticipanteActivo()}
        }
    }

    override fun turnoAtaqueOponente(entrenador: Entrenador) {}
    override fun turnoAtaqueOponente(pkmSalvaje: Pokemon) {
        val pkmActivo = this.jugador.recuperarPokemonEnCabecera()
        when {
            this.verificarDerrotaJugador() -> this.finBatalla("JugadorDerrotado")
            pkmActivo!!.fueraDeCombate() -> {println("${pkmActivo.nombre} ha sido derrotado. Elija otro pokemon.")
                                             this.jugador.obtenerPkmNoDerrotadoACabecera()
                                             pkmSalvaje.iniciarAtaque(this.jugador.recuperarPokemonEnCabecera())
                                             this.cambiarParticipanteActivo()}
            else -> {pkmSalvaje.iniciarAtaque(pkmActivo)
                     this.cambiarParticipanteActivo()}
        }
    }

    override fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Entrenador) {}

    override fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Pokemon) {
        when (this.participanteActivo) {
            1 -> turnoAtaqueJugador(this.confirmarJugador(this.jugador))
            2 -> turnoAtaqueOponente(this.confirmarOponente(this.salvaje))
        }
        this.turnoProgresoBatalla += 1
    }

    override fun capturarPokemon() {
        val numAzar = (0..100).toList().random()
        when (numAzar) {
            0 -> println("No se puede capturar un pokemon debilitado.")
            in 1..porcentajeProbabilidadCaptura() -> this.finBatalla("Captura")
            else -> {println("¡Oh, mala suerte, ${this.salvaje.nombre} no ha sido capturado!")
                     this.turnoProgresoBatalla += 1
                     this.cambiarParticipanteActivo()}
        }
    }

    override fun deseaPonerApodo(decision: Boolean, nuevoApodo: String) {
        when (decision) {
            true -> this.salvaje.ponerApodo(nuevoApodo)
            false -> this.salvaje.ponerApodo(this.salvaje.nombre)
        }
    }

    override fun addPokemonCapturado() {
        if (this.condicionFinalBatalla == "Captura") {
            this.jugador.addPokemon(this.salvaje)
        }
        else {println("No se puede capturar al pokemon")}
    }

    override fun probabilidadEscape() {
        val eleccionRandom = listOf(1, 2, 3, 4, 5).random()
        when (eleccionRandom) {
            3 -> {println("No has logrado escapar")
                  this.turnoProgresoBatalla += 1
                  this.cambiarParticipanteActivo()}
            1, 2, 4, 5 -> {println("Has escapado sin problemas")
                           this.condicionFinalBatalla = "Escape"}
        }
    }

    override fun mensajeDerrotaOponente(): String {
        return "¡El ${this.salvaje.nombre} salvaje se ha debilitado!"
    }

    override fun darExperienciaPKM(pokemon: Pokemon) {
        val experienciaGanada = (this.salvaje.nivel * (this.salvaje.nivel elevado 3) * 1) / 7
        pokemon.experienciaAcumuladaEnNivel += experienciaGanada
        println("${pokemon.nombre} ha ganado ${experienciaGanada} puntos de experiencia.")
        pokemon.subirNivel()
    }

    override fun resultadoDerrotaPkmOponente() {
        val pkmActivo = this.jugador.recuperarPokemonEnCabecera()
        this.darExperienciaPKM(pkmActivo!!)
    }

    override fun resultadoVictoriaJugador() {
        this.resultadoDerrotaPkmOponente()
    }

    override fun verificarDerrotaOponente(): Boolean {
        return this.salvaje.fueraDeCombate()
    }
}

class BatallaContraOtroEntrenador(override val jugador: Jugador, override val oponente: Entrenador): Batalla {
    override var participanteActivo = 1
    override var turnoProgresoBatalla = 0
    override var condicionFinalBatalla = ""
    override val capturaPermitida = false

    override fun mensajeInicioBatalla(): String {
        return this.oponente.mensajeInicial
    }

    override fun primerTurno() {
        this.mensajeInicioBatalla()
        this.quienEmpieza()
        this.desarrolloTurnoAtaque(this.confirmarJugador(this.jugador), this.confirmarOponente(this.oponente))
    }

    override fun turnoAtaqueOponente(entrenador: Entrenador) {}
    override fun turnoAtaqueJugador(jugador: Jugador) {}

    override fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Entrenador) {
        when (this.participanteActivo) {
            1 -> turnoAtaqueJugador(this.confirmarJugador(this.jugador))
            2 -> turnoAtaqueOponente(this.confirmarOponente(this.oponente))
        }
        this.turnoProgresoBatalla += 1
    }

    override fun verificarDerrotaOponente(): Boolean {
        var cuentaVencidos = 0
        for (pkm in confirmarOponente(this.oponente).equipoPokemon.values) {
            if (pkm.fueraDeCombate()) {
                cuentaVencidos += 1
            }
        }
        return cuentaVencidos == this.oponente.totalPokemonEnEquipo
    }

    override fun mensajeDerrotaOponente(): String {
        return this.oponente.mensajeDerrota
    }

    override fun resultadoDerrotaPkmOponente() {}

    // sumar dinero
    override fun resultadoVictoriaJugador() {}

    override fun darExperienciaPKM(pokemon: Pokemon) {
        val experienciaGanada = ((this.oponente.recuperarPokemonEnCabecera()!!.nivel *
                                 (this.oponente.recuperarPokemonEnCabecera()!!.nivel elevado 3) * 1.5) / 7).toInt()
        pokemon.experienciaAcumuladaEnNivel += experienciaGanada
        println("${pokemon.nombre} ha ganado ${experienciaGanada} puntos de experiencia.")
        pokemon.subirNivel()
    }

    // No atribuibles a batalla contra entrenador por lo que no deben hacer nada
    override fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Pokemon) {}
    override fun turnoAtaqueOponente(pkmSalvaje: Pokemon) {}
    override fun capturarPokemon() {}
    override fun addPokemonCapturado() {}
    override fun deseaPonerApodo(decision: Boolean, nuevoApodo: String) {}
    override fun escaparBatalla(jugador: Jugador) {}
    override fun probabilidadEscape() {}
}