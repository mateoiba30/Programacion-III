
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
			if (this.hijoIzquierdo!=null)
				this.hijoIzquierdo.printPreorden();
			if (this.hijoDerecho!=null)
				this.hijoDerecho.printPreorden();
			
		}
		
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if(this.getDato()!=null){
			if (this.hijoIzquierdo!=null)
				this.hijoIzquierdo.printInorden();
			System.out.println(this.getDato()+"  ");
			if (this.hijoDerecho!=null)
				this.hijoDerecho.printInorden();
		}
		
	}
	
	// imprime el arbol en postorden
	public void printPostorden() {
		if(this.getDato()!=null){	
			if (this.hijoIzquierdo!=null)	
				this.hijoIzquierdo.printPostorden();
			if (this.hijoDerecho!=null)
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

	
	
	
	public int contarHojas(int cont) {

		if (this.esHoja())
			return cont+1;//si uso cont++ devuelve su valor original antes de aumentarse, puedo usar 
			//              tmb ++cont;
		else
			if(this.getDato()!=null){
				if (this.hijoIzquierdo!=null)
					cont=this.hijoIzquierdo.contarHojas(cont);
				if (this.hijoDerecho!=null)
					cont=this.hijoDerecho.contarHojas(cont);
			}

		return cont;
	}

}