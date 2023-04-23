public class ZigZagTest {
    public static void main (String[] args){
        ArbolBinario<Character> arbolBinarioA=new ArbolBinario<Character>();		
		ArbolBinario<Character> hijoIzquierdo=new ArbolBinario<Character>();
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Character>('A'));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Character>('B'));		
		ArbolBinario<Character> hijoDerecho=new ArbolBinario<Character>();
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Character>('C'));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Character>('D'));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

        // arbolBinarioA.recorridoPorNiveles();
        ListaGenerica<String> secuencias= new ListaGenericaEnlazada<String>();
        ListaGenerica<Character> resultado= new ListaGenericaEnlazada<Character>();
        secuencias.agregarFinal("00");
        secuencias.agregarFinal("01");
        secuencias.agregarFinal("10");
        secuencias.agregarFinal("11");


        CodigoZigZag cod = new CodigoZigZag();
        resultado=cod.descifrarCodigo(arbolBinarioA, secuencias);
        System.out.println(resultado.toString());

    }
    
}
