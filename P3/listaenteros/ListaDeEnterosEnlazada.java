
/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 * */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {//devuelve el elemento actual y avanza al proxiumo elemento
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
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

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
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

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
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

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
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

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
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

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}
	
	public ListaDeEnterosEnlazada ordenar() { 
		// si la lista a ordenar tiene N elementos, entonces en el peor de los casos el mínimo siempre estaba al final
		//, buscando N veces + (N-1) + (N-2) + ... hasta llegar a cero
		//que es (N+1)*(N/2)
		ListaDeEnterosEnlazada copia = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada ordenada= new ListaDeEnterosEnlazada();
		int repeticiones, i, j, k, min, pos_min=0, valor, tamanio_copia;
		repeticiones= this.tamanio();
		tamanio_copia=repeticiones;
		//this.comenzar(); no necesario
		
		for (i=0; i<repeticiones; i++) {
			copia.agregarFinal(this.proximo());
		}
		
		for (j=0; j<repeticiones; j++) {
			copia.comenzar();//necesario
			min=9999;
			for(k=0; k<tamanio_copia; k++){
				valor=copia.proximo();
				if (valor<min) {
					min=valor;	
					pos_min=k;
				}
				
			}
			tamanio_copia--;
			copia.eliminarEn(pos_min);//me pide inicializar pos min en el caso de que nada sea menor a 9999
			ordenada.agregarFinal(min);
		}
		return ordenada;
		
	}
	
public ListaDeEnterosEnlazada combinarOrdenado (ListaDeEnterosEnlazada lista_ordenada) {
	//esta la lista con la que llamo la subrutina, la lista recibida y devuelo una nueva con ambos elementos de manera ordenada
	//en el peor de los casos, el combinar 2 listas ordenadas de tamaño N y M nos hace recorrer la siguiente candidad de nodos: N + M 
	
	ListaDeEnterosEnlazada lista_nueva = new ListaDeEnterosEnlazada();
	int A, B, C;
	
	this.comenzar();
	lista_ordenada.comenzar();
	lista_nueva.comenzar();

	
	//busco 1er elemento de ambas listas
	//comparo el menor e inserto al final de la nueva lista
	//de la lista que saqué debo avanzar al siguiente
	
	while( (!lista_ordenada.fin()) || (!this.fin()) ){//mientras sigan habiendo elementos en alguna

		
		if( (!lista_ordenada.fin()) && (!this.fin()) ) {//si ambas tienen elementos debo comparar
			A=this.actual.getDato();
			B=lista_ordenada.actual.getDato();
			if(A<=B) {
				C=A;
				this.proximo();
			}		
			else {
				C=B;
				lista_ordenada.proximo();
			}
			lista_nueva.agregarFinal(C);	
		}
		else {
			if(lista_ordenada.fin()) {//debo cargar lo que queda en la lista this
				while(!this.fin()) {
					lista_nueva.agregarFinal(this.proximo());
				}
			}
			else {//debo cargar lo que queda en la lista_ordenada
				while(!lista_ordenada.fin()) {
					lista_nueva.agregarFinal(lista_ordenada.proximo());//proximo da el valor actual y avanza en la lista
				}
			}
		}	
	}

	return lista_nueva;
}

