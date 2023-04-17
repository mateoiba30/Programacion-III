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

	   public boolean include(T elemen){
		boolean result = false;
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol_aux;
    	ListaGenerica<ArbolGeneral<T>> hijos =new ListaGenericaEnlazada<ArbolGeneral<T>>();

		if(this.esHoja())
			return result;

		hijos=this.getHijos();
	    cola.encolar(this);
		while (!cola.esVacia() && result==false) {
			arbol_aux = cola.desencolar();
			if (arbol_aux.getDato()==elemen)
				return true;
			else{
				if (arbol_aux.tieneHijos()) {
					hijos=arbol_aux.getHijos();//paso los hijos a la lista
					hijos.comenzar();//empezar a recorrer por el inicio
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());//voy encolando los hijos del actual
					}
				}

			}
		}

		return result;
	   }

	   public int nivel(T elemen){
		boolean result = false;
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol_aux;
    	ListaGenerica<ArbolGeneral<T>> hijos =new ListaGenericaEnlazada<ArbolGeneral<T>>();
		int niveles=0;

		if(this.esHoja() && this.getDato()==elemen)
			return 0;
		else if(this.esHoja())
			return -1;

		hijos=this.getHijos();
	    cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia() && result==false) {
			arbol_aux = cola.desencolar();
			if (arbol_aux!=null && arbol_aux.getDato()==elemen)
				result=true;
			else{
				if (arbol_aux!=null && arbol_aux.tieneHijos()) {
					hijos=arbol_aux.getHijos();//paso los hijos a la lista
					hijos.comenzar();//empezar a recorrer por el inicio
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());//voy encolando los hijos del actual
					}
					cola.encolar(null);//cambio de nivel
				}
				else
					niveles++;//si no era la raiz incremento el nivel
			}
		}
		if (result==false)//puede no haberlo encontrado
			niveles=-1;

		return niveles;
	   }
// NIVEL VERSION INFA
	//    public Integer nivel(T dato) {
	// 	ArbolGeneral<T> elem;
	// 	int niveles=0;
		
	// 		if (this.dato.equals(dato)){
	// 			return niveles;
	// 		}
	// 		if (!this.equals(dato) && this.esHoja()){
	// 			return -1;
	// 		}
	

	// 	ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
 	// 	ArbolGeneral<T> arbol_aux;
	// 	cola.encolar(this);
 	// 	while (!cola.esVacia()) {
	// 	arbol_aux = cola.desencolar();
 	// 	if (arbol_aux.tieneHijos()) {
 	// 	ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
 	// 	hijos.comenzar();
	// 	niveles++;
 	// 		while (!hijos.fin()) {
	// 			elem=hijos.proximo(); //guardo el elemento de hijos en elem ya que hijos apunta a lo que viene
	// 			if (elem.dato.equals(dato)){
	// 				return niveles;

	// 			}
	// 			cola.encolar(elem);
	// 		 }
		
	//  	}

	//  }

	// 	return -1;
	// }
	   public int ancho(){
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol_aux;
    	ListaGenerica<ArbolGeneral<T>> hijos =new ListaGenericaEnlazada<ArbolGeneral<T>>();
		int ancho_max=-1, ancho_act=0;

		if(this.esHoja())
			return 1;

		hijos=this.getHijos();
	    cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
	
			if (arbol_aux!=null && arbol_aux.tieneHijos()) {
				hijos=arbol_aux.getHijos();//paso los hijos a la lista
				hijos.comenzar();//empezar a recorrer por el inicio
				ancho_act=0;
				while (!hijos.fin()) {
					ancho_act++;
					cola.encolar(hijos.proximo());//voy encolando los hijos del actual
				}
			//	System.out.println("ancho actual: "+ancho_act);
				cola.encolar(null);//cambio de nivel
				if(ancho_act>=ancho_max)
					ancho_max=ancho_act;
			}
			
		}
		
		return ancho_max;
	   }

	// PORQUÉ ESTÁ MAL?    
	//    public void imprimirNiveles(){
	// 	ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
	// 	ArbolGeneral<T> arbol_aux  = new ArbolGeneral<T>();
	// 	ListaGenerica<ArbolGeneral<T>> hijos =new ListaGenericaEnlazada<ArbolGeneral<T>>();
	
	// 	if(this.esHoja())
	// 		System.out.println(this.getDato());
	// 	else{
	// 		hijos=this.getHijos();
	// 		cola.encolar(this);
	// 		cola.encolar(null);
	
	// 		while (!cola.esVacia()) {
	// 			arbol_aux = cola.desencolar();
	// 			if(arbol_aux!=null)
	// 				System.out.print(arbol_aux.getDato()+" ");
	// 			else
	// 				System.out.println();//leí null, cambié de nivel

	// 			if (arbol_aux!=null && arbol_aux.tieneHijos()) {//encolo hijos y null
	// 				hijos=arbol_aux.getHijos();
	// 				hijos.comenzar();
	// 				while (!hijos.fin()) {
	// 					cola.encolar(hijos.proximo());//voy encolando los hijos del actual
	// 				}
	// 				// if(!cola.esVacia())
	// 				cola.encolar(null);//cambio de nivel al terminar de cargar los hijos
	// 			}
	// 		}
	// }

}
	public void ImprimirPorNiveles() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> ar;
		cola.encolar(this);
		cola.encolar(null);

		while (!cola.esVacia()) {
			ar = cola.desencolar();
			if (ar != null) {
				System.out.print(ar.getDato() + " ");
				for (int i = 0; i<ar.getHijos().tamanio(); i++) {
					cola.encolar(ar.getHijos().elemento(i));
				}
			}
			else if (!cola.esVacia()) {
				System.out.println();
				cola.encolar(null);
			}
		}
	}
	   

}