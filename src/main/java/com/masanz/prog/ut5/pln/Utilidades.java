package com.masanz.prog.ut5.pln;

public class Utilidades {

    /**
     *  Devuelve una cadena con el número n centrado
     *  en el ancho especificado
     * @param n valor numérico que hay que centrar, ej. 89, 8, 327,...
     * @param ancho tamaño del string que hay que devolver ej. 8
     * @return cadena del tamaño especificado con el valor centrado
     *  Si n = 89 y ancho = 6 devuelve "  89  "
     *  Si n = 89 y ancho = 10 devuelve "    89    "
     *  Si n = 8 y ancho = 6 devuelve "  8   "
     */
    public static String centrarNumero(int n, int ancho)    {
        if (ancho - String.valueOf(n).length() < 2) {
            throw new IllegalArgumentException("Ancho de formato incorrecto");
        }
        int espacios = ancho - String.valueOf(n).length();
        int izquierda = espacios / 2;
        int derecha = espacios / 2 + espacios % 2;
        return String.format("%" + izquierda + "s%s%"  + derecha + "s", 
                        "", String.valueOf(n), "");
    }
}
