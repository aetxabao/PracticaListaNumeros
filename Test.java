import java.util.Arrays;

public class Test {

    // TODO: DELETE
    public static void main(String[] args) {
        ListaNumeros ln = new ListaNumeros(3);
        ln.addElemento(77);
        ln.addElemento(21);
        ln.addElemento(21);
        ln.escribirLista();
        int[][] brillos = ln.crearBrillos();
        boolean[][] hay = ln.detectarEstrellas(brillos);

    }
}
