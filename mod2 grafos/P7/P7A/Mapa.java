public class Mapa {

    private Grafo<String> mapaCiudades;
  
    public Grafo<String> getMapaCiudades() {
      return mapaCiudades;
    }
  
    public void setMapa(Grafo<String> mapaCiudades) {
      this.mapaCiudades = mapaCiudades;
    }
  
    public Mapa(Grafo<String> ciudades) {
      this.mapaCiudades = ciudades;
    }

    public Mapa(){

    }
  
    // variacion de recorrido BFS que retorna el camino de ciudad1 a ciudad2
    // en forma de lista enlazada
    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
      if (!this.mapaCiudades.esVacio()) {
        ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];

        for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)//no necesario, por default es todo false
          marca[i] = false;

        Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
        Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);

        // resultado.comenzar();//no necesario porque no lo recorro
        ListaGenerica<String> auxiliar = new ListaGenericaEnlazada<String>();
        devolverCaminoRecursivo(resultado, auxiliar, vIni, marca, vDes);
        return resultado;
      } else
        return null;
    }
  
    private void devolverCaminoRecursivo(ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
      String ciudadActual = vIni.dato();
      marca[vIni.posicion()] = true;
      auxiliar.agregarFinal(ciudadActual);
  
      if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
        copiarLista(resultado, auxiliar);
        return;
      }
  
      ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
      while ((!adyacentes.fin()) && (resultado.esVacia())) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
        Arista<String> actual = adyacentes.proximo();
        if (!marca[actual.verticeDestino().posicion()])
          devolverCaminoRecursivo(resultado, auxiliar, actual.verticeDestino(), marca, vDes);
      }
    }
  
    private void copiarLista(ListaGenerica<String> resultado, ListaGenerica<String> auxiliar) {
      while (!resultado.esVacia())
        resultado.eliminarEn(0);
      auxiliar.comenzar();
      while (!auxiliar.fin())
        resultado.agregarFinal(auxiliar.proximo());
    }
  
    // encuentra el nodo que contiene a ciudad1
    private Vertice<String> obtenerVertice(String ciudad1, Grafo<String> grafo) {//conviene pasar el grafo y no usar la variable de la clase
      Vertice<String> verticeActual = null;
      ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
      int i=0, reps=vertices.tamanio() - 1;

      verticeActual = vertices.elemento(i);
      while(i<reps && !verticeActual.dato().equals(ciudad1)){
        i++;
        verticeActual = vertices.elemento(i);
      }
      return verticeActual;
    }

  }