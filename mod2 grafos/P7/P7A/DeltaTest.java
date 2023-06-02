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

        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v0);
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6); 
        ciudades.agregarVertice(v7); 

        ciudades.conectar(v0, v1, 1);//adyacentes a MP
        ciudades.conectar(v1, v0, 1);
        ciudades.conectar(v0, v2, 1);
        ciudades.conectar(v2, v0, 1);
        ciudades.conectar(v0, v3, 1);
        ciudades.conectar(v3, v0, 1);
        ciudades.conectar(v0, v4, 1);
        ciudades.conectar(v4, v0, 1);


        ciudades.conectar(v1, v2, 1);//rama derecha
        ciudades.conectar(v2, v1, 1);
        ciudades.conectar(v2, v3, 1);
        ciudades.conectar(v3, v2, 1);
        ciudades.conectar(v1, v3, 1);
        ciudades.conectar(v3, v1, 1);

        ciudades.conectar(v4, v5, 1);//rama izquierda
        ciudades.conectar(v5, v4, 1);
        ciudades.conectar(v4, v6, 1);
        ciudades.conectar(v6, v4, 1);
        ciudades.conectar(v5, v6, 1);
        ciudades.conectar(v6, v5, 1);
        ciudades.conectar(v5, v7, 1);
        ciudades.conectar(v7, v5, 1);

        Delta<String> d = new Delta<String>();
        System.out.println("La cantidad maxima de islas a visitar con 1 boleto es de: "+d.maxIslasDistintas(ciudades));

    }
}
