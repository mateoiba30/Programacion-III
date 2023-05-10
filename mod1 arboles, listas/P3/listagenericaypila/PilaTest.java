

public class PilaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PilaGenerica<Character> pila_caracteres = new PilaGenerica<Character>();
		
		pila_caracteres.apilar('a');
		pila_caracteres.apilar('b');
		pila_caracteres.apilar('c');
		pila_caracteres.apilar('d');
		pila_caracteres.apilar('e');
		
		pila_caracteres.desapilar();
		pila_caracteres.desapilar();
		pila_caracteres.desapilar();
		pila_caracteres.desapilar();
		
		System.out.println("tope de pila=  "+pila_caracteres.tope());
	}

}
