import java.util.Scanner;//importantisimo
public class Multiplos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //no olvidar
        int n;
        int [] vector;

        System.out.println("inicie un numero para ver sus multiplos");
        n=in.nextInt();
        vector=getMultiplos(n);

        for(int j=1; j<=n; j++){
            System.out.println(vector[j]+" ");
        }

        in.close();
    }
    public Multiplos(){}
 
     public static int[] getMultiplos (int n){
        int i,multiplo;
        int [] vector= new int[n];
        for (i=0;i<n;i++) {
            multiplo=(n*(i+1));
            vector[i]=multiplo;
        }
 
        return vector;
        }
 
 
     }