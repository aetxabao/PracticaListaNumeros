/**
 * Un objeto de esta clase
 * guarda una lista de números enteros
 * 
 * La clase incluye una serie de métodos de instancia
 * para hacer operaciones sobre la lista
 * y dos  métodos estáticos para trabajar con
 * arrays de dos dimensiones
 *
 * @author - Adrian Garcia Galera
 */


import java.util.Random;
import java.util.Arrays;

public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';
    
    private static final Random generador = new Random();
    
    int[] lista;
    int pos;

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        lista = new int[n];
        pos = 0;
    }

    /**
     * Añade un valor al final de la lista 
     * siempre que no esté completa
     *
     * @param numero el valor que se añade.  
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if (!estaCompleta()){
            lista[pos] = numero;
            pos++;
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return (pos == lista.length);

    }

    /**
     * @return true si la lista está vacía, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
       return (pos <= 0);

    }

    /**
     * @return el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;

    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
       lista = new int[lista.length];
       pos = 0;
    }

    /**
     * @return una cadena con representación textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
       if(estaVacia()){
           return "";
       }
       
       String str = "";
        
       for(int i = 0; i < lista.length; i++){
           for( int j = 0; j < ANCHO_FORMATO; j++){
               str += CAR_CABECERA;
           }
       }
       
       str += "\n";
       
       for(int i = 0; i < lista.length; i++){
           str += Utilidades.centrarNumero(lista[i], ANCHO_FORMATO);
       }
       
       str += "\n";
       
       for(int i = 0; i < lista.length; i++){
           for( int j = 0; j < ANCHO_FORMATO; j++){
               str += CAR_CABECERA;
           }
       }
       
       
       return str;
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
       int maximo = 0;
       int maximo2 = 0;
       int vecesMaximo = 0;
       for (int i = 0; i < lista.length; i++){
           if(lista[i] > maximo){
               maximo = lista[i];
           }
       }
       
       for (int j = 0; j < lista.length; j++){
           if(lista[j] > maximo2 && lista[j] < maximo){
               maximo2 = lista[j];
           }else if(lista[j] == maximo){
               vecesMaximo++;
           }
           if(vecesMaximo == lista.length){
               return Integer.MIN_VALUE;
           }
       }

       return maximo2;
    }

    /**
     * El método coloca los valores que son segundos máximos al principio de
     * la lista respetando el orden de aparición del resto de elementos
     * 
     * No se puede usar ningún otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos máximos
     *          false si no se han colocado los segundos máximos porque no había ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
      int maximo = 0;
      int maximo2 = 0;
      int numMaximos2 = 0;
      int a = 0;
      int b = 0;
      int vecesMaximo = 0;
      for (int i = 0; i < lista.length; i++){
          if(lista[i] > maximo){
               maximo = lista[i];
          }
      }
      for (int j = 0; j < lista.length; j++){
          if(lista[j] > maximo2 && lista[j] < maximo){
               maximo2 = lista[j];
          }
          if(lista[j] == maximo2){
              numMaximos2++;
          }
      }
      for (int z = 0; z < numMaximos2; z++){
          if(lista[z] == maximo2){
              lista[z] = maximo2;
          }
          if(lista[z] != maximo2){
              a = lista[z];
              lista[z] = maximo2;
              lista[z+1] = a;
          }
      }
      
      return numMaximos2 != 0;
      
    }

    /**
     * @param numero búsqueda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posición en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente métodos de la clase Arrays
     */
    public int buscarBinario(int numero) {
        int[] copia = Arrays.copyOf(lista,lista.length);
        int max = 0;
        for (int i = 0; i < copia.length; i++){
            if(copia[i] == numero){
                break;
            }else{
                max++;
            }
        }
        if(max == copia.length){
            return -1;
        }else{
            return Arrays.binarySearch(copia, numero);
        }
        
    }

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tamaño DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int[][] crearBrillos() {
       int[][] brillos;
       
       brillos = new int[DIMENSION][DIMENSION];
       
       for (int i = 0; i < brillos.length; i++){
           for (int j = 0; j < brillos[i].length; j++){
               brillos[i][j] = generador.nextInt(11);
           }
       }
       
       return brillos;
    }

    /**
     * @param  un array bidimensional brillos 
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posición f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public static boolean[][] detectarEstrellas(int[][] brillos) {
       boolean[][] detector;
       detector = new boolean[brillos.length][brillos[0].length];
       
       for (int f = 1; f < detector.length - 1; f++){
           for (int  c = 1; c < detector[f].length - 1; c++){
               if((brillos[f-1][c] + brillos[f][c-1] 
                  + brillos[f+1][c] + brillos[f][c+1]) > 30){
                      detector[f][c] = true;
                  }else{
                      detector[f][c] = false;
                  }
           }
       }
       
       return detector;
    }

}

