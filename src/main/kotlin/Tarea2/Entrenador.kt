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

    fun recuperarPokemonEnLaPosicionEquipo(posicion: Int): Pokemon? {
        val nombrePKM = this.ordenEquipoPokemon[posicion]
        if (this.equipoPokemon[nombrePKM] != null) {
            return this.equipoPokemon[nombrePKM]
        }
        else {
            return null
        }
    }

    fun recuperarPokemonEnCabecera(): Pokemon? {
        return recuperarPokemonEnLaPosicionEquipo(0)
    }

    fun confirmarBatalla(batallaPKM: Batalla): Entrenador
}