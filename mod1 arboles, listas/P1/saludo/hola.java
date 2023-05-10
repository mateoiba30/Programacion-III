import java.util.Scanner;
public class hola {
    public static void main (String[] args){// necesito poner el String[] args
        Scanner in = new Scanner(System.in); //no olvidar
        String nombre, apellido;

        System.out.println("Ingrese su nombre: ");
        nombre=in.next();
        System.out.println("Ingrese su apellido: ");
        apellido=in.next();

        System.out.println("Hola "+nombre+" "+apellido+"!!");


        in.close();
    }
    
}