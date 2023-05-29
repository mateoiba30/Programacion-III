public class MapaTest {
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

        ciudades.conectar(v1, v3, 3);
        ciudades.conectar(v1, v2, 2);
        ciudades.conectar(v3, v4, 2);
        ciudades.conectar(v4, v7, 1);
        ciudades.conectar(v2, v6, 0);
        ciudades.conectar(v6, v5, 1);
        ciudades.conectar(v7, v5, 0);

        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        Mapa m=new Mapa();
        m.setMapa(ciudades);
        camino=m.devolverCamino("Buenos Aires", "Lima");
        System.out.println("camino: "+camino.toString());

    }
}
