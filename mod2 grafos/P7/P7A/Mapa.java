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

    private void copiarLista(ListaGenerica<String> resultado, ListaGenerica<String> auxiliar) {
      resultado.comenzar();
      while (!resultado.esVacia())
        resultado.eliminarEn(0);
      auxiliar.comenzar();
      while (!auxiliar.fin())
        resultado.agregarFinal(auxiliar.proximo());
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

            devolverCaminoRecursivo(mapaCiudades, resultado, vIni, marca, vDes);
        }
        int j=resultado.tamanio()-1;//tal vez el dato no se encontro, pero la lista tiene elementos. O la lista es vacia
        if(j>=0 && resultado.elemento(j).equals(ciudad2))//tal vez solo tenga agregado el destino de la ciudad1
          return resultado;
        else
          return null;

    }
  
    private void devolverCaminoRecursivo(Grafo<String> grafo, ListaGenerica<String> resultado, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
        String ciudadActual = vIni.dato();
        marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado

        if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
            resultado.agregarInicio(ciudadActual);
        }
        else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
            while ((!adyacentes.fin()) && (resultado.esVacia())) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
                Arista<String> actual = adyacentes.proximo();
                if (!marca[actual.verticeDestino().posicion()])
                    devolverCaminoRecursivo(grafo, resultado, actual.verticeDestino(), marca, vDes);
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
            devolverCaminoExceptuandoRecursivo(mapaCiudades, resultado, vIni, marca, vDes, ciudadesExc);
        }

        //porque preguntar por j>=0 no es lo mismo que preguntar si es null?
        int j=resultado.tamanio()-1;//tal vez el dato no se encontro, pero la lista tiene elementos. O la lista es vacia
        if(/*resultado!=null*/j>=0 && resultado.elemento(j).equals(ciudad2))//tal vez solo tenga agregado el destino de la ciudad1
          return resultado;
        else
          return null;
    }

    private void devolverCaminoExceptuandoRecursivo(Grafo<String> grafo, ListaGenerica<String> resultado, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes, ListaGenerica<String> ciudadesExc) {
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
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
            while ((!adyacentes.fin()) && (resultado.esVacia())) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
                Arista<String> actual = adyacentes.proximo();
                if (!marca[actual.verticeDestino().posicion()])
                    devolverCaminoExceptuandoRecursivo(grafo, resultado, actual.verticeDestino(), marca, vDes, ciudadesExc);
                if(!resultado.esVacia())
                    resultado.agregarInicio(ciudadActual);
            }
      }
    }
  }

  public ListaGenerica<String> devolverCaminoCorto(String ciudad1, String ciudad2) {
    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();
    Peso pesoActual= new Peso();
    Peso pesoMinimo= new Peso();
    pesoMinimo.setDato(9999);

      if (!this.mapaCiudades.esVacio()) {
          boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
          Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
          Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
          devolverCaminoCortoRecursivo(mapaCiudades, pesoActual, pesoMinimo, resultado, actual, vIni, marca, vDes);
      }
      // resultado.agregarInicio(ciudad1);//AL FINAL NO ES NECESARIO//lo hago al final, porque el valor de resultado se va actualizando con otros caminos
      
      int j=resultado.tamanio()-1;//tal vez el dato no se encontro, pero la lista tiene elementos. O la lista es vacia
      if(j>=0 && resultado.elemento(j).equals(ciudad2))//tal vez solo tenga agregado el destino de la ciudad1
        return resultado;
      else
        return null;

  }

  private void devolverCaminoCortoRecursivo(Grafo<String> grafo, Peso pesoActual, Peso pesoMinimo, ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
    String ciudadActual = vIni.dato();
    marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
    auxiliar.agregarFinal(ciudadActual);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo

    if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
      if(pesoActual.getDato()<pesoMinimo.getDato())  {
        copiarLista(resultado, auxiliar);
        pesoMinimo.setDato(pesoActual.getDato());
        pesoActual.setDato(0);
      }
    }
    else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
        while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
            Arista<String> actual = adyacentes.proximo();
            int pos=actual.verticeDestino().posicion();
            if (!marca[pos]){
                pesoActual.setDato(pesoActual.getDato()+actual.peso());
                devolverCaminoCortoRecursivo(grafo, pesoActual, pesoMinimo, resultado, auxiliar, actual.verticeDestino(), marca, vDes);
            }
            if(auxiliar.tamanio()>1)//no quiero eliminar el origen de la lista en caso de tener que borrarla
              auxiliar.eliminarEn(auxiliar.tamanio()-1);//estas 3 instrucciones son necesarias para ir por otros caminos
            // Lactual.eliminarEn(actual.tamanio()-1);//no necesaria porque no calculo el peso con ella
            pesoActual.setDato(0); //necesario cuando tengo 2 listas de camino, que devo reiniciar
            marca[pos]=false;
        }
    }//cuando tengo que recorrer varios caminos, debo desmarcar el vector para poder volver a pasar por ahí
  }

  public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int combustible) {
    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();
    Peso pesoActual= new Peso();

      if (!this.mapaCiudades.esVacio()) {
          boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
          Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
          Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
          caminoSinCargarCombustibleRecursivo(combustible, mapaCiudades, pesoActual, resultado, actual, vIni, marca, vDes);
      }
      // resultado.agregarInicio(ciudad1);//AL FINAL NO ES NECESARIO//lo hago al final, porque el valor de resultado se va actualizando con otros caminos
      
      int j=resultado.tamanio()-1;//tal vez el dato no se encontro, pero la lista tiene elementos. O la lista es vacia
      if(j>=0 && resultado.elemento(j).equals(ciudad2))//tal vez solo tenga agregado el destino de la ciudad1
        return resultado;
      else
        return null;

  }

  private void caminoSinCargarCombustibleRecursivo(int combustible, Grafo<String> grafo, Peso pesoActual, ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
    String ciudadActual = vIni.dato();
    marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
    auxiliar.agregarFinal(ciudadActual);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo

    if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
      if(pesoActual.getDato()<=combustible)  {
        copiarLista(resultado, auxiliar);
        pesoActual.setDato(0);
      }
    }
    else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
        while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
            Arista<String> actual = adyacentes.proximo();
            int pos=actual.verticeDestino().posicion();
            if (!marca[pos]){
                pesoActual.setDato(pesoActual.getDato()+actual.peso());
                caminoSinCargarCombustibleRecursivo(combustible, grafo, pesoActual, resultado, auxiliar, actual.verticeDestino(), marca, vDes);
            }
            if(auxiliar.tamanio()>1)//no quiero eliminar el origen de la lista en caso de tener que borrarla
              auxiliar.eliminarEn(auxiliar.tamanio()-1);//estas 3 instrucciones son necesarias para ir por otros caminos
            pesoActual.setDato(0); //necesario para el siguiente camino, que debo reiniciar
            marca[pos]=false;
        }
    }//cuando tengo que recorrer varios caminos, debo desmarcar el vector para poder volver a pasar por ahí
  }
}