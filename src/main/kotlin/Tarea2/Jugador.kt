package Tarea2

class Jugador(override val nombre: String): Entrenador {
    override val equipoPokemon: MutableList<Pokemon> = mutableListOf()
    private var dinero = 3000
    private var totalPokemonCapturados = 0

    protected fun elegirPrimerPokemon(tipo: String) {
        when {
            this.equipoPokemon.isEmpty() -> this.pokemonInicial(tipo)
            else -> println("Ya se ha elegido el primer Pokemon")
        }
    }

    private fun pokemonInicial(tipo: String) {
        when (tipo) {
            "Hierba" -> this.equipoPokemon.add(GrassPokemon(nombre = "Bulbasaur", vida = 45, ataquePrimario = 65, ataqueSecundario = 49))
            "Fuego" -> this.equipoPokemon.add(FirePokemon(nombre = "Charmander", vida = 39, ataquePrimario = 60, ataqueSecundario = 52))
            "Agua" -> this.equipoPokemon.add(WaterPokemon(nombre = "Squirtle", vida = 44, ataquePrimario = 50, ataqueSecundario = 48))
        }
        this.totalPokemonCapturados += 1
    }

    protected fun verificarCupoMaxEquipoPKM(): Boolean {
        return this.equipoPokemon.size <= 6
    }

    fun mostrarTotalPokemonCapturados(): Int {
        return this.totalPokemonCapturados
    }

    fun dineroDisponible(): Int {
        return this.dinero
    }
}