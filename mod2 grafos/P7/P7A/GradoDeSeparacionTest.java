public class GradoDeSeparacionTest {
    public static void main(String[] args) {
        Vertice<String> v0 = new VerticeImplListAdy<String>("p0");
        Vertice<String> v1 = new VerticeImplListAdy<String>("p1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("p2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("p3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("p4");
        Vertice<String> v5 = new VerticeImplListAdy<String>("p5");
        Vertice<String> v6 = new VerticeImplListAdy<String>("p6");
        Vertice<String> v7 = new VerticeImplListAdy<String>("p7");
        Vertice<String> v8 = new VerticeImplListAdy<String>("p8");
        Vertice<String> v9 = new VerticeImplListAdy<String>("p9");
        Vertice<String> v10 = new VerticeImplListAdy<String>("p10");
        
        Grafo<String> g = new GrafoImplListAdy<String>();
        g.agregarVertice(v0);
        g.agregarVertice(v1);
        g.agregarVertice(v2);
        g.agregarVertice(v3);
        g.agregarVertice(v4);
        g.agregarVertice(v5);
        g.agregarVertice(v6);
        g.agregarVertice(v7);
        g.agregarVertice(v8);
        g.agregarVertice(v9);
        // g.agregarVertice(v10); //si lo comento el grado es 2, sino es 3

        g.conectar(v0, v1, 1);
        g.conectar(v1, v0, 1);

        g.conectar(v0, v2, 1);
        g.conectar(v2, v0, 1);

        g.conectar(v0, v3, 1);
        g.conectar(v3, v0, 1);

        g.conectar(v0, v9, 1);
        g.conectar(v9, v0, 1);

        g.conectar(v1, v4, 1);
        g.conectar(v4, v1, 1);

        g.conectar(v1, v5, 1);
        g.conectar(v5, v1, 1);

        g.conectar(v2, v5, 1);
        g.conectar(v5, v2, 1);

        g.conectar(v2, v6, 1);
        g.conectar(v6, v2, 1);

        g.conectar(v2, v7, 1);
        g.conectar(v7, v2, 1);

        g.conectar(v3, v7, 1);
        g.conectar(v7, v3, 1);

        g.conectar(v3, v8, 1);
        g.conectar(v8, v3, 1);

        g.conectar(v3, v9, 1);
        g.conectar(v9, v3, 1);

        //si comento esta conexion, el grado debe ser cero
        // g.conectar(v6, v10, 1);
        // g.conectar(v10, v6, 1);

        GradoDeSeparacion aux = new GradoDeSeparacion();
        System.out.println("El grado de separacion maximo es: " + aux.maximoGradoDeSeparacion(g));

    }
}
