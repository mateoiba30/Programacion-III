public class Parcial1Test {
    public static void main(String[] args) {
        Ciudad cAux= new Ciudad();
        cAux.setNombre("Buenos Aires");
        cAux.setLimDias(5);
        Vertice<Ciudad> v0 = new VerticeImplListAdy<Ciudad>(cAux);

        Ciudad cAux2= new Ciudad();
        cAux2.setLimDias(6);
        cAux2.setNombre("La Plata");
        Vertice<Ciudad> v1 = new VerticeImplListAdy<Ciudad>(cAux2);

        Ciudad cAux3= new Ciudad();
        cAux3.setNombre("Escobar");
        cAux3.setLimDias(7);
        Vertice<Ciudad> v2 = new VerticeImplListAdy<Ciudad>(cAux3);

        Ciudad cAux4= new Ciudad();
        cAux4.setNombre("Bariloche");
        cAux4.setLimDias(2);
        Vertice<Ciudad> v3 = new VerticeImplListAdy<Ciudad>(cAux4);

        Grafo<Ciudad> ciudades = new GrafoImplListAdy<Ciudad>();
        ciudades.agregarVertice(v0);
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);

        ciudades.conectar(v0, v1, 2);
        ciudades.conectar(v1, v0, 2);

        ciudades.conectar(v1, v2, 3);
        ciudades.conectar(v2, v1, 3);

        ciudades.conectar(v0, v2, 4);
        ciudades.conectar(v0, v2, 4);

        ciudades.conectar(v2, v3, 4);
        ciudades.conectar(v3, v2, 4);

        ciudades.conectar(v1, v3, 4);
        ciudades.conectar(v3, v1, 4);

        parcial1 p = new parcial1();
        System.out.println("maximo tiempo en dias es de: "+p.resolver(ciudades, "Buenos Aires", "La Plata", 4));

    }
}
