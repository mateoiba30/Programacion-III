import java.util.Scanner;
public class mainej6v2 {
    public static void main(String[] args) {

        System.out.println("Ingrese un valor en Farenheit");
        Scanner n= new Scanner(System.in); //abro el scanner y lo asocio a una variable
        double valor= n.nextDouble(); // le asigno a valor lo que lei en fn, y a eso lo convierto en double

        calcularCelcius temp = new calcularCelcius(); // calcular temperatura es mi otra clase, la asigno a otra var
        double celcius = temp.calcular_Celcius(valor);//igualo una variable la operacion de mter valor y hacer la funcion que puse

        System.out.println("El valor convertido es: "+ String.format("%.2f", celcius)); //imprimo el valor, no corta, redondea
    }


}