
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	ListaGenericaEnlazada<prueba> lista_Integer = new ListaGenericaEnlazada<prueba> ();
	prueba aux = new prueba();
		
		lista_Integer.comenzar();
		aux.setDato(4);
		lista_Integer.agregarFinal(aux);
		System.out.println(lista_Integer.toString());//al mandar una clase que no sea wrapper, me imprime el puntero
		*/
		ListaGenericaEnlazada<Integer> lista_Integer = new ListaGenericaEnlazada<Integer> ();
		ListaGenericaEnlazada<Integer> lista_invertida = new ListaGenericaEnlazada<Integer> ();
		
		lista_Integer.agregarFinal(1);
		lista_Integer.agregarFinal(2);
		lista_Integer.agregarFinal(3);
		
		lista_Integer.comenzar();
		lista_invertida.comenzar();
		
		System.out.println("lista normal=  "+lista_Integer.toString()+" . ");
		lista_invertida=lista_Integer.invertir();	
		System.out.println(". lista invertida=  "+lista_invertida.toString());
		
		
	}

}
