package Tarea2

interface Entrenador {
    val nombre: String
    val equipoPKM: MutableList<Pokemon>
    var dinero: Int
    var totalPokemonCapturados: Int
    val totalPokemonEnEquipo: Int get() = this.equipoPKM.size
}