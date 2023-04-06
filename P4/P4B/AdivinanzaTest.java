public class AdivinanzaTest {
    public static void main(String[] args) {
        Adivinanza ad = new Adivinanza();
		ListaGenericaEnlazada<String> lista_max = new ListaGenericaEnlazada<String>();

        ArbolBinario<String> arbolBinarioA=new ArbolBinario<String>("1");		
		ArbolBinario<String> hijoIzquierdo=new ArbolBinario<String>("2");
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<String>("3"));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<String>("4"));		
		ArbolBinario<String> hijoDerecho=new ArbolBinario<String>("5");
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<String>("6"));
		// hijoDerecho.agregarHijoDerecho(new ArbolBinario<String>("7"));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

        lista_max=ad.secuenciaConMasPreguntas(arbolBinarioA);
		System.out.println("secuencia mas larga: "+lista_max.toString());
    }
}
