package Tarea2

class Bella(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "BELLA"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Hierba", "Agua", "Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((1600..2200) step 50).toList().random()
    override val mensajeInicial: String = "¡Oh! ¡Mira qué encanto!"
    override val mensajeDerrota: String = "¡Pensaba que eras un encanto!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Caballero(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "CABALLERO"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Psiquico", "Hierba", "Agua", "Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((2500..4000) step 100).toList().random()
    override val mensajeInicial: String = "¿Eh? ¿Quieres medirte contra mí? En tal caso, espero que me demuestres un poder digno."
    override val mensajeDerrota: String = "Tengo un buen olfato para los negocios, pero mediocre para los combates."

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Calvo(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "CALVO"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4).random()
    override val dineroRecompensa: Int = ((600..800) step 25).toList().random()
    override val mensajeInicial: String = "¡Tengo hambre y no estoy de humor!"
    override val mensajeDerrota: String = "¡Mal, mal, muy mal!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Campista(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "CAMPISTA"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((250..350) step 2).toList().random()
    override val mensajeInicial: String = "¡Eh tu! ¡No tires basura!"
    override val mensajeDerrota: String = "Sólo estaba diciendo que..."

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Chica(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "CHICA"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((400..1000) step 20).toList().random()
    override val mensajeInicial: String = "Mi amigo tiene unos POKéMON muy monos. ¡Qué envidia!"
    override val mensajeDerrota: String = "¡No estoy enfadada!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Cientific(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = listOf("Femenino", "Masculino").random()
    override val tipoClaseEntrenador = "CIENTIFIC"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico", "Psiquico", "Normal")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((1000..2000) step 50).toList().random()
    override val mensajeInicial: String = "¡Estás en zona prohibida! ¡Vuelve a casa!"
    override val mensajeDerrota: String = "¡Eres muy bueno!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Dominguera(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "DOMINGUERA"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Fuego", "Electrico", "Agua", "Psiquico", "Lucha", "Tierra", "Hierba")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5).random()
    override val dineroRecompensa: Int = ((250..350) step 2).toList().random()
    override val mensajeInicial: String = "¡Déjame probar los POKéMON que acabo de cambiar!"
    override val mensajeDerrota: String = "¡No ha sido suficiente!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Exorcista(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "EXORCISTA"
    override val preferenciaTipoPokemon: List<String> = listOf("Psiquico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((600..900) step 10).toList().random()
    override val mensajeInicial: String = "¡Fuera, espíritu infernal!"
    override val mensajeDerrota: String = "¡El espíritu se fue!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Hicker(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "HICKER"
    override val preferenciaTipoPokemon: List<String> = listOf("Tierra", "Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((800..2000) step 50).toList().random()
    override val mensajeInicial: String = "¡Eh! ¿Me enseñas la fuerza que tienes?"
    override val mensajeDerrota: String = "¿Qué ha pasado?"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Iniciada(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "INICIADA"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua", "Fuego", "Hierba")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((700..1250) step 20).toList().random()
    override val mensajeInicial: String = "¡Vamos allá, pero no hagas trampas!"
    override val mensajeDerrota: String = "¿Qué? ¡No puede ser!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Joven(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "JOVEN"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((200..600) step 2).toList().random()
    override val mensajeInicial: String = "¡Soy el mejor de mi clase!"
    override val mensajeDerrota: String = "¿Qué? ¿Cómo ha podido ocurrir?"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Jugon(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "JUGON"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua", "Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((1250..1500) step 10).toList().random()
    override val mensajeInicial: String = "¡Gana, pierde o empata!"
    override val mensajeDerrota: String = "¡Tuve una oportunidad!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Ladron(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "LADRON"
    override val preferenciaTipoPokemon: List<String> = listOf("Fuego")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((400..800) step 20).toList().random()
    override val mensajeInicial: String = "¡Oh-oh! ¿Dónde estoy ahora?"
    override val mensajeDerrota: String = "¡Oh no! ¡Mi botín!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Luchador(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "LUCHADOR"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((700..1400) step 50).toList().random()
    override val mensajeInicial: String = "¡Dicen que eres bueno! ¡Demuéstramelo!"
    override val mensajeDerrota: String = "¡Juez! ¡1 punto!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Mago(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MAGO"
    override val preferenciaTipoPokemon: List<String> = listOf("Normal", "Psiquico", "Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((1000..1900) step 100).toList().random()
    override val mensajeInicial: String = "¡A ver si superas mis técnicas especiales!"
    override val mensajeDerrota: String = "¡Me engañaste!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Marinero(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MARINERO"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha", "Agua")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((500..800) step 10).toList().random()
    override val mensajeInicial: String = "¡Ya sabes lo que dicen de los marineros y las peleas!"
    override val mensajeDerrota: String = "¡Tú espíritu me hundió!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Mecanico(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MECANICO"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((800..1300) step 25).toList().random()
    override val mensajeInicial: String = "¡Cuidado con esos cables!"
    override val mensajeDerrota: String = "¡Uaauu! ¡Vaya chispazo!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Medium(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "MEDIUM"
    override val preferenciaTipoPokemon: List<String> = listOf("Psiquico")
    override val dineroRecompensa: Int = ((1100..1800) step 50).toList().random()
    override val mensajeInicial: String = "Ya veo... Todo lo que hay que ver de ti..."
    override val mensajeDerrota: String = "No me imaginaba tu poder..."

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Motorista(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "MOTORISTA"
    override val preferenciaTipoPokemon: List<String> = listOf("Lucha")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3).random()
    override val dineroRecompensa: Int = ((500..1000) step 25).toList().random()
    override val mensajeInicial: String = "¡Mira, colega, si pierdes contra mí, todo tu dinero será mío!"
    override val mensajeDerrota: String = "¡No sé qué decir!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Ornitologa(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Femenino"
    override val tipoClaseEntrenador = "ORNITOLOGA"
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5).random()
    override val dineroRecompensa: Int = ((600..900) step 20).toList().random()
    override val mensajeInicial: String = "¡Silbando puedo llamar a los POKéMON!"
    override val mensajeDerrota: String = "¡Ooh! ¡Qué tragedia!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Pescador(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = listOf("Femenino", "Masculino").random()
    override val tipoClaseEntrenador = "PESCADOR"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5, 6).random()
    override val dineroRecompensa: Int = ((700..1000) step 10).toList().random()
    override val mensajeInicial: String = "¡Bien! ¡Ha picado algo!"
    override val mensajeDerrota: String = "¡Bah! Era muy pequeñajo"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Supernerd(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "SUPERNERD"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((400..700) step 5).toList().random()
    override val mensajeInicial: String = "Pareces bueno en POKéMON, pero... ¿Qué tal en química?"
    override val mensajeDerrota: String = "¡Ah! ¡Fusión nuclear!"

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Swimmer(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = listOf("Femenino", "Masculino").random()
    override val tipoClaseEntrenador = "NADADOR"
    override val preferenciaTipoPokemon: List<String> = listOf("Agua")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2, 3, 4, 5).random()
    override val dineroRecompensa: Int = ((300..600) step 10).toList().random()
    override val mensajeInicial: String = "Aquí hay mucho oleaje. Cuesta nadar."
    override val mensajeDerrota: String = "¡Oh! Tienes más energía que yo."

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}

class Tecnico(override val nombre: String, override var nivelAproximado: Int = 5): Entrenador {
    override var genero = "Masculino"
    override val tipoClaseEntrenador = "TECNICO"
    override val preferenciaTipoPokemon: List<String> = listOf("Electrico")
    override val sizeMinimoEquipoPokemon: Int = listOf(1, 2).random()
    override val dineroRecompensa: Int = ((1000..1400) step 10).toList().random()
    override val mensajeInicial: String = "¡Soy un experto en electricidad!"
    override val mensajeDerrota: String = "Se acabó..."

    override fun confirmarBatalla(batallaPKM: Batalla): Entrenador {
        return this
    }
}