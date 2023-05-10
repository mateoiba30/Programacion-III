public class IteradorABv2{//son de instancia

    public static void main(String[] args) {

        IteradorABv2 aux = new IteradorABv2();//para instanciar ya uso el constructor de java
        System.out.println("Arranca iteracion con for...");
        aux.iteracionConFor(2,7);
        System.out.println("Arranca iteracion con while...");
        aux.iteracionConWhile(2,7);
        System.out.println("Arranca impresion recursiva...");
        aux.recursivo(2,7);
    }

    public IteradorABv2(){}//no es todavía necesario el constructor porque ya existe un constructor base en java

    public void iteracionConFor(int a, int b){
        int i;
        for (i=a;i<=b;i++){
            System.out.println(i);
        }
    }
    public void iteracionConWhile(int a, int b){
        int i=a;
        while (i<=b){
            System.out.println(i);
            i++;
        }
    }

    public void recursivo(int a, int b){ //le hacemos una modificacion de a>=b y hacemos que b aumente en uno
        if (a>=b){
            System.out.println(b+" ");
            recursivo(a,b+1);
        }
    }
}