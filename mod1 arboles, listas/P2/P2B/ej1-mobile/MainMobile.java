import java.util.Scanner;
public class MainMobile {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in); //no olvidar
        String marca,  modelo, sistemaOperativo;
        double costo;
        int numero, i;
        SmartPhone[] vectorSP= new SmartPhone[2];

        for(i=0; i<2; i++){
            System.out.println("Carga de objeto "+(i+1));
            System.out.println("Ingrese la marca: ");
            marca= in.next();
            System.out.println("Ingrese el modelo: ");
            modelo= in.next();
            System.out.println("Ingrese el sistema operativo: ");
            sistemaOperativo=in.next();
            System.out.println("Ingrese el costo: ");
            costo= in.nextDouble();
            System.out.println("Ingrese el numero: ");
            numero= in.nextInt();

            vectorSP[i]= new SmartPhone(marca, modelo, sistemaOperativo, costo, numero);
        }

        System.out.println("son iguales? "+vectorSP[0].equals(vectorSP[1]));

        System.out.println("Impresion de objetos: ");
        for(i=0; i<2; i++){
            System.out.println(" objeto "+(i+1));
            System.out.println(vectorSP[i].toString());
        }
        in.close();

    }
}