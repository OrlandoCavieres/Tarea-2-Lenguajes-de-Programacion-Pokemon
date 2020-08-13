package Tarea2
import kotlin.math.pow

/**
 * Función infija que permite emplear 'elevado' como conector entre dos elementos en una expresión y calcula
 * la potencia del primer numero con exponente el segundo numero.
 * @Sample 4 elevado 7
 */
infix fun Int.elevado(exponente: Int): Int = toDouble().pow(exponente).toInt()

/**
 * Interface que representa a un pokemon y sus atributos básicos, así como sus acciones básicas y formas de implementar
 * y manejarlas.
 * @constructor Inicializa una instancia pokemon.
 * @property nombre Nombre del pokemon.
 * @property apodo Apodo ingresado para el pokemon.
 * @property vida Cantidad de vida disponible del pokemon.
 * @property tipo Tipo del pokemon en forma string. Por default es Normal.
 * @property contadorDamage Numero que representa el daño actual acumulado del pokemon
 * @property ataquePrimario Numero que representa el daño que realiza el primer ataque del pokemon.
 * @property ataqueSecundario Numero que representa el daño que realiza el segundo ataque del pokemon.
 * @property ataqueSeleccionado Numero que representa el ataque seleccionado a realizar del pokemon.
 * @property nivel Numero que representa el nivel actual del pokemon.
 * @property experienciaAcumuladaEnNivel Numero que representa la cantidad de experiencia acumulada en el nivel actual.
 */
interface Pokemon {
    val nombre: String
    var apodo: String
    var vida: Int
    val tipo: String get() = "Normal"
    var contadorDamage: Int
    var ataquePrimario: Int
    var ataqueSecundario: Int
    var ataqueSeleccionado: Int
    var nivel: Int
    var experienciaAcumuladaEnNivel: Int

    /**
     * Método que permite cambiar el apodo del pokemon.
     * @param nuevoApodo String con el nuevo apodo.
     *  */
    fun ponerApodo(nuevoApodo: String) {
        this.apodo = nuevoApodo
    }

    /**
     * Método que hace que el pokemon inicie el ataque contra otro pokemon, presentándose a sí mismo con él.
     * @param pokemon Pokemon al que se desea atacar.
     * @return El pokemon que se desea atacar o null, si realmente no es pokemon.
     */
    fun iniciarAtaque(pokemon: Pokemon?): Pokemon? {
        return if (pokemon != null) {
            pokemon.observarOponenteYEntregarDatos(this)
            pokemon
        }
        else { null }
    }

    /**
     * Método que le indica a un pokemon que se le permite atacar al pokemon actual.
     * @param pokemon Pokemon oponente.
     */
    fun observarOponenteYEntregarDatos(pokemon: Pokemon) {
        pokemon.atacar(this)
    }

    /**
     * Método que se encarga de ver si es posible atacar al pokemon oponente o no, dadas distintas posibilidades.
     * @param oponente Pokemon oponente al que se planea atacar.
     */
    fun atacar(oponente: Pokemon) {
        when {
            this.fueraDeCombate() -> println("${this.nombre}: No puedo atacar, fui derrotado")
            oponente.fueraDeCombate() -> println("${this.nombre}: Enemigo ya fue derrotado")
            else -> this.realizarAtaque(oponente, this.ataqueSeleccionado)
        }
    }

    /**
     * Método que permite seleccionar entre los distintos ataques del pokemon. Debe ser 1 o 2, dado que solo se tiene
     * ataque primario y secundario.
     * @param decision Numero que representa el ataque a realizar. Puede ser 1 o 2.
     */
    fun seleccionarAtaqueAUsar(decision: Int) {
        this.ataqueSeleccionado = decision
    }

    /**
     * Método que realiza el ataque estableciendo la ruta según el ataque seleccionado.
     * @param oponente Pokemon al que se está atacando.
     * @param ataque Ataque seleccionado. Puede ser 1 o 2.
     */
    fun realizarAtaque(oponente: Pokemon, ataque: Int)

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo normal.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibeNormalDamage(oponente: Pokemon) {
        when (oponente.ataqueSeleccionado) {
            1 -> this.contadorDamage += oponente.ataquePrimario
            2 -> this.contadorDamage += oponente.ataqueSecundario
        }
    }

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo fuego.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibeFireDamage(oponente: FirePokemon) {this.recibeNormalDamage(oponente)}

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo agua.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibeWaterDamage(oponente: WaterPokemon) {this.recibeNormalDamage(oponente)}

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo electrico.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibeElectricDamage(oponente: ElectricPokemon) {this.recibeNormalDamage(oponente)}

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo psiquico.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibePsychicDamage(oponente: PsychicPokemon) {this.recibeNormalDamage(oponente)}

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo tierra.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibeGroundDamage(oponente: GroundPokemon) {this.recibeNormalDamage(oponente)}

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo lucha.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibeFightDamage(oponente: FightPokemon) {this.recibeNormalDamage(oponente)}

