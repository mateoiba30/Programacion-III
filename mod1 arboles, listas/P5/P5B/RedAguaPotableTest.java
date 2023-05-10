import java.util.Scanner;

public class RedAguaPotableTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        RedAguaPotable red1 = new RedAguaPotable();

        float n=500;

        ArbolGeneral<Float> arbol_raiz = new ArbolGeneral<Float>();
        ArbolGeneral<Float> arbol_hijo1 = new ArbolGeneral<Float>();
        ArbolGeneral<Float> arbol_hijo2 = new ArbolGeneral<Float>();
        ArbolGeneral<Float> arbol_hijo3 = new ArbolGeneral<Float>();
        ArbolGeneral<Float> arbol_hijo4 = new ArbolGeneral<Float>();
        arbol_raiz.agregarHijo(arbol_hijo1);
        arbol_hijo1.agregarHijo(arbol_hijo2);
        arbol_hijo1.agregarHijo(arbol_hijo3);
        arbol_hijo1.agregarHijo(arbol_hijo4);
        //      x
        //     /
        //   x -> null
        //  /
        // x  -> x -> x-> null
// 

        red1.recibirConfiguracion(n, arbol_raiz);
        // System.out.println("el ancho maximo del arbol "+red1.getRed().ancho() );
        // System.out.println("altura: "+red1.getRed().altura());
        red1.getRed().imprimirNiveles();
        //el buscar dato no va a andar porque los float no son precisos
        // System.out.println("el arbol tiene a "+x+" en el nivel "+red1.getRed().nivel(x));
        System.out.println(" el minimo caudal es de: "+red1.minimo());
        in.close();
    }
}