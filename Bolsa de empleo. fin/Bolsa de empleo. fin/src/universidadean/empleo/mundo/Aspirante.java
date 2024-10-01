
package universidadean.empleo.mundo;



public class Aspirante {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica que la profesi�n es ADMINISTRADOR
     */
    public static final String ADMINISTRADOR = "Administrador";

    /**
     * Indica que la profesi�n es INGENIERO INDUSTRIAL
     */
    public static final String INGENIERO_INDUSTRIAL = "Ingeniero Industrial";
    public static final String INGENIERO_SISTEMAS = "Ingeniero de Sistemas";
    public static final String DISEÑADOR_GRAFICO = "Diseñador Grafico";
    public static final String INGENIERO_SOFTWARE = "Ingeniero de Software";
    public static final String ANALISTA_DATOS = "Analista de Datos";
    public static final String GERENTE_PROYECTOS = "Gerente de Proyectos";
    /**
     * Indica que la profesi�n es contador
     */
  
    public static final String CONTADOR = "Contador";

    /**
     * Indica que la profesi�n es economista
     */
    public static final String ECONOMISTA = "Economista";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El nombre del aspirante
     */
    private String nombre;

    /**
     * La profesi�n del aspirante
     */
    private String profesion;

    /**
     * Los a�os de experiencia del aspirante
     */
    private int aniosExperiencia;

    /**
     * La edad del aspirante
     */
    private int edad;

    /**
     * El tel�fono del aspirante
     */
    private String telefono;

    /**
     * La ruta de la imagen del aspirante
     */
    private String imagen;
    
    // Atributo para la cédula del aspirante
    private String cedula;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo aspirante con los par�metros indicados
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesi�n del aspirante - profesionA pertenece a { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA A�os de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El tel�fono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @param cedulaA           La cédula del aspirante - cedulaA != null
     */
    public Aspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA, String cedulaA) {
        nombre = nombreA;
        profesion = profesionA;
        aniosExperiencia = aniosExperienciaA;
        edad = edadA;
        telefono = telefonoA;
        imagen = imagenA;
        cedula = cedulaA;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del aspirante
     *
     * @return nombre
     */
    public String darNombre() {
        return nombre;
    }

    /**
     * Retorna la profesi�n del aspirante
     *
     * @return profesion
     */
    public String darProfesion() {
        return profesion;
    }

    /**
     * Retorna los a�os de experiencia del aspirante
     *
     * @return aniosExperiencia
     */
    public int darAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Retorna la edad del aspirante
     *
     * @return edad
     */
    public int darEdad() {
        return edad;
    }

    /**
     * Retorna el tel�fono del aspirante
     *
     * @return telefono
     */
    public String darTelefono() {
        return telefono;
    }

    /**
     * Retorna la ruta de la imagen del aspirante
     *
     * @return imagen
     */
    public String darImagen() {
        return imagen;
    } 
        /**
     * Retorna la cédula del aspirante
     *
     * @return cedula
     */
    public String darCedula() {
        return cedula; // Método getter para cédula
    }

    public void cambiarCedula(String cedulaA) {
        this.cedula = cedulaA; // Método setter para cédula
        
    }    
    

    /**
     * Retorna una cadena con el nombre del aspirante, su profesi�n y los a�os de experiencia
     *
     * @return Informaci�n del aspirante en una cadena con el formato "<nombre> - <profesion>"
     */
    public String toString() {
       return nombre + " - " + profesion + " - Cédula: " + cedula;
    }
}