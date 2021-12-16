/**
 * Un objeto de esta clase
 * guarda una lista de n�meros enteros
 *
 * La clase incluye una serie de m�todos de instancia
 * para hacer operaciones sobre la lista
 * y dos  m�todos est�ticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author - Evelin Virunurm
 */


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Random;

public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private static final Random generador = new Random();
    private int[] lista;
    private int pos;

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tamano maximo de la lista
     */
    public ListaNumeros(int n) {
        this.lista = new int[n];
        this.pos = 0;
    }

    /**
     * Añade un valor al final de la lista
     * siempre que no est� completa
     *
     * @param numero el valor que se anade.
     * @return true si se ha podido anadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if (!estaCompleta()) {
            this.lista[pos] = numero;
            this.pos++;
            return true;
        }
        return false;
    }

    /**
     * @return true si la lista est� completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return (this.pos == this.lista.length);
    }

    /**
     * @return true si la lista esta vacia, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
        return (this.pos == 0);
    }

    /**
     * @return el nu de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;
    }

    /**
     * Vacia la lista
     */
    public void vaciarLista() {
        this.lista = new int[this.lista.length];
        this.pos = 0;
    }

    /**
     * @return una cadena con representacion textual de la lista
     * (leer enunciado)
     *
     * Si la lista esta vacia devuelve ""
     */
    public String toString() {
        if (estaVacia()) {
            return "";
        }
        String s = "";
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != 0) {
                s += anadirCabecera();
            }
            s += saltoLineaFinal(i);
        }
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != 0) {
                s += Utilidades.centrarNumero(this.lista[i], this.ANCHO_FORMATO);
            }
            s += saltoLineaFinal(i);
        }
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != 0) {
                s += anadirCabecera();
            }
            s += saltoLineaFinal(i);
        }
        return s;
    }

    private String anadirCabecera() {
        String s = "";
        for (int i = 0; i < this.ANCHO_FORMATO; i++) {
            s += this.CAR_CABECERA;
        }
        return s;
    }

    private String saltoLineaFinal(int i) {
        if (i == this.lista.length - 1) {
            return "\n";
        }
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
     * @return el segundo valor maximo en la lista
     * Cuando no haya un segundo maximo el metodo
     * devolvera el valor Integer.MIN_VALUE
     *
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     *
     * No se puede usar ningun otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {
        int firMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < this.lista.length; i++) {
            if (firMax < this.lista[i] && this.lista[i] != 0) {
                secMax = firMax;
                firMax = this.lista[i];
                continue;
            }
            if (secMax < this.lista[i] && this.lista[i] != firMax && this.lista[i] != 0) {
                secMax = this.lista[i];
            }
        }
        return secMax;
    }

    /**
     * El metodo coloca los valores que son segundos maximos al principio de
     * la lista respetando el orden de aparicion del resto de elementos
     *
     * No se puede usar ningun otro array auxiliar ni hay que ordenar previamente
     * la lista
     *
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77}
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     *
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     *
     * @return true si se han colocado los segundos maximos
     *          false si no se han colocado los segundos m�ximos porque no hab�a ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        //TODO
        int secMax = segundoMaximo();
        int counter = 0;

        if (secMax != Integer.MIN_VALUE) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] == secMax) {
                    for (int j = i; j > 0; j--) {
                        this.lista[j] = this.lista[j - 1];
                    }
                    this.lista[counter] = secMax;
                    counter++;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * // @param numero busqueda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posicion en la que aparece
     *
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *
     * Usa exclusivamente metodos de la clase Arrays
     */
    public int buscarBinario(int num) {
        int[] copy = Arrays.copyOf(this.lista, this.lista.length);
        Arrays.sort(copy);

        if (Arrays.binarySearch(copy, num) > -1) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] == num) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @return devuelve un array bidimensional de enteros de tamano DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     *
     * Estos valores van a representar el brillo de una zona del espacio
     *
     */
    public static int[][] crearBrillos() {
        int[][] brillos = new int[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                brillos[i][j] = generador.nextInt(11);
            }
        }
        return brillos;
    }

    /**
     * // @param  un array bidimensional brillos
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     *
     * Una posicion f,c del array brillos es una estrella
     * si la suma del valor de los brillos de sus cuatro vecinos
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     *
     * Nota -  No hay estrellas en los bordes del array brillos
     */
     public static boolean[][] detectarEstrellas(int[][] array) {
         boolean[][] hayEstrellas = new boolean[array.length][array.length];

         for (int i = 0; i < array.length; i++) {
             if (i != 0 && i != array.length - 1) {
                 for (int j = 0; j < array[i].length; j++) {
                     if (j != 0 && j != array[i].length - 1) {
                         if ((array[i][j] + array[i-1][j] + array[i+1][j] + array[i][j+1] + array[i][j-1]) > 30) {
                             hayEstrellas[i][j] = true;
                         }
                     }
                 }
             }
         }
        return hayEstrellas;
    }

}
