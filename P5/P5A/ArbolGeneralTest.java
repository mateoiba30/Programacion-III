public class ArbolGeneralTest {
    public static void main(String[] args) {

        ArbolGeneral<Integer> arbol_raiz = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo1 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo2 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo3 = new ArbolGeneral<Integer>();

        // ListaGenerica<ArbolGeneral<Integer>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
        // hijos.agregarInicio(arbol_hijo1);
        // hijos.agregarInicio(arbol_hijo2);
        arbol_raiz.setDato(1);
        arbol_hijo1.setDato(2);
        arbol_hijo2.setDato(3);
        arbol_hijo3.setDato(4);

        // arbol_raiz.setHijos(hijos);
        //      1
        //     /
        //   2 -> 3 -> null
        //  /
        // 4 -> null


        arbol_raiz.agregarHijo(arbol_hijo1);
        arbol_raiz.agregarHijo(arbol_hijo2);
        arbol_raiz.agregarHijo(arbol_hijo3);
        arbol_hijo1.agregarHijo(arbol_hijo3);



        System.out.println("altura: "+arbol_raiz.altura());



    }
}
