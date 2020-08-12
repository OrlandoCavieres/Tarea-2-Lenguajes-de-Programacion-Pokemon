package Tarea2

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

    fun recuperarPokemonEnLaPosicionEquipo(posicion: Int): Pokemon? {
        val nombrePKM = this.ordenEquipoPokemon[posicion]
        return if (this.equipoPokemon[nombrePKM] != null) {
            this.equipoPokemon[nombrePKM]
        }
        else {null}
    }

    fun recuperarPokemonEnCabecera(): Pokemon? {
        return recuperarPokemonEnLaPosicionEquipo(0)
    }

    fun obtenerPkmNoDerrotadoACabecera() {
        for (posicion in 0..this.totalPokemonEnEquipo) {
            if (this.equipoPokemon[this.ordenEquipoPokemon[posicion]]!!.fueraDeCombate()) {
                this.cambiarOrdenPokemonEnEquipo(posicion, 0)
                break
            }
        }
    }

    fun cambiarOrdenPokemonEnEquipo(posicionActual: Int, posicionNueva: Int) {
        val pkmEnPosActual = this.ordenEquipoPokemon[posicionActual]
        val pkmEnPosNueva = this.ordenEquipoPokemon[posicionNueva]
        this.ordenEquipoPokemon[posicionActual] = pkmEnPosNueva
        this.ordenEquipoPokemon[posicionNueva] = pkmEnPosActual
    }

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
        when (tipoPKM) {
            "Normal" -> return NormalPokemon(nombre = nombrePKMNormal.random())
            "Fuego" -> return FirePokemon(nombre = nombrePKMFuego.random())
            "Agua" -> return FirePokemon(nombre = nombrePKMAgua.random())
            "Electrico" -> return FirePokemon(nombre = nombrePKMElectrico.random())
            "Psiquico" -> return FirePokemon(nombre = nombrePKMPsiquico.random())
            "Tierra" -> return FirePokemon(nombre = nombrePKMTierra.random())
            "Lucha" -> return FirePokemon(nombre = nombrePKMLucha.random())
            "Hierba" -> return FirePokemon(nombre = nombrePKMHierba.random())
            else -> return null
        }
    }
}