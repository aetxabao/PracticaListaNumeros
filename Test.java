import java.util.Arrays;

public class Test {

    // TODO: DELETE
    public static void main(String[] args) {
        ListaNumeros ln = new ListaNumeros(2);
        ln.addElemento(9);
        ln.addElemento(9);

        ln.escribirLista();
        System.out.println(ln.segundoMaximo() == Integer.MIN_VALUE);
    }
}
