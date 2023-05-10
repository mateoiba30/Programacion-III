
public class TestOrdenamientos {

	public static void main(String[] args) {
		
		ListaDeEnterosEnlazada lista1= new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista2= new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista3= new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista4= new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada lista5= new ListaDeEnterosEnlazada();
		
		lista2.agregarFinal(5);
		lista2.agregarFinal(3);
		lista2.agregarFinal(8);
		lista2.agregarFinal(0);
		lista2.agregarFinal(10);
		
		lista3.agregarFinal(7);
		lista3.agregarFinal(9);
		lista3.agregarFinal(11);
		
		lista1=lista2.ordenar();	
		//System.out.println(lista1.toString()); prueba ej 2
		
		
		lista4=lista1.combinarOrdenado(lista3);//lista 1 y 3 son ordenadas, y se van a guardar en lista 4
		//System.out.println(lista4.toString()); 
		
		System.out.println("lista 2=  "+lista2.toString());
		lista5=lista2.mergeSort();
		System.out.println("lista 5=  "+lista5.toString()); 
		
	}
}
