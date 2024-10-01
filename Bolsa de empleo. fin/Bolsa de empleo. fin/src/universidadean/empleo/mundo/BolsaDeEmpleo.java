
package universidadean.empleo.mundo;

import java.util.ArrayList;


public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private ArrayList<Aspirante> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    public BolsaDeEmpleo() {
        aspirantes = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public ArrayList<Aspirante> darAspirantes() {
        ArrayList<Aspirante> copia = new ArrayList<>(aspirantes);
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesi�n del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA A�os de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El tel�fono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @param cedulaA           La cédula del aspirante - cedulaA != null y única en la bolsa
     * @return Se retorn� true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA,String cedulaA) {
        int aspiranteBuscado = buscarAspirante(nombreA);
        boolean agregado = false;
        if (aspiranteBuscado == -1) {
            Aspirante nuevoAspirante = new Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA, cedulaA);
            aspirantes.add(nuevoAspirante);
            agregado = true;
        }

        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        // TODO: Realizar el ejercicio correspondiente

        int n = this.aspirantes.size();
        Aspirante temp;

        for (int i = 0; i < n; i++) {
            for (int j =  i +1; j < n; j++) {

                if (this.aspirantes.get(j).darNombre().compareToIgnoreCase(this.aspirantes.get(i).darNombre())<0) {

                    temp = this.aspirantes.get(i);

                    this.aspirantes.set(i, this.aspirantes.get(j));
                    this.aspirantes.set(j, temp);

                }
            }
        }

    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selecci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por edad
     */
    public void ordenarPorEdad() {
        // TODO: Realizar el ejercicio correspondiente
        int i, j, pos;
        Aspirante menor, tmp;
        int n = this.aspirantes.size();
        for (i = 0; i < n - 1; i++) {
            menor = this.aspirantes.get(i);
            pos = i;
            for (j = i + 1; j < n; j++){
                if (this.aspirantes.get(j).darEdad() < menor.darEdad()) {
                    menor = this.aspirantes.get(j);
                    pos = j;
                }
            }
            if (pos != i){
                tmp = this.aspirantes.get(i);
                this.aspirantes.set(i,this.aspirantes.get(pos));
                this.aspirantes.set(pos,tmp);
            }
        }
    }

    /**
     * Organiza la lista de aspirantes por profesi�n usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesi�n
     */
    public void ordenarPorProfesion() {
        // TODO: Realizar el ejercicio correspondiente
        int n = this.aspirantes.size();
        Aspirante temp;

        for (int i = 0; i < n; i++) {
            for (int j =  i +1; j < n; j++) {


                if (this.aspirantes.get(j).darProfesion().compareToIgnoreCase(this.aspirantes.get(i).darProfesion())<0) {

                    temp = this.aspirantes.get(i);

                    this.aspirantes.set(i, this.aspirantes.get(j));
                    this.aspirantes.set(j, temp);

                }
            }
        }

    }

    /**
     * Organiza la lista de aspirantes por a�os de experiencia usando el algoritmo de inserci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por a�os de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
        // TODO: Realizar el ejercicio correspondiente
        int p, j;
        Aspirante temp;
        int n = this.aspirantes.size();
        for (p = 1; p < n; p++){
            temp = this.aspirantes.get(p);
            j = p - 1;
            while ((j >= 0) && (temp.darAniosExperiencia() < this.aspirantes.get(j).darAniosExperiencia())){
                this.aspirantes.set(j + 1,  this.aspirantes.get(j));
                j--;
            }
            this.aspirantes.set(j + 1,temp);
        }
    }

    /**
     * Busca un Aspirante seg�n su nombre y retorna la posici�n en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retorn� la posici�n donde se encuentra un aspirante con el nombre dado.
     * Si no se encuentra ning�n aspirante con ese nombre se retorn� -1.
     */
    public int buscarAspirante(String nombre) {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        int i = 0;
        for (Aspirante a: aspirantes) {
            if (a.darNombre().equalsIgnoreCase(nombre)) {
                posicion = i;
            }
            i++;
        }
        return posicion;
    }

    /**
     * Busca un aspirante utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retorn� la posici�n del aspirante con el nombre dado. Si el aspirante no existe se retorn� -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        int posicion = -1;
        int ini = 0;
        int fin = aspirantes.size() - 1;

        // TODO: Realizar el ejercicio correspondiente
        this.ordenarPorNombre();
        while (ini <= fin) {
            int m = (ini + fin) / 2;
            if (aspirantes.get(m).darNombre().compareToIgnoreCase(nombre) < 0) {
                System.out.println("Entro a la menor");
                ini = m +1;
            }
            else if (aspirantes.get(m).darNombre().compareToIgnoreCase(nombre) > 0) {
                System.out.println("Entro a la mayor");
                fin = m - 1;
            } else {
                posicion = m;
                return posicion;
            }
        }

        return posicion;
    }


    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante m�s joven.
     * Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMasJoven() {
        int posicion = -1;
        // TODO: Realizar el ejercicio correspondiente
        if (this.aspirantes.size() != 0) {
        posicion = 0;
        int i = 0;
        for (Aspirante a: aspirantes) {
            if (a.darEdad() < this.aspirantes.get(posicion).darEdad()) {
                posicion = i;
            }
            i++;
        }
        }

        return posicion;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con m�s edad.
     * Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorEdad() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        if (this.aspirantes.size() != 0) {
            posicion = 0;
            int i = 0;
            for (Aspirante a: aspirantes) {
                if (a.darEdad() > this.aspirantes.get(posicion).darEdad()) {
                    posicion = i;
                }
                i++;
            }
        }

        return posicion;
    }
    public int buscarAspirantePorCedula(String cedula) {
        int posicion = -1;
        int i = 0;
        for (Aspirante a : aspirantes) {
            if (a.darCedula().equalsIgnoreCase(cedula)) {
                posicion = i;
            }
            i++;
        }
        return posicion;
    }   
    /**
     * Busca el aspirante con m�s a�os de experiencia en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con mayor experiencia.
     * Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int posicion = -1;

        // TODO: Realizar el ejercicio correspondiente
        if (this.aspirantes.size() != 0) {
            posicion = 0;
            int i = 0;
            for (Aspirante a: aspirantes) {
                if (a.darAniosExperiencia() > this.aspirantes.get(posicion).darAniosExperiencia()) {
                    posicion = i;
                }
                i++;
            }
        }

        return posicion;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se elimin� el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retorn� true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;

        // TODO: Realizar el ejercicio correspondiente
        System.out.println( this.aspirantes.get(0));
        if (nombre != null) {
        int i = 0;
        for (Aspirante a: aspirantes) {
            if(a.darNombre().equalsIgnoreCase(nombre)) {
                this.aspirantes.remove(i);
                contratado = true;
                break;
            }
            i++;

        }
        }
        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos a�os de experiencia <br>
     * son menores a la cantidad de a�os especificada <br>
     *
     * @param aniosExperiencia La cantidad de a�os con relaci�n a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;
        int cont = 0;

        // TODO: Realizar el ejercicio correspondiente
        if (aniosExperiencia >= 0) {
            ArrayList<Integer> indexAEliminar = new ArrayList<>();

            /*Aqu� busco los index de las personas a eliminar seg�n la condici�n y las agrego
            a una lista */
            for (Aspirante a: aspirantes) {
                if(a.darAniosExperiencia() < aniosExperiencia) {
                    indexAEliminar.add(cont);
                }
                cont++;

            }

            /*Aqu� recorro la lista de index creada previamente y elimino los aspirantes seg�n el index obtenido,
             y debido a que con las eliminaciones los index van cambiando,
             resto -1 al index luego de la primera eliminaci�n*/
            if (indexAEliminar.size() > 0) {
                int j = 0;
                for (int index : indexAEliminar) {
                    this.aspirantes.remove(index - j);
                    j = 1;
                }
            }
            eliminados = indexAEliminar.size();
            System.out.println(indexAEliminar);
        }
        return eliminados;
    }

}