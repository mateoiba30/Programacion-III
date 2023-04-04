public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {

		ListaDeEnterosEnlazada lista1= new ListaDeEnterosEnlazada();
		
		for(int i=0; i<5; i++) {
			lista1.agregarFinal(i);
		}
		
		for(int j=0; j<lista1.tamanio(); j++) {
			System.out.println ("elemento "+(j+1)+" = "+lista1.elemento(j));
		}
		
		comenzarLista (lista1);
		

	}

public static void comenzarLista(ListaDeEnterosEnlazada lista1) {//lo pongo afuera del programa recursivo para que no lo llame más de una vez
	lista1.comenzar();
	imprimir_lista_inversa(lista1);
}

public static void imprimir_lista_inversa (ListaDeEnterosEnlazada lista1) {
//comenzar lista, verificar si llega al final (caso base), SINO GUARDO EL PROXIMO EN UNA VARIABLE Y LLAMA AL
	int aux;
	if(!lista1.fin()) {
		aux=lista1.proximo();
		imprimir_lista_inversa(lista1);
		System.out.println(" "+aux+" ");
	}


}

}
