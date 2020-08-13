package Tarea2

/**
 * Interface que representa una batalla pokemon con los posibles componentes de batalla contra pokemon salvaje u
 * otro entrenador, captura de un pokemon salvaje, escape de batalla de una batalla y los posibles resultados de
 * la misma.
 * @constructor Inicializa una batalla entre el jugador y un contrincante.
 * @property jugador Participante que corresponde al Jugador
 * @property oponente Participante que corresponde a un entrenador contrincante.
 * @property salvaje Participante que corresponde a un pokemon salvaje.
 * @property participanteActivo Número que corresponde al participante que le toca en el turno actual.
 * @property capturaPermitida Booleano que permite decidir si en la batalla se encuentra permitido capturar a un pokemon.
 * @property turnoProgresoBatalla Número que permite conocer el turno actual de la batalla.
 * @property condicionFinalBatalla String que representa la condición en que la batalla terminó.
 */
interface Batalla {
    val jugador: Jugador
    val oponente: Entrenador?
    val salvaje: Pokemon get() = NormalPokemon("Rattata")
    var participanteActivo: Int
    val capturaPermitida: Boolean get() = true
    var turnoProgresoBatalla: Int
    var condicionFinalBatalla: String

    /**
     * Método que determina de forma random que participante iniciará la batalla.
     */
    fun quienEmpieza() {
        this.participanteActivo = listOf(1, 2).random()
    }

    /**
     * Método cambia el participante activo actual. Intercambia entre 1 y 2 siempre.
     */
    fun cambiarParticipanteActivo() {
        when (this.participanteActivo) {
            1 -> this.participanteActivo = 2
            2 -> this.participanteActivo = 1
        }
    }

    /**
     * Método que le solicita al jugador sus datos para la batalla.
     * @param jugador Jugador participante en la batalla
     * @return Retorna al jugador después de que éste entregue sus datos.
     */
    fun confirmarJugador(jugador: Jugador): Jugador {
        return jugador.confirmarBatalla(this)
    }

    /**
     * Método que le solicita al pokemon salvaje sus datos para la batalla.
     * @param pkmSalvaje Pokemon salvaje participante en la batalla
     * @return Retorna al pokemon salvaje después de que éste entregue sus datos.
     */
    fun confirmarOponente(pkmSalvaje: Pokemon): Pokemon {
        return pkmSalvaje.confirmarBatallaPokemonSalvaje(this)
    }

    /**
     * Método que le solicita al entrenador contrincante sus datos para la batalla.
     * @param contrincante Entrenador contrincante participante en la batalla
     * @return Retorna al entrenador contrincante después de que este entregue sus datos.
     */
    fun confirmarOponente(contrincante: Entrenador): Entrenador {
        return contrincante.confirmarBatalla(this)
    }

    /**
     * Método que muestra el mensaje inicial de la batalla.
     * @return Mensaje inicial como string.
     */
    fun mensajeInicioBatalla(): String

    /**
     * Método que determina como se desarrollará el primer turno de la batalla pokemon.
     */
    fun primerTurno()

    /**
     * Método que lleva a cabo el turno del jugador. En el transcurso del mismo, decide si ha vencido a uno o a todos
     * los pokemon del contricante, determinado la derrota de este último si es necesario. Solicita cambiar de
     * pokemon al contrincante, si se vence al pokemon activo de éste. Otorga experiencia al pokemon activo del jugador
     * si en el trancurso del turno vence a un pokemon del oponente.
     * @param jugador Corresponde al jugador.
     */
    fun turnoAtaqueJugador(jugador: Jugador)

    /**
     * Método que lleva a cabo el turno del pokemon salvaje oponente. En el transcurso del mismo, decide si ha vencido
     * a uno o a todos los pokemon del jugador, determinado la derrota de este último si es necesario. Solicita cambiar de
     * pokemon al jugador si se vence al pokemon activo de éste.
     * @param pkmSalvaje Corresponde al pokemon salvaje contrincante de la batalla.
     */
    fun turnoAtaqueOponente(pkmSalvaje: Pokemon)

    /**
     * Método que lleva a cabo el turno del entrenador oponente. En el transcurso del mismo, decide si ha vencido a uno
     * o a todos los pokemon del jugador, determinado la derrota de este último si es necesario. Solicita cambiar de
     * pokemon al jugador si se vence al pokemon activo de éste.
     * @param entrenador Corresponde al entrenador contrincante de la batalla.
     */
    fun turnoAtaqueOponente(entrenador: Entrenador)

