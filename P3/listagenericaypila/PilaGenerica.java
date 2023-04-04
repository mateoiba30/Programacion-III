
//voy a guardar los datos en una lista dinámica con datos de cualquier tipo==> listaGenerica enlazada
//el final es a lo que apuntaría el sp
public class PilaGenerica<T> extends ListaGenericaEnlazada<T>{
	
	public PilaGenerica(){//constructor vacio
	}

	
	public void apilar(T elemento) {
		this.agregarFinal(elemento);
	}
	public T desapilar() {
		T elemento;
		int tamano;
		
		tamano=this.tamanio();
		elemento=this.elemento(tamano - 1);
		this.eliminarEn(tamano - 1);//elimino en la ultima pos
		
		return elemento;
	}
	
	public T tope() {
		return this.elemento(this.tamanio() - 1);
	}
	
	public boolean EsVacia() {
		
		return this.esVacia();
	}
	
}

/* FORMA DEL INFA
package prog3.util;

//import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class PilaGenerico<T> {
	
	ListaGenericaEnlazada<T> Datos;
	
	public PilaGenerico(){
		this.Datos = new ListaGenericaEnlazada<T>();
		
	}
	

	public void apilar( T elem) {	
		this.Datos.agregarFinal(elem);
	}

	public T desapilar() {
		int posicion=this.Datos.tamanio()-1;
		T valorDesapilado = this.Datos.elemento(this.Datos.tamanio()-1);
		
		this.Datos.eliminarEn(posicion);
		
		return valorDesapilado;
	}

	public T tope() {
		return this.Datos.elemento((this.Datos.tamanio())-1);
		
	}

	public boolean esVacia() {
		if (this.Datos.esVacia()) {
			return true;
		}
		else {
			return false;
		}
	}
	
		
		


}*/
