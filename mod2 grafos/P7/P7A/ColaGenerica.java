
public class ColaGenerica<T> extends ListaGenericaEnlazada<T> {

	public ColaGenerica(){//constructor vacio
	}

	
	public void encolar(T elemento) {//encolo al final
		this.agregarFinal(elemento);
	}
	
	public T desencolar() {//elimino el 1ro
		T elemento;
		
		elemento=this.elemento(0);
		this.eliminarEn(0);//elimino en la 1er pos, ya me actualiza al siguiente y disminuye el tamanio
		
		return elemento;
	}
	//version del infa que creo que esta mal
	// public T desencolar () {
		
	// 	T elemDesencolado = this.elemento(this.tamanio()-1);
	// 	this.eliminarEn(this.tamanio()-1);
	// 	return elemDesencolado;
	
	// }
	
	public T tope() {
		return this.elemento(this.tamanio() - 1);
	}
	
	public boolean EsVacia() {
		
		return this.esVacia();
	}
}
