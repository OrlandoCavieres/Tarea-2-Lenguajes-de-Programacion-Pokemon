package Tarea2

/**
 * Interface que representa a un entrenador pokemon con todas sus caracteristicas y manejo o creación de su equipo
 * pokemon.
 * @constructor Incializa un nuevo entrenador.
 * @property nombre Nombre del entrenador.
 * @property genero Genero del entrenador. Puede ser masculino o femenino.
 * @property nivelAproximado Número que representa el nivel aproximado del equipo pokemon del entrenador.
 * @property equipoPokemon Diccionario que contiene en su interior al equipo pokemon del entrenador, con su identificador
 * numérico.
 * @property ordenEquipoPokemon Lista que representa el orden de prioridad de los pokemon en el equipo pokemon del
 * entrenador.
 * @property totalPokemonEnEquipo Número de pokemon en el equipo del entrenador.
 * @property tipoClaseEntrenador Nombre de la clase a la que pertenece el entrenador.
 * @property preferenciaTipoPokemon Lista de preferencias de tipo pokemon que tiene el entrenador.
 * @property sizeMinimoEquipoPokemon Número mínimo de pokemon aproximado que debe tener el entrenador en su equipo.
 * @property mensajeInicial Mensaje que dice el entrenador al iniciar una batalla.
 * @property mensajeDerrota Mensaje que dice el entrenador cuando pierde una batalla.
 * @property dineroRecompensa Cantidad de dinero que tiene el entrenador para entregar cuando pierde.
 */
interface Entrenador {
    val nombre: String
    var genero: String
    var nivelAproximado: Int
    val equipoPokemon: MutableMap<Int, Pokemon> get() = mutableMapOf<Int, Pokemon>()
    val ordenEquipoPokemon: MutableList<Int> get() = mutableListOf()
    val totalPokemonEnEquipo: Int get() = this.equipoPokemon.size
    val tipoClaseEntrenador: String get() = "JUGADOR"
    val preferenciaTipoPokemon: List<String> get() = listOf("Normal")
    val sizeMinimoEquipoPokemon: Int get() = 1
    val mensajeInicial: String get() = "JUGADOR"
    val mensajeDerrota: String get() = "JUGADOR"
    val dineroRecompensa: Int get() = 0

    /**
     * Método para recuperar al pokemon que se encuentra en una posición dada dentro del equipo del entrenador
     * correspondiente.
     * @param posicion Numero que representa la posición del pokemon.
     * @return Entrega al pokemon en la posición dada.
     */
    fun recuperarPokemonEnLaPosicionEquipo(posicion: Int): Pokemon? {
        val nombrePKM = this.ordenEquipoPokemon[posicion]
        return if (this.equipoPokemon[nombrePKM] != null) {
            this.equipoPokemon[nombrePKM]
        }
        else {null}
    }

    /**
     * Método que recupera al pokemon que se encuentra en la primera posición del equipo del entrenador
     * correspondiente.
     * @return Pokemon en primera posición.
     */
    fun recuperarPokemonEnCabecera(): Pokemon? {
        return recuperarPokemonEnLaPosicionEquipo(0)
    }

    /**
     * Método que permite buscar a un pokemon que no esté fuera de combate en el equipo y cambiarlo de posición
     * a la primera para volverlo el pokemon activo.
     */
    fun obtenerPkmNoDerrotadoACabecera() {
        for (posicion in 0..this.totalPokemonEnEquipo) {
            if (this.equipoPokemon[this.ordenEquipoPokemon[posicion]]!!.fueraDeCombate()) {
                this.cambiarOrdenPokemonEnEquipo(posicion, 0)
                break
            }
        }
    }

    /**
     * Método que permite cambiar de posición un pokemon en el equipo del entrenador, dadas dos posiciones: la actual y
     * la de destino.
     * @param posicionActual Posición en la que se encuentra el pokemon actualmente.
     * @param posicionNueva Posición a la que se desea mover el pokemon.
     */
    fun cambiarOrdenPokemonEnEquipo(posicionActual: Int, posicionNueva: Int) {
        val pkmEnPosActual = this.ordenEquipoPokemon[posicionActual]
        val pkmEnPosNueva = this.ordenEquipoPokemon[posicionNueva]
        this.ordenEquipoPokemon[posicionActual] = pkmEnPosNueva
        this.ordenEquipoPokemon[posicionNueva] = pkmEnPosActual
    }

