package Tarea2

interface Entrenador {
    val nombre: String
    val equipoPokemon: MutableList<Pokemon>
    val totalPokemonEnEquipo: Int get() = this.equipoPokemon.size
    val tipo: String get() = "JUGADOR"
    val preferenciaTipoPokemon: List<String> get() = listOf("Normal")
}