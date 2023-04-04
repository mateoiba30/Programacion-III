import java.util.Scanner;
public class PruebaRetorno {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PunteroDouble max = new PunteroDouble();
        PunteroDouble min = new PunteroDouble();
        PunteroDouble prom = new PunteroDouble();
        int dimf = 5;

        min.setValor(9999);
        max.setValor(-9999);
        prom.setValor(0);

        int[] vector = new int[dimf];
        vector[0] = 10;
        vector[1] = 20;
        vector[2] = 30;
        vector[3] = 40;
        vector[4] = 1;

        procesarArreglo(vector, max, min, prom, dimf);
        System.out.println("maximo: " + max.getValor() + " minimo: " + min.getValor() + " promedio: " + prom.getValor());
        in.close();
    }

    public static void procesarArreglo(int[] vector, PunteroDouble max, PunteroDouble min, PunteroDouble prom, int dimf){
        min.setValor(vector[0]);
        max.setValor(vector[0]);
        for (int i: vector){
            prom.setValor(prom.getValor() + i);

            if(i>= max.getValor())
                max.setValor(i);
            else if (i <= min.getValor())
                min.setValor(i);//si siempre ingresa el mismo valor, la 1ra vez lo debo cargar en minio y max

        }
        prom.setValor(prom.getValor()/dimf);

    }
}