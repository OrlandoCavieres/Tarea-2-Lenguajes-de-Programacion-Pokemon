package Tarea2

class Jugador(override val nombre: String): Entrenador {
    override val equipoPokemon: MutableMap<Int, Pokemon> = mutableMapOf<Int, Pokemon>()
    override val ordenEquipoPokemon: MutableList<Int> = mutableListOf()
    protected var derrotados = mutableListOf(false, false, false, false, false, false)
    protected var pokemonPCALGUIEN: MutableMap<Int, Pokemon> = mutableMapOf<Int, Pokemon>()
    private var dinero = 3000
    private var totalPokemonCapturados = 0
    override var genero = "Masculino"
    override var nivelAproximado = this.calcularNivelAproximadoEquipo()

    protected fun elegirPrimerPokemon(tipo: String) {
        when {
            this.equipoPokemon.isEmpty() -> this.pokemonInicial(tipo)
            else -> println("Ya se ha elegido el primer Pokemon")
        }
    }

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

    protected fun verificarCupoDisponibleEquipoPKM(): Boolean {
        return this.equipoPokemon.size <= 6
    }

    fun mostrarTotalPokemonCapturados(): Int {
        return this.totalPokemonCapturados
    }

    fun dineroDisponible(): Int {
        return this.dinero
    }

    fun sumarDinero(dineroGanado: Int) {
        this.dinero += dineroGanado
    }

    fun elegirGenero(genero: String) {
        this.genero = genero
    }

    fun calcularNivelAproximadoEquipo(): Int {
        var sumaTotal = 0
        for (pokemon in this.equipoPokemon.values) {
            sumaTotal += pokemon.nivel
        }
        return (sumaTotal / this.totalPokemonEnEquipo).toInt()
    }

    fun addPokemon(pokemon: Pokemon) {
        this.totalPokemonCapturados += 1
        when (this.verificarCupoDisponibleEquipoPKM()) {
            true -> {this.equipoPokemon[this.totalPokemonCapturados] = pokemon
                     this.ordenEquipoPokemon.add(this.totalPokemonCapturados)}
            false -> this.pokemonPCALGUIEN[this.totalPokemonCapturados] = pokemon
        }
    }

    fun verificarEstadoPokemonEquipo() {
        for (posicion in 0..ordenEquipoPokemon.size) {
            val idPKM = this.ordenEquipoPokemon[posicion]
            if (this.equipoPokemon[idPKM]!!.fueraDeCombate()) {
                this.derrotados[posicion] = true
            }
            else {this.derrotados[posicion] = false}
        }
    }

    fun obtenerPkmNoDerrotadoACabecera() {
        this.verificarEstadoPokemonEquipo()
        for (posicion in 0..this.derrotados.size) {
            if (this.derrotados[posicion] == false) {
                this.cambiarOrdenPokemonEnEquipo(posicion, 0)
                break
            }
        }
    }

    protected fun cambiarOrdenPokemonEnEquipo(posicionActual: Int, posicionNueva: Int) {
        val pkmEnPosActual = this.ordenEquipoPokemon[posicionActual]
        val pkmEnPosNueva = this.ordenEquipoPokemon[posicionNueva]
        this.ordenEquipoPokemon[posicionActual] = pkmEnPosNueva
        this.ordenEquipoPokemon[posicionNueva] = pkmEnPosActual
    }

    protected fun elegirPokemonCabeceraEquipo(idPKM: Int) {
        when (this.recuperarPosicionPokemonEnEquipo(idPKM)) {
            -1 -> println("No se encuentra el pokemon en el equipo")
            0 -> println("Ya se encuentra en la primera posicion")
            1, 2, 3, 4, 5 -> this.cambiarOrdenPokemonEnEquipo(this.recuperarPosicionPokemonEnEquipo(idPKM), 0)
        }
    }

    protected fun recuperarPosicionPokemonEnEquipo(idPKM: Int): Int {
        when {
            ordenEquipoPokemon.contains(idPKM) -> return ordenEquipoPokemon.indexOf(idPKM)
            else -> return -1
        }
    }

    override fun confirmarBatalla(batallaPKM: Batalla): Jugador {
        return this
    }

    fun escaparBatalla(batallaPKM: Batalla) {
        batallaPKM.finBatalla("Escape")
    }
}