    /**
     * Método que permite a un entrenador confirmar entrar en la batalla.
     * @param batallaPKM Batalla en la que participará el entrenador.
     * @return Entrega al entrenador correspondiente.
     */
    fun confirmarBatalla(batallaPKM: Batalla): Entrenador

    fun generarEquipoPokemon() {
        for (elemento in 0..this.sizeMinimoEquipoPokemon) {
            val tipoNuevoPKM = this.preferenciaTipoPokemon.random()
            val nuevoPKM = this.crearPokemon(tipoNuevoPKM)
            val nivelPKM = ((this.nivelAproximado - 3)..(this.nivelAproximado + 2)).random()
            while (nuevoPKM!!.nivel < nivelPKM) {
                nuevoPKM.experienciaAcumuladaEnNivel += nuevoPKM.experienciaRequeridaSubirNivel()
                nuevoPKM.subirNivel()
            }
            this.equipoPokemon[elemento] = nuevoPKM
            this.ordenEquipoPokemon.add(elemento)
        }
    }

    /**
     * Método que permite crear un pokemon de un tipo permitido en forma aleatoria.
     * @param tipoPKM String que representa el tipo de pokemon a crear.
     * @return Regresa el pokemon creado o null si no es posible crearlo.
     */
    fun crearPokemon(tipoPKM: String): Pokemon? {
        val nombrePKMNormal = listOf("Rattata", "Meowth", "Chansey", "Tauros", "Ditto",
                                     "Eevee", "Snorlax", "Dunsparce", "Pidgey", "Jigglypuff")
        val nombrePKMFuego = listOf("Charmander", "Growlithe", "Vulpix", "Cyndaquil", "Ponyta",
                                    "Magmar", "Slugma", "Flareon", "Torchic", "Torkoal")
        val nombrePKMAgua = listOf("Squirtle", "Psyduck", "Poliwag", "Seel", "Krabby",
                                   "Horsea", "Magikarp", "Staryu", "Goldeen", "Mudkip")
        val nombrePKMElectrico = listOf("Pikachu", "Voltorb", "Electabuzz", "Mareep", "Electrike",
                                        "Magnemite", "Blitzle", "Shinx", "Minun", "Jolteon")
        val nombrePKMPsiquico = listOf("Abra", "Slowpoke", "Hypno", "Espeon", "Unown",
                                       "Mr Mime", "Natu", "Ralts", "Jynx", "Lunatone")
        val nombrePKMTierra = listOf("Sandslash", "Diglett", "Cubone", "Phanpy", "Trapinch",
                                     "Rhyhorn", "Gligar", "Baltoy", "Geodude", "Onyx")
        val nombrePKMLucha = listOf("Mankey", "Machop", "Hitmonlee", "Hitmonchan", "Tyrogue",
                                    "Hitmontop", "Makuhita", "Riolu", "Meditate", "Lucario")
        val nombrePKMHierba = listOf("Tangela", "Chikorita", "Bellosom", "Oddish", "Bellsprout",
                                     "Exeggcute", "Tropius", "Snivy", "Treecko", "Turtwig")
        return when (tipoPKM) {
            "Normal" -> NormalPokemon(nombre = nombrePKMNormal.random())
            "Fuego" -> FirePokemon(nombre = nombrePKMFuego.random())
            "Agua" -> FirePokemon(nombre = nombrePKMAgua.random())
            "Electrico" -> FirePokemon(nombre = nombrePKMElectrico.random())
            "Psiquico" -> FirePokemon(nombre = nombrePKMPsiquico.random())
            "Tierra" -> FirePokemon(nombre = nombrePKMTierra.random())
            "Lucha" -> FirePokemon(nombre = nombrePKMLucha.random())
            "Hierba" -> FirePokemon(nombre = nombrePKMHierba.random())
            else -> null
        }
    }
}