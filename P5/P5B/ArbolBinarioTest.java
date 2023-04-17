
public class ArbolBinarioTest {

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

		// System.out.println("Pre Orden");
		// arbolBinarioA.printPreorden();
		// System.out.println("In Orden");
		// arbolBinarioA.printInorden();
		// System.out.println("Post Orden");
		// arbolBinarioA.printPostorden();

		// int contador=0;
		// contador=arbolBinarioA.contarHojas(contador);
		// System.out.println("cantidad de hojas: "+contador);

		// ListaGenerica<Integer> l = new ListaGenericaEnlazada<Integer>();
		// l=arbolBinarioA.frontera();
		// System.out.println("hojas=  "+l.toString());

		// System.out.println("arbol lleno=  "+arbolBinarioA.esLleno());

		// arbolBinarioA.recorridoPorNiveles();


		ArbolBinario<Character> arbolBinarioB=new ArbolBinario<Character>('1');		
		ArbolBinario<Character> hijoIzquierdoB=new ArbolBinario<Character>('2');
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Character>('3'));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Character>('4'));		
		ArbolBinario<Character> hijoDerechoB=new ArbolBinario<Character>('5');
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Character>('6'));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Character>('7'));
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

		ListaGenerica<Character> caminoLargo = new ListaGenericaEnlazada<Character>();
		caminoLargo = ArbolBinario.caminoMasLargo(arbolBinarioB);//como es static no necesito un objeto, pero aclaro de que clase viene
		
		System.out.println(caminoLargo.toString());
	}

}