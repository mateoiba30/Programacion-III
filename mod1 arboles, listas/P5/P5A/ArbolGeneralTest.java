import java.util.Scanner;

public class ArbolGeneralTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArbolGeneral<Integer> arbol_raiz = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo1 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo2 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo3 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo4 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo5 = new ArbolGeneral<Integer>();
        ArbolGeneral<Integer> arbol_hijo6 = new ArbolGeneral<Integer>();



        // ListaGenerica<ArbolGeneral<Integer>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
        // hijos.agregarInicio(arbol_hijo1);
        // hijos.agregarInicio(arbol_hijo2);
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
        // 4  -> 3 -> 5-> null
        arbol_raiz.agregarHijo(arbol_hijo1);
        arbol_hijo1.agregarHijo(arbol_hijo2);
        arbol_hijo1.agregarHijo(arbol_hijo3);
        arbol_hijo1.agregarHijo(arbol_hijo4);
        arbol_raiz.agregarHijo(arbol_hijo5);//puedo cargar de la otra manera que está comentada tmb
        arbol_hijo5.agregarHijo(arbol_hijo6);

        // System.out.println("altura: "+arbol_raiz.altura());3
    //    System.out.println("Ingrese un dato a buscar");
    //    int x=in.nextInt();
    //    System.out.println("el arbol tiene a "+x+" ? "+arbol_raiz.include(x));
        // System.out.println("el arbol tiene a "+x+" en el nivel "+arbol_raiz.nivel(x));
        int aux=arbol_raiz.ancho();
         System.out.println("el ancho maximo del arbol "+aux);



        in.close();
    }
}
