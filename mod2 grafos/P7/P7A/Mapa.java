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
      ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();

        if ((mapaCiudades!=null)&&(!mapaCiudades.esVacio())) {
            boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
            
            for (int i = 0; i < mapaCiudades.listaDeVertices().tamanio(); i++)//no necesario, por default es todo false
            marca[i] = false;

            Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
            Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);

            devolverCaminoRecursivo2(mapaCiudades, actual, resultado, vIni, marca, vDes);
        }
      return resultado;

    }
  
    //devuelve el primer camino encontrado y corta
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

    //devuelve el ultimo camino encontrado
    private void devolverCaminoRecursivo2(Grafo<String> grafo, ListaGenerica<String> actual, ListaGenerica<String> resultado, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {

    String ciudadActual = vIni.dato();
    marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
    actual.agregarFinal(ciudadActual);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo

    if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
        copiarLista(resultado, actual);
    }
    else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
        while ((!adyacentes.fin())) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
            Arista<String> aristaActual = adyacentes.proximo();
            if (!marca[aristaActual.verticeDestino().posicion()])
                devolverCaminoRecursivo2(grafo, actual, resultado, aristaActual.verticeDestino(), marca, vDes);

        }
    }
    marca[vIni.posicion()] = false;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
    actual.eliminarEn(actual.tamanio()-1);
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
      ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();

        if ((mapaCiudades!=null)&&(!mapaCiudades.esVacio())) {
            boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
            Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
            Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
            ciudadesExc.comenzar();
            devolverCaminoExceptuandoRecursivo2(mapaCiudades, actual, resultado, vIni, marca, vDes, ciudadesExc);
        }
        return resultado;

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

  private void devolverCaminoExceptuandoRecursivo2(Grafo<String> grafo, ListaGenerica<String> actual, ListaGenerica<String> resultado, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes,ListaGenerica<String> ciudadesExc) {
    int terminar=0;
    ciudadesExc.comenzar();//no olvidar porque me quedo en el fin de ella
    while(!ciudadesExc.fin() && terminar==0){
        if(vIni.dato().equals(ciudadesExc.proximo()))
          terminar=1;
      }
    
    if(terminar==0){
      String ciudadActual = vIni.dato();
      marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
      actual.agregarFinal(ciudadActual);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo

      if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
          copiarLista(resultado, actual);
      }
      else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
          ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
          while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
              Arista<String> aristaActual = adyacentes.proximo();
              if (!marca[aristaActual.verticeDestino().posicion()])
                  devolverCaminoExceptuandoRecursivo2(grafo, actual, resultado, aristaActual.verticeDestino(), marca, vDes, ciudadesExc);
          }
      }
      marca[vIni.posicion()] = false;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
      actual.eliminarEn(actual.tamanio()-1);
    }
}

  public ListaGenerica<String> devolverCaminoCorto(String ciudad1, String ciudad2) {
    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();
    int pesoActual=0;
    Peso pesoMinimo= new Peso();
    pesoMinimo.setDato(9999);

      if ((mapaCiudades!=null)&&(!mapaCiudades.esVacio())) {
          boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
          Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
          Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
          devolverCaminoCortoRecursivo(mapaCiudades, pesoActual, pesoMinimo, resultado, actual, vIni, marca, vDes);
      }
      return resultado;

  }

  private void devolverCaminoCortoRecursivo(Grafo<String> grafo, int pesoActual, Peso pesoMinimo, ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
    String ciudadActual = vIni.dato();
    marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
    auxiliar.agregarFinal(ciudadActual);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo

    if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
      if(pesoActual<pesoMinimo.getDato())  {
        copiarLista(resultado, auxiliar);
        pesoMinimo.setDato(pesoActual);
      }
    }
    else{
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
        while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
            Arista<String> actual = adyacentes.proximo();
            int pos=actual.verticeDestino().posicion();
            if (!marca[pos])
                devolverCaminoCortoRecursivo(grafo, pesoActual+actual.peso(), pesoMinimo, resultado, auxiliar, actual.verticeDestino(), marca, vDes);
        }
    }
    marca[vIni.posicion()] = false;
    auxiliar.eliminarEn(auxiliar.tamanio()-1);
  }

  public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int combustible) {
    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();
    int pesoActual=0;

      if ((mapaCiudades!=null)&&(!mapaCiudades.esVacio())) {
          boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
          Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
          Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
          caminoSinCargarCombustibleRecursivo(combustible, mapaCiudades, pesoActual, resultado, actual, vIni, marca, vDes);
      }
      return resultado;

  }

  private void caminoSinCargarCombustibleRecursivo(int combustible, Grafo<String> grafo, int pesoActual, ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
    String ciudadActual = vIni.dato();
    marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
    auxiliar.agregarFinal(ciudadActual);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo

    if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
      if(pesoActual<=combustible)  {
        copiarLista(resultado, auxiliar);
      }
    }
    else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
        while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
            Arista<String> actual = adyacentes.proximo();
            int pos=actual.verticeDestino().posicion();
            if (!marca[pos])
                caminoSinCargarCombustibleRecursivo(combustible, grafo, pesoActual+actual.peso(), resultado, auxiliar, actual.verticeDestino(), marca, vDes);
        }
    }
    marca[vIni.posicion()]=false; //es lo mismo desmarcar acá
    auxiliar.eliminarEn(auxiliar.tamanio()-1);

  }

  public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int combustible) {
    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();

      if (!this.mapaCiudades.esVacio() && this.mapaCiudades!=null) {  
          int recargasAct;
          Peso recargasMin= new Peso();
          int combustibleAct=combustible;
          recargasAct=0;
          recargasMin.setDato(9999);

          boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
          Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
          Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
          caminoConMenorCargaDeCombustibleRecursivo(recargasMin, recargasAct, combustible, mapaCiudades, combustibleAct, resultado, actual, vIni, marca, vDes);
      }

      return resultado;

  }

  private void caminoConMenorCargaDeCombustibleRecursivo(Peso recargasMin, int recargasAct, int combustible, Grafo<String> grafo, int combustibleAct, ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
    String ciudadActual = vIni.dato();
    marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
    auxiliar.agregarFinal(ciudadActual);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo

    if (ciudadActual.equals(vDes.dato())) {//usar equals, no ==
      if(recargasAct<=recargasMin.getDato())  {
        copiarLista(resultado, auxiliar);
        recargasMin.setDato(recargasAct);
      }
    }
    else{
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
        while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
            Arista<String> actual = adyacentes.proximo();
            int pos=actual.verticeDestino().posicion();
            if (!marca[pos] && actual.peso()<=combustible){
                if(combustibleAct-actual.peso()<0)
                  caminoConMenorCargaDeCombustibleRecursivo(recargasMin, recargasAct+1, combustible, grafo, combustible, resultado, auxiliar, actual.verticeDestino(), marca, vDes);
                else
                  caminoConMenorCargaDeCombustibleRecursivo(recargasMin, recargasAct, combustible, grafo, combustibleAct-actual.peso(), resultado, auxiliar, actual.verticeDestino(), marca, vDes);
            }
        }
    }
    auxiliar.eliminarEn(auxiliar.tamanio()-1);
    marca[vIni.posicion()]=false;
  }

  public ListaGenerica<String> caminoSinCargarCombustible2(String ciudad1,String ciudad2, int tanqueAuto){
		ListaGenerica<String> resultado= new ListaGenericaEnlazada<String>();
		if ((mapaCiudades!=null)&&(!mapaCiudades.esVacio())) {
			ListaGenerica<Vertice<String>> vertices= mapaCiudades.listaDeVertices();
			Vertice<String> vInicial= null;
			Vertice<String> vFinal=null;
			vertices.comenzar();
			while (!vertices.fin()) {
				Vertice<String> vAct=vertices.proximo();
				if (vAct.dato().equals(ciudad1)) {
					vInicial=vAct;
				}
				else if (vAct.dato().equals(ciudad2)) {
					vFinal=vAct;
				}		
			}
			// si s ecumple empezamos a recorrer
			if (((vInicial!=null)&&(vFinal!=null))){
				ListaGenerica<String> caminoAct=new ListaGenericaEnlazada<String>();
				boolean[] visitados= new boolean[mapaCiudades.listaDeVertices().tamanio()];
				caminoSinCargarCombustible2(vInicial,vFinal,caminoAct,resultado,visitados,mapaCiudades,tanqueAuto);
			}
		}
		return resultado;
	}
	
	private void caminoSinCargarCombustible2(Vertice<String>vAct,Vertice<String>vFinal,ListaGenerica<String> caminoAct,ListaGenerica<String>resultado,boolean[] visitados, Grafo<String>g, int naftaActual) {
		visitados[vAct.posicion()]=true;
		caminoAct.agregarFinal(vAct.dato());
		if(vAct.dato().equals(vFinal.dato()))// si llego al destino es pq tenia nafta
			  copiarLista(caminoAct, resultado);	
		
		//recorro
		ListaGenerica<Arista<String>> adyacentes=g.listaDeAdyacentes(vAct);
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			Arista<String> aristaAct=adyacentes.proximo();
			if (naftaActual-aristaAct.peso()>0) {
				Vertice<String> vSig=aristaAct.verticeDestino();
				if(!visitados[vSig.posicion()]) {
					caminoSinCargarCombustible2(vSig,vFinal,caminoAct,resultado,visitados,g,naftaActual-aristaAct.peso());
				}
			}
		}
		visitados[vAct.posicion()]=false;
		caminoAct.eliminarEn(caminoAct.tamanio()-1);
	}

  public ListaGenerica<String> devolverCaminoCorto2(String ciudad1, String ciudad2) {
    ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();
    ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();
    Peso pesoActual= new Peso();
    Peso pesoMinimo= new Peso();
    pesoMinimo.setDato(9999);

      if (!this.mapaCiudades.esVacio() && this.mapaCiudades!=null) {
          boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
          Vertice<String> vIni = obtenerVertice(ciudad1, mapaCiudades);
          Vertice<String> vDes = obtenerVertice(ciudad2, mapaCiudades);
          devolverCaminoCortoRecursivo2(mapaCiudades, pesoActual, pesoMinimo, resultado, actual, vIni, marca, vDes);
      }
      // resultado.agregarInicio(ciudad1);//AL FINAL NO ES NECESARIO//lo hago al final, porque el valor de resultado se va actualizando con otros caminos
      
      // int j=resultado.tamanio()-1;//tal vez el dato no se encontro, pero la lista tiene elementos. O la lista es vacia
      // if(j>=0 && resultado.elemento(j).equals(ciudad2))//tal vez solo tenga agregado el destino de la ciudad1
      //   return resultado;
      // else
      //   return null;
      
      return resultado;

  }

  private void devolverCaminoCortoRecursivo2(Grafo<String> grafo, Peso pesoActual, Peso pesoMinimo, ListaGenerica<String> resultado, ListaGenerica<String> auxiliar, Vertice<String> vIni, boolean[] marca, Vertice<String> vDes) {
  
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
                devolverCaminoCortoRecursivo2(grafo, pesoActual, pesoMinimo, resultado, auxiliar, actual.verticeDestino(), marca, vDes);
            }
            if(auxiliar.tamanio()>1)//no quiero eliminar el origen de la lista en caso de tener que borrarla
              auxiliar.eliminarEn(auxiliar.tamanio()-1);//estas 3 instrucciones son necesarias para ir por otros caminos
            // Lactual.eliminarEn(actual.tamanio()-1);//no necesaria porque no calculo el peso con ella
            pesoActual.setDato(0); //necesario cuando tengo 2 listas de camino, que devo reiniciar
            // marca[pos]=false;
        }
    }//cuando tengo que recorrer varios caminos, debo desmarcar el vector para poder volver a pasar por ahí
    marca[vIni.posicion()] = false;
  }

}