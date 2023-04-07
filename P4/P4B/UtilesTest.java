public class UtilesTest {
	public static void main(String[] args) {
        ArbolBinario<Integer> arbolBinarioA=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdo=new ArbolBinario<Integer>(2);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerecho=new ArbolBinario<Integer>(5);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(7));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

        utiles ut = new utiles();
        // int cont=0;
        // cont=ut.sumaMaximaVertical(arbolBinarioA);
        // System.out.println("suma vertical maxima: "+cont);
		// cont=ut.sumaHorizontalMax(arbolBinarioA);

        ListaGenericaEnlazada<Integer> lista_trayectoria = new ListaGenericaEnlazada<Integer>();
		lista_trayectoria=ut.trayectoriaPesada(arbolBinarioA);
		System.out.println("trayecorias pesadas: "+lista_trayectoria.toString());


    }
}
