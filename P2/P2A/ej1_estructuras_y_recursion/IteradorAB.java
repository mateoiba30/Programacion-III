public class IteradorAB {//son metodos de clase
    public static void main(String[] args) {
        System.out.println("Arranca iteracion con for...");
        iteracionConFor(2,7);
        System.out.println("Arranca iteracion con while...");
        iteracionConWhile(2,7);
        System.out.println("Arranca impresion recursiva...");
        recursivo(2,7);
    }
    public static void iteracionConFor(int a, int b){
        int i;
        for (i=a;i<=b;i++){
            System.out.println(i);
        }
    }
    public static void iteracionConWhile(int a, int b){
        int i=a;
        while (i<=b){
            System.out.println(i);
            i++;
        }
    }
    public static void recursivo(int a, int b){
        if (a<=b){
            System.out.println(a +" ");
            recursivo(a+1,b);
        }
    }
}

