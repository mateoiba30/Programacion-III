import java.util.Scanner;
public class TrieTest {    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    ArbolGeneral<Character> arbol_raiz = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo1 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo2 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo3 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo4 = new ArbolGeneral<Character>();

    arbol_raiz.setDato('a');
    arbol_hijo1.setDato('b');
    arbol_hijo2.setDato('c');
    arbol_hijo3.setDato('d');
    arbol_hijo4.setDato('e');

    arbol_raiz.agregarHijo(arbol_hijo1);
    arbol_hijo1.agregarHijo(arbol_hijo2);
    arbol_hijo1.agregarHijo(arbol_hijo3);
    arbol_hijo1.agregarHijo(arbol_hijo4);

    Trie trie1 = new Trie();
    trie1.setArbol(arbol_raiz);

    // arbol_raiz.setHijos(hijos);
    //      a
    //     /
    //   b null
    //  /
    // c  -> d -> e-> null

    trie1.agregarPalabra("mateo");
    arbol_raiz.imprimirNiveles();

    in.close();
}
    
}
