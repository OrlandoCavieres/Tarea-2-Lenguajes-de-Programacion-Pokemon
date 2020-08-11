package Tarea2

class Bella(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "BELLA"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Hierba", "Agua", "Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Caballero(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "CABALLERO"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Psiquico", "Hierba", "Agua", "Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Calvo(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "CALVO"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Campista(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "CAMPISTA"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Chica(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "CHICA"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Cientific(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = listOf("Femenino", "Masculino").random()
    override val tipoClaseEntrenador = "CIENTIFIC"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico", "Psiquico", "Normal")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Dominguera(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "DOMINGUERA"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Fuego", "Electrico", "Agua", "Psiquico", "Lucha", "Tierra", "Hierba")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Exorcista(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "EXORCISTA"
    override val preferenciaTipoPokemon: List<String> = listOf("Psiquico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Hicker(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "HICKER"
    override val preferenciaTipoPokemon: List<String> = listOf("Tierra", "Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Iniciada(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "INICIADA"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua", "Fuego", "Hierba")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Joven(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "JOVEN"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Jugon(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "JUGON"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua", "Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Ladron(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "LADRON"
    override val preferenciaTipoPokemon: List<String> = listOf("Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Lider_Gimnacio(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "LIDER DE GIMNASIO"
    override val sizeMinimoEquipoPokemon: Int = listOf(3, 4, 5).random()
    protected var ciudadGimnacio: String = ""
    protected var medalla: String = ""
    protected var tipoPkmRepresenta: String = ""

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }

    fun establecerCiudad(ciudad: String) {
        this.ciudadGimnacio = ciudad
    }

    fun establecerNombreMedalla(nombreMedalla: String) {
        this.medalla = nombreMedalla
    }

    fun establecerTipoQueRepresenta(nombreTipo: String) {
        this.tipoPkmRepresenta = nombreTipo
    }
}

class Luchador(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "LUCHADOR"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Mago(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MAGO"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Psiquico", "Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Marinero(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MARINERO"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha", "Agua")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Mecanico(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MECANICO"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Medium(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "MEDIUM"
    override val preferenciaTipoPokemon: List<String> = listOf("Psiquico")

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Motorista(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MOTORISTA"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Ornitologa(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "ORNITOLOGA"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Pescador(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = listOf("Femenino", "Masculino").random()
    override val tipoClaseEntrenador = "PESCADOR"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5, 6).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Supernerd(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "SUPERNERD"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Swimmer(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = listOf("Femenino", "Masculino").random()
    override val tipoClaseEntrenador = "NADADOR"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Tecnico(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "TECNICO"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}