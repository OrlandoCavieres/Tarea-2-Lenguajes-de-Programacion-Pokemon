package Tarea2

interface Batalla {
    val jugador: Jugador
    val oponente: Entrenador?
    val salvaje: Pokemon get() = NormalPokemon("Rattata")
    var participanteActivo: Int
    val capturaPermitida: Boolean get() = true
    var turnoProgresoBatalla: Int
    var condicionFinalBatalla: String

    fun quienEmpieza() {
        this.participanteActivo = listOf(1, 2).random()
    }

    fun cambiarParticipanteActivo() {
        when (this.participanteActivo) {
            1 -> this.participanteActivo = 2
            2 -> this.participanteActivo = 1
        }
    }

    fun confirmarJugador(jugador: Jugador): Jugador {
        return jugador.confirmarBatalla(this)
    }

    fun confirmarOponente(pkmSalvaje: Pokemon): Pokemon {
        return pkmSalvaje.confirmarBatallaPokemonSalvaje(this)
    }

    fun confirmarOponente(contrincante: Entrenador): Entrenador {
        return contrincante.confirmarBatalla(this)
    }

    fun mensajeInicioBatalla()

    fun primerTurno()

    fun turnoAtaqueJugador(jugador: Jugador)
    fun turnoAtaqueOponente(pkmSalvaje: Pokemon)
    fun turnoAtaqueOponente(entrenador: Entrenador)

    fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Pokemon)
    fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Entrenador)

    fun verificarDerrotaJugador(): Boolean {
        var cuentaVencidos = 0
        for (pkm in confirmarJugador(this.jugador).equipoPokemon.values) {
            if (pkm.fueraDeCombate()) {
                cuentaVencidos += 1
            }
        }
        return cuentaVencidos == this.jugador.totalPokemonEnEquipo
    }

    fun verificarDerrotaOponente(): Boolean

    fun capturarPokemon()

    fun porcentajeProbabilidadCaptura(): Int {
        when {
            this.salvaje.vidaRestante() == this.salvaje.vida -> return 30
            this.salvaje.vidaRestante() >= this.salvaje.vida * 0.5 -> return 60
            this.salvaje.vidaRestante() >= this.salvaje.vida * 0.3 -> return 80
            this.salvaje.vidaRestante() >= this.salvaje.vida * 0.1 -> return 95
            this.salvaje.vidaRestante() >= 1 -> return 100
            else -> return 0
        }
    }

    fun addPokemonCapturado()

    fun deseaPonerApodo(decision: Boolean, nuevoApodo: String)

    fun escaparBatalla(jugador: Jugador)

    fun probabilidadEscape()

    fun mensajeDerrotaOponente()

    fun resultadoDerrotaPkmOponente()

    fun resultadoVictoriaJugador()

    fun darExperienciaPKM(pokemon: Pokemon)

    fun finBatalla(opcion: String) {
        when (opcion) {
            "Escape" -> this.probabilidadEscape()
            "JugadorDerrotado" -> {println("Has perdido la batalla. Serás transportado al centro pokemon más cercano.")
                                   this.condicionFinalBatalla = "JugadorDerrotado"}
            "OponenteDerrotado" -> {this.mensajeDerrotaOponente()
                                    this.resultadoVictoriaJugador()
                                    this.condicionFinalBatalla = "OponenteDerrotado"}
            "Captura" -> {println("El pokemon ha sido capturado con exito")
                          this.condicionFinalBatalla = "Captura"}
        }
    }
}