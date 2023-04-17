
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

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {//todos los nodos con 2 hijos menos las hojas
		if (this.esHoja())
			return true;//si uso cont++ devuelve su valor original antes de aumentarse, puedo usar 
			//              tmb ++cont;
		else
			if(this.tieneHijoIzquierdo() && this.tieneHijoDerecho()){//analizo en caso de que sea lleno
					return (this.hijoDerecho.esLleno() && this.hijoIzquierdo.esLleno());
					//devuelve true solo si ambos subramas fueron true
			}

		return false;
	}

	 boolean esCompleto() {
		return false;
		//haría un recorrido por niveles (no recursivo) y chequearía que si un nodo no tiene
		// hijo derecho, no haya ningún nodo más a excepcion del hermano izquierdo de este, y si solo
		// le falta hijo izquierdo, me aseguro que no haya nadie más en el nivel
		// en cuanto un nodo no tenga algún hijo, ese debe ser el último nivel
		//tmb puedo mediate un recorrido cualquira obtener la altura y desp´al estar en el recorrido
		//por niveles, al llegar al final chequear de que estén completados de izquierda a derecha
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


    public void recorridoPorNiveles(){
        //iterativo no recursivo
        //la cola debe ser de arboles de, no de los elementos
        //una cola es una lista, que tiene métodos que me facilitan las acciones que busco
        ArbolBinario<T> nodo_act=null;//no olvidar de inicializarlo
        ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();

        cola.encolar(this);//encol raiz
        cola.encolar(null);//paso de nivel

        while(cola.esVacia()==false){
            nodo_act=cola.desencolar();
            if(nodo_act!=null){
                System.out.println(nodo_act.getDato());
                if(nodo_act.tieneHijoIzquierdo())
                    cola.encolar(nodo_act.getHijoIzquierdo());
                if(nodo_act.tieneHijoDerecho())
                    cola.encolar(nodo_act.getHijoDerecho());
            }
            else{
                System.out.println(" // ");
                if (cola.esVacia()==false)
                    cola.encolar(null);//para el salto del inea
            }
		}
    }

	public ListaGenericaEnlazada<T> frontera(){
		ListaGenericaEnlazada<T> l = new ListaGenericaEnlazada<T>();
		l.comenzar();
		frontera_2(l);
		return l;
//hay que inicializar 1 vez, y no cada vez que entro a la recursion
	}

	public void frontera_2(ListaGenerica<T> l) {//uso preorden porque va en orden de hojas de izq a der

		if(this.esHoja()){
		//	System.out.println(this.getDato()+"-"); pa debugear
			l.agregarFinal(this.getDato());//el agregar al final me mantiene el orden
		}
			
		else if(this.getDato()!=null){
			if (this.hijoIzquierdo!=null)
				this.hijoIzquierdo.frontera_2(l);
			if (this.hijoDerecho!=null)
				this.hijoDerecho.frontera_2(l);
			
		}

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