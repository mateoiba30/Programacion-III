
//de las estructuras realizadas en la practica 3, me sirve la pila generica o la lista generica
//la mejor sería la pila generica ya que tiene todas las funciones de la lista generica y mas todavia

public class VerificarBalanceado {//recibe un srting y se fija si esta balancedo

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = new String();
		
		cadena="{[]())";
		System.out.println("cadena "+cadena+" balanceada=  "+CadenaBalanceada(cadena));
	}

	public static boolean CadenaBalanceada (String cadena) {
		PilaGenerica<Character> pila_caracteres = new PilaGenerica<Character>();
		int tamanio;
		tamanio=cadena.length();
		boolean result=true;

		if(tamanio%2 ==0){//si no es par no hay chance de que este balanceado
			int  i;
			char car_act;
			
			i=0;
			while((i<tamanio) && (result=true)){//opero la misma cant de veces que elementos tenga
				car_act=cadena.charAt(i);
				//System.out.println(car_act); pa debugear
				
				if( (car_act=='{') || (car_act=='[') || (car_act=='(') ){
					pila_caracteres.apilar(car_act);
				}
				else {//asumo que solo llegan caracteres del tipo [{()]}
					if(pila_caracteres.EsVacia())
						result=false;
					else {
						switch (car_act) {
							case('}'):
								if (pila_caracteres.tope()=='{')
									pila_caracteres.desapilar(); 
								else
									result=false;
								break;
							case(']'): 
								if (pila_caracteres.tope()=='[') 
									pila_caracteres.desapilar();
								else
									result=false;
								break;
							case(')'): 
								if (pila_caracteres.tope()=='(') 
									pila_caracteres.desapilar();
								else
									result=false;
								break;
						}
					}
				}
				
				i++;
			}
			
		}	
		else
			result=false;
		
		if(!pila_caracteres.EsVacia())
			result=false;
		return result;
	}
}
/* VERSION DEL INFA

package prog3.util;
import prog3.listagenerica.*;
public class VerificarBalanceo {

	public static void main(String[] args) {
		 String cadena1 = "{( ) [ ( ) ] }";
	        String cadena2 = "( [ ) ]";
	        
	        System.out.println("La cadena \"" + cadena1 + "\" está balanceada? " + estaBalanceado(cadena1));
	        System.out.println("La cadena \"" + cadena2 + "\" está balanceada? " + estaBalanceado(cadena2));

	}
	
	public static boolean estaBalanceado(String cadena) {
	    ListaGenerica<Character> pila = new ListaGenericaEnlazada<Character>();
	    
	    for (int i = 0; i < cadena.length(); i++) {
	        char caracter = cadena.charAt(i);
	        
	        if (caracter == '(' || caracter == '[' || caracter == '{') {
	            pila.agregarFinal(caracter);
	        } else if (caracter == ')' || caracter == ']' || caracter == '}') {
	            if (pila.esVacia()) {
	                return false;
	            }
	            char tope = pila.elemento(pila.tamanio()-1);
	            if ((caracter == ')' && tope == '(') ||
	                (caracter == ']' && tope == '[') ||
	                (caracter == '}' && tope == '{')) {
	                pila.eliminarEn(pila.tamanio()-1);
	            } else {
	                return false;
	            }
	        }
	    }
	    
	    return pila.esVacia();
	}

}

*/