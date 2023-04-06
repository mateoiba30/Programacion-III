
/**
 * La clase ListaGenericaEnlazada es una ListaGenerica, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaEnlazadaGenerica  no tiene limite en la cantidad de elementos que se
 * pueden almacenar.
 * */
public class ListaGenericaEnlazada<T> extends ListaGenerica<T> {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoGenerico<T> inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoGenerico<T> actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoGenerico<T> fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	public void comenzar() {
		actual = inicio;
	}

	public T proximo() {
		T elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}
	public boolean fin() {
		return (this.actual == null);
	}

	public T elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoGenerico<T> n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	public boolean agregarEn(T elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoGenerico<T> n = this.inicio;
			NodoGenerico<T> ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	public boolean agregarInicio(T elem) {
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	public boolean agregarFinal(T elem) {
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	public boolean eliminar(T elem) {
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	public boolean incluye(T elem) {
		NodoGenerico<T> n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	public String toString() {
		String str = "";
		NodoGenerico<T> n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	public int tamanio() {
		return this.tamanio;
	}

	public boolean esVacia() {
		return this.tamanio() == 0;
	}
	
//	public ListaGenericaEnlazada<T> invertir(){
//		ListaGenericaEnlazada<T> lista_invertida = new ListaGenericaEnlazada<T> ();
//		int longitud, i;
//		
//		longitud=this.tamanio();
//		this.comenzar();
//		lista_invertida.comenzar();
//		
//		for(i=0; i<longitud; i++) {
//			lista_invertida.agregarInicio(this.proximo());
//		}
//		
//		return lista_invertida;
//	}
	
	public ListaGenericaEnlazada<T> invertir() {//lo pongo afuera del programa recursivo para que no lo llame más de una vez
		ListaGenericaEnlazada<T> lista_invertida = new ListaGenericaEnlazada<T>();
		this.comenzar();
		lista_invertida.comenzar();
		this.imprimir_lista_inversa(lista_invertida);
		return lista_invertida;
	}

	public void imprimir_lista_inversa (ListaGenericaEnlazada<T> lista_invertida) {
	//hay que recorrer tantos elementos como cant de ellos tenga la lista this
		T aux=null;
		if(!this.fin()) {
			aux=this.proximo();
			imprimir_lista_inversa(lista_invertida);
			lista_invertida.agregarFinal(aux);
		}
			
	}
}
