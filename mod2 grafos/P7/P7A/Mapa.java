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
      ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();

        if (!this.mapaCiudades.esVacio()) {
            boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
            
            for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)//no necesario, por default es todo false
            marca[i] = false;

            Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
            Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);

            devolverCaminoRecursivo(resultado, vIni, marca, vDes);

            // if (!resultado.elemento(resultado.tamanio()-1).equals(ciudad2))
            //     resultado= null;
            // return resultado;
        }
        // return null;
        return resultado;

    }
  
    private void devolverCaminoRecursivo(ListaGenerica<String> resultado, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
        String ciudadActual = vIni.dato();
        marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado

        if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
            resultado.agregarInicio(ciudadActual);
        }
        else{
            ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
            while ((!adyacentes.fin()) && (resultado.esVacia())) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
                Arista<String> actual = adyacentes.proximo();
                if (!marca[actual.verticeDestino().posicion()])
                    devolverCaminoRecursivo(resultado, actual.verticeDestino(), marca, vDes);
                if(!resultado.esVacia())
                    resultado.agregarInicio(ciudadActual);
            }
        }
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

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudadesExc) {
      ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();

        if (!this.mapaCiudades.esVacio()) {
            boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
            Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
            Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
            ciudadesExc.comenzar();
            devolverCaminoExceptuandoRecursivo(resultado, vIni, marca, vDes, ciudadesExc);
        }
        return resultado;
    }

    private void devolverCaminoExceptuandoRecursivo(ListaGenerica<String> resultado, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes, ListaGenerica<String> ciudadesExc) {
      int terminar=0;
      ciudadesExc.comenzar();//no olvidar porque me quedo en el fin de ella
      while(!ciudadesExc.fin() && terminar==0){
        if(vIni.dato().equals(ciudadesExc.proximo()))
          terminar=1;
      }
      if(terminar==0){
        String ciudadActual = vIni.dato();
        marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado

        if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
            resultado.agregarInicio(ciudadActual);
        }
        else{
            ListaGenerica<Arista<String>> adyacentes = mapaCiudades.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
            while ((!adyacentes.fin()) && (resultado.esVacia())) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
                Arista<String> actual = adyacentes.proximo();
                if (!marca[actual.verticeDestino().posicion()])
                    devolverCaminoExceptuandoRecursivo(resultado, actual.verticeDestino(), marca, vDes, ciudadesExc);
                if(!resultado.esVacia())
                    resultado.agregarInicio(ciudadActual);
            }
      }
    }
  }
}