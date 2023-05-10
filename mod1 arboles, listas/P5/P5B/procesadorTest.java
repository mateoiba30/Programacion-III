public class procesadorTest {
    public static void main(String[] args){

		ArbolBinario<Character> arbol_null=new ArbolBinario<Character>();		
		ArbolBinario<Character> arbolBinarioB=new ArbolBinario<Character>('1');		
		ArbolBinario<Character> hijoIzquierdoB=new ArbolBinario<Character>('2');
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Character>('3'));
		// hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Character>('4'));		
		ArbolBinario<Character> hijoDerechoB=new ArbolBinario<Character>('5');
		// hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Character>('6'));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Character>('7'));
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

        ProcesadorDeArbol p =new ProcesadorDeArbol();
        p.setArbol(arbolBinarioB);
        System.out.println(p.procesar3(1));
        // arbol_null=arbolBinarioB;
        // arbol_null.getHijoDerecho().setDato('x');
        // arbolBinarioB.printInorden();

		ArbolBinario<Integer> arbolBinarioA=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdo=new ArbolBinario<Integer>(2);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerecho=new ArbolBinario<Integer>(5);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(7));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

		// Procesador p=new Procesador();
		// p.setArbol(arbolBinarioA);
		// ListaGenerica<ArbolBinario<Integer>> lista_arboles = new ListaGenericaEnlazada<ArbolBinario<Integer>>();
		// lista_arboles = p.procesarArbol();
		// System.out.println(lista_arboles.toString());

    }
}