    /**
     * Método que desarrolla el turno con la opción atacar, considerando al participante activo en ese momento para
     * establecer si es turno del jugador o del pokemon salvaje.
     * @param jugador Corresponde al jugador.
     * @param oponente Corresponde al pokemon salvaje.
     */
    fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Pokemon)

    /**
     * Método que desarrolla el turno con la opción atacar, considerando al participante activo en ese momento para
     * establecer si es turno del jugador o del entrenador oponente.
     * @param jugador Corresponde al jugador.
     * @param oponente Corresponde al entrenador contrincante.
     */
    fun desarrolloTurnoAtaque(jugador: Jugador, oponente: Entrenador)

    /**
     * Método que verifica si el jugador fue derrotado, al revisar que todos los pokemon en el equipo estén fuera de
     * combate.
     * @return True si todos los pokemon del jugador en equipo están fuera de combate.
     */
    fun verificarDerrotaJugador(): Boolean {
        var cuentaVencidos = 0
        for (pkm in confirmarJugador(this.jugador).equipoPokemon.values) {
            if (pkm.fueraDeCombate()) {
                cuentaVencidos += 1
            }
        }
        return cuentaVencidos == this.jugador.totalPokemonEnEquipo
    }

    /**
     * Método que verifica si el oponente fue derrotado, al revisar que todos los pokemon participantes estén fuera de
     * combate.
     * @return True si todos los pokemon oponentes están fuera de combate.
     */
    fun verificarDerrotaOponente(): Boolean

    /**
     * Método que implementa la captura de un pokemon, en base a un porcentaje de exito de captura y un controlador
     * random. Si hay éxito, entonces actualiza la condición de la batalla. Caso contrario, no se logra la captura y
     * el jugador pierde su turno.
     */
    fun capturarPokemon()

    /**
     * Método que entrega el porcentaje de posibilidad de captura de un pokemon en base a su vida restante.
     * @return Porcentaje de éxito de captura del pokemon.
     */
    fun porcentajeProbabilidadCaptura(): Int {
        return when {
            this.salvaje.vidaRestante() == this.salvaje.vida -> 30
            this.salvaje.vidaRestante() >= this.salvaje.vida * 0.5 -> 60
            this.salvaje.vidaRestante() >= this.salvaje.vida * 0.3 -> 80
            this.salvaje.vidaRestante() >= this.salvaje.vida * 0.1 -> 95
            this.salvaje.vidaRestante() >= 1 -> 100
            else -> 0
        }
    }

    /**
     * Método que permite añadir un pokemon capturado al equipo pokemon del jugador
     */
    fun addPokemonCapturado()

    /**
     * Método que permite ponerle un apodo a un pokemon capturado por el jugador.
     * @param decision True si desea ponerle un apodo, false caso contrario.
     * @param nuevoApodo Apodo que se desea colocar al pokemon.
     */
    fun deseaPonerApodo(decision: Boolean, nuevoApodo: String)

    /**
     * Método que permite al jugador en la batalla, escapar de la misma, empleando el método [probabilidadEscape], para
     * ver si realmente puede escapar o no. Si lo logra genera una condición de salida de batalla, caso contrario el
     * jugador pierde su turno.
     * @param jugador Corresponde al jugador que desea escapar.
     */
    fun escaparBatalla(jugador: Jugador)

    /**
     * Método que calcula en terminos de intervalos la probabilidad de que el jugador escape de una batalla pokemon.
     */
    fun probabilidadEscape()

    /**
     * Método que entrega el mensaje de derrota del oponente actual.
     * @return String del mensaje de derrota
     */
    fun mensajeDerrotaOponente(): String

    /**
     * Método que establece las ganancias para el jugador.
     */
    fun resultadoVictoriaJugador()

    /**
     * Método que le otorga la experiencia ganada por derrotar a un pokemon rival al pokemon que lo venció.
     * @param pokemon Pokemon que vence y que recibe experiencia.
     */
    fun darExperienciaPKM(pokemon: Pokemon) {}

    /**
     * Método que establece los resultados finales de la batalla, para una condición de salida de la misma
     * correspondiente.
     * @param opcion String que representa la claúsula de salida de la batalla.
     */
    fun finBatalla(opcion: String) {
        when (opcion) {
            "Escape" -> this.probabilidadEscape()
            "JugadorDerrotado" -> {println("Has perdido la batalla. Serás transportado al centro pokemon más cercano.")
                                   this.condicionFinalBatalla = "JugadorDerrotado"}
            "OponenteDerrotado" -> {this.resultadoVictoriaJugador()
                                    this.condicionFinalBatalla = "OponenteDerrotado"}
            "Captura" -> {println("El pokemon ha sido capturado con exito")
                          this.condicionFinalBatalla = "Captura"}
        }
    }
}