public void combinar(ListaDeEnterosEnlazada lista_combinada, ListaDeEnterosEnlazada lista_izq, ListaDeEnterosEnlazada lista_der) {
	//escribo dos listas de las cuales desconosco el tamaño y voy eligiendo elemento por elemento para copmbinarlas en una nueva lista
	//hay dos opciones: ambas listas con igual cantidad de elementos /opcion 2: la lista der tiene un elemento mas
	//puedo ir sacando elementos de cualquiera de las dos
	//el inicio o cualquier elemento puede ser null
	lista_izq.comenzar();// totalmente necesario
	lista_der.comenzar();
	
	while(!lista_der.fin() && !lista_izq.fin()) {
		if(lista_izq.actual.getDato()<=lista_der.actual.getDato()) //puedo usar actual en lugar de inicio porque puse comenzar
			lista_combinada.agregarFinal(lista_izq.proximo());//tmb lista izq queda apuntando al siguiente	
		else //agrego al final pa que queden 1ros lo insertados antes
			lista_combinada.agregarFinal(lista_der.proximo());//tmb lista der queda apuntando al siguiente
	}
	while(!lista_izq.fin())//cargo si quedaron elementos en solo una lista
		lista_combinada.agregarFinal(lista_izq.proximo());//agrego al final porque esa lista ya los tiene ordenados
	while(!lista_der.fin())
		lista_combinada.agregarFinal(lista_der.proximo());	
	
}
public ListaDeEnterosEnlazada mergeSort(){//metodo recursivo, dividiendo, para ordenar la lista
	int longitud;
	longitud=this.tamanio;
	if(longitud<=1) {//CASO BASE si la lista es de 1 elemento no hago nada
		return this;//ya termina esta repeticion porque ya hice el return de una lista que combine su izq y der en orden, ella misma
	}
	
	else{//sinó, a trabajar
		ListaDeEnterosEnlazada lista_izq = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista_der = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista_combinada = new ListaDeEnterosEnlazada();//vamos a inicializar e instanciar las listas
		//lista_izq=this; lista_der=this; no hacemos estop porque modifica nuestra lista principal y jode la recursion

		int pos_medio=0, i;
		pos_medio=longitud/2;//hacer division entera
		this.comenzar();//comenzar al inicio de la lista
		lista_izq.comenzar();
		lista_der.comenzar();
		lista_combinada.comenzar();
		//son totalmente necesarios los comenzar, me aseguro de recorrer en el inicio de las listas
		
		for(i=0; i<pos_medio; i++)//hago que arranque en la primer mitad
			lista_izq.agregarFinal(this.proximo());//uso agregar al final, porque no quiero que la lista deje de apuntar a su 1er elemento
			//al usar this.proximo, ya la hago avanzar a la lista this
		for(i=pos_medio; i<longitud; i++)//hago que arranque en la segunda mitad
			lista_der.agregarFinal(this.proximo());
		
		System.out.println("debug izq "+lista_izq.toString());
		System.out.println("debug der "+lista_der.toString());
			//tanto lista der como izq apuntan a su 1er elemento, mientras que this apunta al final null
		lista_izq=lista_izq.mergeSort();//cada subproblema lo vuelvo a dividir, hasta que queden problemas chicos de 2 elementos y los deba ordenar
		lista_der=lista_der.mergeSort();//lista_der ya es modificada, no cambia nada si la igualo a su llamado a merge
		
		//quedan pendientes los casos donde todavía habían varios elementos y debo combinar
		combinar(lista_combinada, lista_izq, lista_der);//voy eligiendo entre el primer elemento de cada lista			
		return lista_combinada;//debo devolver modificada la lista combinada, que es la mitad de una lista anterior que llamó la subrutina
	}

		
}
}
/* OTRA FORMA DE HACERLO:
 * 
 * public ListaDeEnterosEnlazada combinarOrdenado(ListaDeEnterosEnlazada listaParam) {
		
		ListaDeEnterosEnlazada nuevaLista = new ListaDeEnterosEnlazada();
		int valorInterna=0;
		int valorParam=0;
		this.comenzar();
		listaParam.comenzar();
		
		while (!this.fin() && !listaParam.fin()) {
		
			valorInterna=this.actual.getDato();
			valorParam=listaParam.actual.getDato();
			
			if (valorInterna<valorParam) {
				nuevaLista.agregarFinal(valorInterna);
				this.proximo();
					
				}
				
			else if (valorInterna>valorParam) {
				nuevaLista.agregarFinal(valorParam);
				listaParam.proximo();
			}
				
		
		}
		
		while (!this.fin()) {
			nuevaLista.agregarFinal(this.proximo());
		}
 */