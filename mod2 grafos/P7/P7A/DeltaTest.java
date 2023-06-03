public class DeltaTest {
    
    public static void main(String[] args) {
        Vertice<String> v0 = new VerticeImplListAdy<String>("Muelle Principal");
        Vertice<String> v1 = new VerticeImplListAdy<String>("isla 1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("isla 2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("isla 3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("isla 4");
        Vertice<String> v5 = new VerticeImplListAdy<String>("isla 5");  
        Vertice<String> v6 = new VerticeImplListAdy<String>("isla 6");  
        Vertice<String> v7 = new VerticeImplListAdy<String>("isla 7");  

        Grafo<String> islas = new GrafoImplListAdy<String>();
       islas.agregarVertice(v0);
       islas.agregarVertice(v1);
       islas.agregarVertice(v2);
       islas.agregarVertice(v3);
       islas.agregarVertice(v4);
       islas.agregarVertice(v5);
       islas.agregarVertice(v6); 
       islas.agregarVertice(v7); 

       islas.conectar(v0, v1, 1);//adyacentes a MP
       islas.conectar(v1, v0, 1);
       islas.conectar(v0, v2, 1);
       islas.conectar(v2, v0, 1);
       islas.conectar(v0, v3, 1);
       islas.conectar(v3, v0, 1);
       islas.conectar(v0, v4, 1);
       islas.conectar(v4, v0, 1);


       islas.conectar(v1, v2, 1);//rama derecha
       islas.conectar(v2, v1, 1);
       islas.conectar(v2, v3, 1);
       islas.conectar(v3, v2, 1);
       islas.conectar(v1, v3, 1);
       islas.conectar(v3, v1, 1);

       islas.conectar(v4, v5, 1);//rama izquierda
       islas.conectar(v5, v4, 1);
       islas.conectar(v4, v6, 1);
       islas.conectar(v6, v4, 1);
       islas.conectar(v5, v6, 1);
       islas.conectar(v6, v5, 1);
       islas.conectar(v5, v7, 1);
       islas.conectar(v7, v5, 1);

        Delta<String> d = new Delta<String>();
        // System.out.println("La cantidad maxima de islas a visitar con 1 boleto es de: "+d.maxIslasDistintas(islas));
        RutaMinima rutaMinima = new RutaMinima();
        rutaMinima=d.caminoMasCorto(islas, "isla 4", "isla 1");
        if(rutaMinima!=null)
            System.out.println("con "+rutaMinima.getBoletos()+" boletos, camino mas corto: "+rutaMinima.getRuta().toString());

    }
}
