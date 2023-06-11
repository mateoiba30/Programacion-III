public class GuiaDeTurismoTest {
    public static void main(String[] args) {
        Vertice<String> v0 = new VerticeImplListAdy<String>("punto 0");
        Vertice<String> v1 = new VerticeImplListAdy<String>("punto 1");
        Vertice<String> v2 = new VerticeImplListAdy<String>("punto 2");
        Vertice<String> v3 = new VerticeImplListAdy<String>("punto 3");
        Vertice<String> v4 = new VerticeImplListAdy<String>("punto 4");
        Vertice<String> v5 = new VerticeImplListAdy<String>("punto 5");  
        Vertice<String> v6 = new VerticeImplListAdy<String>("punto 6");  
        Vertice<String> v7 = new VerticeImplListAdy<String>("punto aislado");  


        Grafo<String> BsAs = new GrafoImplListAdy<String>();
        BsAs.agregarVertice(v0);
        BsAs.agregarVertice(v1);
        BsAs.agregarVertice(v2);
        BsAs.agregarVertice(v3);
        BsAs.agregarVertice(v4);
        BsAs.agregarVertice(v5);
        BsAs.agregarVertice(v6); 
        BsAs.agregarVertice(v7); 

        
        BsAs.conectar(v0, v1, 30);
        BsAs.conectar(v1, v0, 30);

        BsAs.conectar(v0, v2, 15);
        BsAs.conectar(v2, v0, 15);

        BsAs.conectar(v0, v3, 10);
        BsAs.conectar(v3, v0, 10);

        BsAs.conectar(v1, v3, 25);
        BsAs.conectar(v3, v1, 25);

        BsAs.conectar(v1, v4, 60);
        BsAs.conectar(v4, v1, 60);

        BsAs.conectar(v2, v3, 40);
        BsAs.conectar(v3, v2, 40);

        BsAs.conectar(v2, v5, 20);
        BsAs.conectar(v5, v2, 20);

        BsAs.conectar(v3, v6, 35);
        BsAs.conectar(v6, v3, 35);

        BsAs.conectar(v4, v6, 20);
        BsAs.conectar(v6, v4, 20);

        BsAs.conectar(v5, v6, 30);
        BsAs.conectar(v6, v5, 30);

        ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
        GuiaDeTurismo g = new GuiaDeTurismo();
        resultado= g.caminoConMenorNrodeViajes(BsAs, "punto 0", "punto 3");
        System.out.println("camino: "+resultado.toString());//si no hay nada lo imprime vacío
        // if(resultado!=null)
        //     System.out.println(resultado.toString());
        // else
        //     System.out.println("No hay un viaje posible\n");

    }
}
