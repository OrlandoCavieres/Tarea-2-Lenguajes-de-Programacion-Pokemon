package Tarea2

interface Entrenador {
    val nombre: String
    val equipoPKM: MutableList<Pokemon>
    val totalPokemonEnEquipo: Int get() = this.equipoPKM.size
    val tipo: String get() = "JUGADOR"
}