package com.masanz.prog.ut5.pln;

/**
 * Un objeto de esta clase guarda una lista de números enteros
 * 
 * La clase incluye una serie de métodos de instancia para hacer operaciones sobre la lista
 * y dos métodos estáticos para trabajar con arrays de dos dimensiones
 *
 * @author ESCRIBE_TU_NOMBRE
 *
 */

import java.util.Random;

public class ListaNumeros {

    // region constantes
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';
    // endregion

    // region atributos
    private static final Random generador = new Random();

    //TODO 10: Atributos
    
    // endregion

    // region constructores
    /**
     * Constructor de la clase
     * Crea e inicializa adecuadamente los atributos
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        //TODO 11: Constructor
    }
    // endregion

    // region arrays
    /**
     * Añade un valor al final de la lista siempre que no está completa
     * @param numero el valor que se añade.  
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        //TODO 12: addElemento
        return false;
    }

    /**
     * Si la lista está completa
     * @return true si la lista está completa, false en otro caso (hacer sin if)
     */
    public boolean estaCompleta() {
        //TODO 13: estaCompleta
        return true;
    }

    /**
     * Si la lista está vacía
     * @return true si la lista está vacía, false en otro caso (hacer sin if)
     */
    public boolean estaVacia() {
        //TODO 14: estaVacia
        return false;
    }

    /**
     * Total de números almacenados
     * @return el número de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        //TODO 15: getTotalNumeros
        return 0;
    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
        //TODO 16: getTotalNumeros
    }

    /**
     * Representación textual de la lista como se indica en el enunciado.
     * @return una cadena con representación textual de la lista
     * Si la lista está vacía devuelve cadena vacía
     */
    public String toString() {
        //TODO 17: toString
       return "";
    }

     

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor máximo en la lista
     * Cuando no haya un segundo máximo el método 
     * devolverá el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {
        //TODO 18: segundoMaximo
        return -1;
    }

    /**
     * El método coloca los valores que son segundos máximos al principio de
     * la lista respetando el orden de aparición del resto de elementos
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos máximos
     *          false si no se han colocado los segundos máximos porque no había ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        //TODO 19: segundosMaximosAlPrincipio
        return false;
    }

    /**
     * @param numero búsqueda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posición en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea previamente una copia
     * de lista y trabaja con la copia
     *  
     * Usa exclusivamente métodos de la clase Arrays
     */
    public int buscarBinario(int numero) {
        //TODO 20: buscarBinario
        return -1;
    }

    // endregion

    // region matrices
    /**
     * 
     * @return devuelve un array bidimensional de enteros de tamaño DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int[][] crearBrillos() {
        //TODO 21: crearBrillos
        return null;
    }

    /**
     * @param  brillos un array bidimensional
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posición f,c del array brillos es una estrella
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota: No hay estrellas en los bordes del array brillos
     */
    public static boolean[][] detectarEstrellas(int[][] brillos) {
        //TODO 22: detectarEstrellas
        return null;
    }
    // endregion

}
