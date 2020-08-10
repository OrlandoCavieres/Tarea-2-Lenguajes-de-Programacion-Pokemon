package Tarea2

class Jugador(override val nombre: String): Entrenador {
    override val equipoPKM: MutableList<Pokemon> = mutableListOf()
    override var dinero = 3000
    override var totalPokemonCapturados = 0

    protected fun elegirPrimerPokemon(tipo: String) {
        when {
            this.equipoPKM.isEmpty() -> this.pokemonInicial(tipo)
            else -> println("Ya se ha elegido el primer Pokemon")
        }
    }

    private fun pokemonInicial(tipo: String) {
        when (tipo) {
            "Hierba" -> this.equipoPKM.add(GrassPokemon(nombre = "Bulbasaur", vida = 45, ataquePrimario = 65, ataqueSecundario = 49))
            "Fuego" -> this.equipoPKM.add(FirePokemon(nombre = "Charmander", vida = 39, ataquePrimario = 60, ataqueSecundario = 52))
            "Agua" -> this.equipoPKM.add(WaterPokemon(nombre = "Squirtle", vida = 44, ataquePrimario = 50, ataqueSecundario = 48))
        }
        this.totalPokemonCapturados += 1
    }

    protected fun verificarCupoMaxEquipoPKM(): Boolean {
        return this.equipoPKM.size <= 6
    }
}