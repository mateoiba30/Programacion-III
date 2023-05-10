public class GematriaTest {
    public static void main (String[] args){
        ArbolGeneral<Integer> arbol_raiz = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo1 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo2 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo3 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo4 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo5 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo6 = new ArbolGeneral<Integer>();

        arbol_raiz.setDato(1);
        arbol_hijo1.setDato(2);
        arbol_hijo2.setDato(3);
        arbol_hijo3.setDato(4);
        arbol_hijo4.setDato(5);
        arbol_hijo5.setDato(8);
        arbol_hijo6.setDato(9);

        // arbol_raiz.setHijos(hijos);
        //      1
        //     /
        //   2 -> 8 -> null
        //  /     / 9
        // 3  -> 4 -> 5-> null
        arbol_raiz.agregarHijo(arbol_hijo1);
        arbol_hijo1.agregarHijo(arbol_hijo2);
        arbol_hijo1.agregarHijo(arbol_hijo3);
        arbol_hijo1.agregarHijo(arbol_hijo4);
        arbol_raiz.agregarHijo(arbol_hijo5);//puedo cargar de la otra manera que está comentada tmb
        arbol_hijo5.agregarHijo(arbol_hijo6);


        Gematria g=new Gematria();
        System.out.println(g.contar(arbol_raiz, 6));
    }
    
}
