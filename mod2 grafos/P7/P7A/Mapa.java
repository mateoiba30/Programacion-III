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
        for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)
          marca[i] = false;
        int posicion = obtenerPosicion(ciudad1);
        resultado.comenzar();
        ListaGenerica<String> auxiliar = new ListaGenericaEnlazada<String>();
        devolverCaminoRecursivo(resultado, auxiliar, posicion, marca, ciudad2);
        return resultado;
      } else
        return null;
    }
  
    private void devolverCaminoRecursivo(ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, int posicion,
        boolean[] marca, String destino) {
  
      String ciudadActual = mapaCiudades.vertice(posicion).dato();
      marca[posicion] = true;
      auxiliar.agregarFinal(ciudadActual);
  
      if (ciudadActual == destino) {
        copiarLista(resultado, auxiliar);
        return;
      }
  
      ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(posicion));
      while ((!adyacentes.fin()) && (resultado.esVacia())) {
        Arista<String> actual = adyacentes.proximo();
        if (!marca[actual.verticeDestino().posicion()])
          devolverCaminoRecursivo(resultado, auxiliar, actual.verticeDestino().posicion(), marca, destino);
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
    private int obtenerPosicion(String ciudad1) {
      int i;
      Vertice<String> verticeActual = null;
      ListaGenerica<Vertice<String>> vertices = this.mapaCiudades.listaDeVertices();
      for (i = 0; i < vertices.tamanio() - 1; i++) {
        verticeActual = vertices.elemento(i);
        if (verticeActual.dato() == ciudad1)
          break;
      }
      return verticeActual.posicion();
    }

  }