    /**
     * Método que aumenta el contador de daño del pokemon si el ataque recibido del pokemon contrincante es de
     * tipo hierba.
     * @param oponente Pokemon que realiza el ataque.
     */
    fun recibeGrassDamage(oponente: GrassPokemon) {this.recibeNormalDamage(oponente)}

    /**
     * Método que verifica si un pokemon está debilitado o no.
     * @return True si el pokemon está derrotado.
     */
    fun fueraDeCombate(): Boolean {
        return this.contadorDamage >= this.vida
    }

    /**
     * Método que calcula la cantidad restante de vida, al considerar la vida base y el daño acumulado en el contador
     * de daño.
     * @return Número de vida restante.
     */
    fun vidaRestante(): Int {
        return when {
            this.contadorDamage >= this.vida -> 0
            else -> this.vida - this.contadorDamage
        }
    }

    /**
     * Método que permite restaurar al pokemon a su estado inicial sin daño al resetear su contador de daño.
     */
    fun restaurarPkmAlMaximo() {
        this.contadorDamage = 0
    }

    /**
     * Método que permite modificar el daño del ataque primario en base a un modificador dado, el que se suma al daño
     * base del ataque primario.
     * @param pokemon Pokemon que realiza el ataque.
     * @param modificador Número en que se modifica el ataque primario del pokemon.
     */
    fun modDamageAtaquePrimario(pokemon: Pokemon, modificador: Int) {
        when (pokemon.ataqueSeleccionado) {
            1 -> this.contadorDamage += pokemon.ataquePrimario + modificador
        }
    }

    /**
     * Método que calcula la cantidad de experiencia necesaria para subir de nivel dado el nivel actual.
     * @return Número que representa cantidad requerida de experiencia para subir de nivel.
     */
    fun experienciaRequeridaSubirNivel(): Int {
        return ((this.nivel + 1) elevado 3) - (this.nivel elevado 3)
    }

    /**
     * Método que verifica si el pokemon está capacitado en experiencia para subir de nivel.
     * @return True si el pokemon esta habilitado para poder subir de nivel.
     */
    fun verificarRequisitoExpSubirNivel(): Boolean {
        return this.experienciaAcumuladaEnNivel >= this.experienciaRequeridaSubirNivel()
    }

    /**
     * Método que permite subir de nivel a un pokemon. Emplea otros métodos y criterios para ver si es posible subir
     * de nivel en base a la experiencia acumulada y necesaria. Modifica las propiedades del pokemon para ser adaptados al
     * nuevo nivel.
     */
    fun subirNivel() {
        when {
            verificarRequisitoExpSubirNivel() && this.nivel >= 1 && this.nivel < 100 -> {
                this.experienciaAcumuladaEnNivel = this.experienciaAcumuladaEnNivel - this.experienciaRequeridaSubirNivel()
                this.nivel += 1
                println("¡${this.nombre} ha subido a nivel ${this.nivel}!")
                val listaAumentoParametros = listOf(1, 2, 3)
                this.vida += listaAumentoParametros.random()
                this.ataquePrimario += listaAumentoParametros.random()
                this.ataqueSecundario += listaAumentoParametros.random()
            }
            !verificarRequisitoExpSubirNivel() -> {}
            else -> this.experienciaAcumuladaEnNivel = 0
        }
    }

    /**
     * Método que confirma la participación del pokemon en una batalla pokemon, si es un pokemon salvaje.
     * @param batallaPKM Batalla en la que va a participar el pokemon.
     * @return Entrega al pokemon.
     */
    fun confirmarBatallaPokemonSalvaje(batallaPKM: Batalla): Pokemon {
        return this
    }

    /**
     * Método que permite obtener experiencia al pokemon como resultado de una batalla pokemon.
     * @param batallaPKM Batalla en la que participa el pokemon.
     */
    fun recibeExperiencia(batallaPKM: Batalla) {
        batallaPKM.darExperienciaPKM(this)
    }
}
