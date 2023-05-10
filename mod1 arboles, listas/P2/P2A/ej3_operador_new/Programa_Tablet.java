import java.util.Scanner;
public class Programa_Tablet { //vamos a probar de agregar los valor por teclado aunque diga que sea agregar manual
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);


        String marca,OS,modelo;
        double costo;
        float pulgadas;

       Tablet[] tablet = new Tablet[3];

       int i;
       for (i=0;i<3;i++){
           System.out.println("Ingrese la marca: ");
           marca= in.next();
           System.out.println("Ingrese el OS: ");
           OS= in.next();
           System.out.println("Ingrese el modelo: ");
           modelo= in.next();
           System.out.println("Ingrese el monto: ");
           costo= in.nextDouble();
           System.out.println("Ingrese pulgadas: ");
           pulgadas= in.nextFloat();
           System.out.println("Carga de este dispositivo finalizada. ");
           Tablet tablet_= new Tablet(marca,modelo,OS,costo,pulgadas);
           tablet[i]=tablet_;
       }
       for (i=0;i<3;i++){
           tablet[i].devolverDatos();
       }
       in.close();
    }
}