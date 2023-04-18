import java.util.Scanner;
public class TrieTest {    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    ArbolGeneral<Character> arbol_raiz = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo1 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo2 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo3 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo4 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo5 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo6 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo7 = new ArbolGeneral<Character>();
    ArbolGeneral<Character> arbol_hijo8 = new ArbolGeneral<Character>();





    arbol_raiz.setDato('x');
    arbol_hijo1.setDato('a');
    arbol_hijo2.setDato('c');
    arbol_hijo3.setDato('d');
    arbol_hijo4.setDato('e');
    arbol_hijo5.setDato('b');
    arbol_hijo6.setDato('f');
    arbol_hijo7.setDato('g');
    arbol_hijo8.setDato('h');





    arbol_raiz.agregarHijo(arbol_hijo1);
    arbol_raiz.agregarHijo(arbol_hijo5);
    arbol_hijo1.agregarHijo(arbol_hijo2);
    arbol_hijo1.agregarHijo(arbol_hijo3);
    arbol_hijo1.agregarHijo(arbol_hijo4);
    arbol_hijo2.agregarHijo(arbol_hijo6);
    arbol_hijo2.agregarHijo(arbol_hijo7);
    arbol_hijo7.agregarHijo(arbol_hijo8);




    Trie trie1 = new Trie();
    trie1.setArbol(arbol_raiz);

    // arbol_raiz.setHijos(hijos);
    //      x (no cuenta)
    //     /
    //   a -> b
    //  /
    // c  -> d -> e-> null
    // /
    // f -> g
    //     /
    //    h

    // trie1.agregarPalabra("aateo");//falla caundo el dato (que no es el 1ro de la palabra) no se encuentra en el nivel, y el nivel no está vacío
    // arbol_raiz.imprimirNiveles();

    ListaGenerica<ListaGenerica<Character>> lista_palabras = new ListaGenericaEnlazada<ListaGenerica<Character>>();
    lista_palabras=trie1.palabrasQueEmpiezanCon("acg");//pierde todos los caraqcteres del prefijo excepto el último

    System.out.println(lista_palabras.toString());

//    ListaGenerica<ListaGenerica<Character>> prueba = new ListaGenericaEnlazada<ListaGenerica<Character>>();
//     prueba=arbol_raiz.todosLosCaminos();
//     int reps= prueba.tamanio();
//     for(int i=0; i<reps; i++)
//         System.out.println(prueba.elemento(i).toString());
 
    in.close();
}
    
}
