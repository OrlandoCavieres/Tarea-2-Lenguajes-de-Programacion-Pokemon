package tarea2

/**
 * Clase que representa al jugador.
 * @constructor Inicializa una instancia de tipo jugador.
 * @property pokemonPCALGUIEN Diccionario que contiene en su interior todos los pokemon capturados que ya no tienen cupo
 * en el equipo Pokemon.
 * @property dinero Dinero que tiene el jugador disponible.
 * @property totalPokemonCapturados Número que representa el total de capturas que ha realizado el jugador.
 */
open class Jugador(override val nombre: String): Entrenador {
    override val equipoPokemon: MutableMap<Int, Pokemon> = mutableMapOf()
    override val ordenEquipoPokemon: MutableList<Int> = mutableListOf()
    private var pokemonPCALGUIEN: MutableMap<Int, Pokemon> = mutableMapOf()
    private var dinero = 3000
    private var totalPokemonCapturados = 0
    override var genero = "Masculino"
    override var nivelAproximado = this.calcularNivelAproximadoEquipo()

    /**
     * Método que permite al jugador elegir el pokemon inicial del juego.
     * @param tipo Tipo del pokemon inicial que se desea.
     */
    protected fun elegirPrimerPokemon(tipo: String) {
        when {
            this.equipoPokemon.isEmpty() -> this.pokemonInicial(tipo)
            else -> println("Ya se ha elegido el primer Pokemon")
        }
    }

    /**
     * Método que permite crear al pokemon inicial del tipo deseado, con su nombre y atributos a nivel 5.
     * @param tipo Tipo del pokemon inicial que se desea.
     */
    private fun pokemonInicial(tipo: String) {
        this.totalPokemonCapturados += 1
        when (tipo) {
            "Hierba" ->
                this.equipoPokemon[1] = GrassPokemon(nombre = "Bulbasaur", vida = 45, ataquePrimario = 65, ataqueSecundario = 49)
            "Fuego" ->
                this.equipoPokemon[1] = FirePokemon(nombre = "Charmander", vida = 39, ataquePrimario = 60, ataqueSecundario = 52)
            "Agua" ->
                this.equipoPokemon[1] = WaterPokemon(nombre = "Squirtle", vida = 44, ataquePrimario = 50, ataqueSecundario = 48)
        }
        while (this.equipoPokemon[1]!!.nivel < 5) {
            this.equipoPokemon[1]!!.experienciaAcumuladaEnNivel += this.equipoPokemon[1]!!.experienciaRequeridaSubirNivel()
            this.equipoPokemon[1]!!.subirNivel()
        }
    }

    /**
     * Método que permite verificar si se ha alcanzado o no el tamaño máximo del equipo pokemon.
     * @return True si aún existe espacio disponible en el equipo.
     */
    private fun verificarCupoDisponibleEquipoPKM(): Boolean {
        return this.equipoPokemon.size < 6
    }

    /**
     * Método que permite mostrar el total de pokemon capturados actualmente.
     * @return [totalPokemonCapturados]
     */
    fun mostrarTotalPokemonCapturados(): Int {
        return this.totalPokemonCapturados
    }

    /**
     * Método que permite obtener el dinero que tiene el jugador.
     * @return [dinero]
     */
    fun dineroDisponible(): Int {
        return this.dinero
    }

    /**
     * Método que permite al jugador sumar dinero al que tiene.
     * @param dineroGanado Dinero a sumar.
     */
    fun sumarDinero(dineroGanado: Int) {
        this.dinero += dineroGanado
    }

    /**
     * Método que permite al jugador elegir su género.
     * @param genero Genero que desea el jugador.
     */
    fun elegirGenero(genero: String) {
        this.genero = genero
    }

    /**
     * Método que permite calcular el nivel aproximado del equipo pokemon del jugador.
     * @return Número que representa el nivel aproximado del equipo.
     */
    private fun calcularNivelAproximadoEquipo(): Int {
        var sumaTotal = 0
        for (pokemon in this.equipoPokemon.values) {
            sumaTotal += pokemon.nivel
        }
        return (sumaTotal / this.totalPokemonEnEquipo)
    }

    /**
     * Método que permite añadir un pokemon capturado al equipo pokemon o a PC ALGUIEN del jugador según corresponda.
     * @param pokemon Pokemon capturado a añadir.
     */
    fun addPokemon(pokemon: Pokemon) {
        this.totalPokemonCapturados += 1
        when (this.verificarCupoDisponibleEquipoPKM()) {
            true -> {this.equipoPokemon[this.totalPokemonCapturados] = pokemon
                     this.ordenEquipoPokemon.add(this.totalPokemonCapturados)}
            false -> this.pokemonPCALGUIEN[this.totalPokemonCapturados] = pokemon
        }
    }

    /**
     * Método que confirma la participación del jugador en una batalla pokemon.
     * @param batallaPKM Batalla en la que participa el jugador.
     * @return Regresa al jugador.
     */
    override fun confirmarBatalla(batallaPKM: Batalla): Jugador {
        return this
    }

    /**
     * Método que permite intentar escapar de una batalla pokemon al jugador.
     * @param batallaPKM Batalla en la que participa el jugador.
     */
    fun escaparBatalla(batallaPKM: Batalla) {
        batallaPKM.finBatalla("Escape")
    }
}