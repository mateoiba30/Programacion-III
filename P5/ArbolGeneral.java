public class ArbolGeneral<T> {//arbol con lista de hijos, cant de hijos indefinida

	private T dato;//es la raíz

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	//ArbolGeneral() inicializa con la raíz null

	public ArbolGeneral(){

	}

	public ArbolGeneral(T dato) {//le llega la raíz
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {//lista de
		// árboles generales
		this(dato);//guardo los datos de los nodos, no los nodos en sí
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {//lista de los hijos de la raíz
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

	public int altura() {
	    ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol_aux;
    	ListaGenerica<ArbolGeneral<T>> hijos =new ListaGenericaEnlazada<ArbolGeneral<T>>();
		int niveles=0;

		if(this.esHoja())
			return 0;

		hijos=this.getHijos();
	    cola.encolar(this);
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
			if (arbol_aux.tieneHijos()) {
				hijos=arbol_aux.getHijos();//paso los hijos a la lista
				hijos.comenzar();//empezar a recorrer por el inicio
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());//voy encolando los hijos del actual
				}
				niveles++;//aumento al cambiar de lista

			}
		}

		return niveles;
	   }
	   
}