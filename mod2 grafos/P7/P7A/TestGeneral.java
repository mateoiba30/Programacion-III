public class TestGeneral {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("London");
        Vertice<String> v5 = new VerticeImplListAdy<String>("New York");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Madagascar");  
        Vertice<String> v7 = new VerticeImplListAdy<String>("Miameee");  


        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7); 

        ciudades.conectar(v1, v3, 1);
        ciudades.conectar(v1, v2, 2);
        ciudades.conectar(v3, v4, 3);
        ciudades.conectar(v4, v7, 4);
        ciudades.conectar(v2, v6, 5);
        ciudades.conectar(v6, v5, 5);
        ciudades.conectar(v7, v5, 5);
        ciudades.conectar(v5, v3, 0);//para que sea cuadrado en Lima
        // ciudades.conectar(v7, v1, 5);//pa que sea cuadrado en bsas

        ciudades.conectar(v3, v1, 0);//pa que puedan haber mas ciclos

        Algoritmos a = new Algoritmos();
        if(a.subgrafoCuadrado(ciudades)==true)
            System.out.println("Grafo cuadrado\n");
        else
            System.out.println("Grafo NO cuadrado\n");


    }
}
