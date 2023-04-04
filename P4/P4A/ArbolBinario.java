
public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		return false;
	}

	 boolean esCompleto() {
		return false;
	}

	
	// imprime el arbol en preorden  
	public void printPreorden() {
		if(this.getDato()!=null){
			System.out.println(this.getDato()+"  ");
			this.hijoIzquierdo.printPreorden();
			this.hijoDerecho.printPreorden();
		}
		
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if(this.getDato()!=null){
			this.hijoIzquierdo.printInorden();
			System.out.println(this.getDato()+"  ");
			this.hijoDerecho.printInorden();
		}
		
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if(this.getDato()!=null){		
			this.hijoIzquierdo.printPostorden();
			this.hijoDerecho.printPostorden();
			System.out.println(this.getDato()+"  ");
		}
		
	}


	public void recorridoPorNiveles() {
		
	}

	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();

		return l;
	}

	
	
	
	public int contarHojas() {

		int contador=0;

		if(this.getDato()!=null){
			System.out.println(this.getDato()+"  ");
			this.hijoIzquierdo.printPreorden();
			this.hijoDerecho.printPreorden();
		}
		else
			contador++;		

		return contador;
	}

}