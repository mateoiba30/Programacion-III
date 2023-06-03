import java.util.Arrays;//para maxislasdistintas 2


public class Delta<T> {

    public Delta(){

    }

    // private void copiarLista(ListaGenerica<String> resultado, ListaGenerica<String> auxiliar) {
    //   resultado.comenzar();
    //   while (!resultado.esVacia())
    //     resultado.eliminarEn(0);
    //   auxiliar.comenzar();
    //   while (!auxiliar.fin())
    //     resultado.agregarFinal(auxiliar.proximo());
    // }

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

    public int maxIslasDistintas(Grafo<String> grafo){//Seguro tiene ciclos
        int t=grafo.listaDeVertices().tamanio();
        Peso max = new Peso();
        max.setDato(0);

        if(!grafo.esVacio()){
            int visitadasDesde=0;//como es int, en el backtracking vuelve a su estado anterior
            boolean[] marca = new boolean[t];//se inicia en false automaticamente
            marca[0]=true;//nadie visita a MP, puede ser que voy por un adycente a MP, que tiene otro adyacente con posible destino a MP (ese caso no es un Max)

            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(grafo.vertice(0));//muelle principal = vertice 0
            adyacentes.comenzar();
            while (!adyacentes.fin()){
                Arista<String> actual = adyacentes.proximo();
                visitadasDesde=1;//inicia en 1, porque el primer adyacente ya es una isla nueva
                maxIslasDistintasRecursivo(max, visitadasDesde, grafo, actual.verticeDestino(), actual.verticeDestino(), marca);
            }
        }

        return max.getDato();//devuelve el maximo de un vector
    }
    //podría mandar en recursion a longitud +1 tambien, y que sea del tipo int
    private void maxIslasDistintasRecursivo(Peso max, int visitadasDesde, Grafo<String> grafo, Vertice<String> islaInicio, Vertice<String> islaAct, boolean[] marca) {
        marca[islaAct.posicion()] = true;//si marco el vertice de inicio, no cambia nada
   
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(islaAct);//no las declaro antes para no declarar al pedo
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> actual = adyacentes.proximo();
            int pos=actual.verticeDestino().posicion();
            if (!marca[pos] && pos!=0){//no ir al muelle principal, me veulvo al terminar por donde vine
                visitadasDesde++;
                maxIslasDistintasRecursivo(max, visitadasDesde, grafo, islaInicio, actual.verticeDestino(), marca);
            }
            if(visitadasDesde>max.getDato())
                max.setDato(visitadasDesde);
        }
    }

    public int maxIslasDistintas2(Grafo<T> grafo) {
        Vertice<T> v = grafo.listaDeVertices().elemento(0);
        int[] islas = new int[grafo.listaDeAdyacentes(v).tamanio()];
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        marca[0] = true;
        int i = 0;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
          Arista<T> arista = ady.proximo();
        //   if (!marca[arista.verticeDestino().posicion()]) //no necesario
            maxIslasDistintas3(grafo, arista.verticeDestino(), marca, islas, i);
          
          islas[i]++;//lo malo es que guardo 1 contador por cada vertice, mejor la anterior solucion
          i++;//la i no representa exactamente la pósicion del vertice actual. Es como si ahora cada vertice tiene un nuevo id que es la posicion elk la lista de adyacencias del muelle principal
        }
        return Arrays.stream(islas).max().getAsInt();//devuelve el maximo de un vector de numeros
      }
    
    private void maxIslasDistintas3(Grafo<T> grafo, Vertice<T> v, boolean[] marca, int[] islas, int i) {
      marca[v.posicion()] = true;
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> arista = ady.proximo();
        if (!marca[arista.verticeDestino().posicion()]) {
          islas[i]++;
          maxIslasDistintas3(grafo, arista.verticeDestino(), marca, islas, i);
        }
      }
    }

    public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD){
      RutaMinima resultado = new RutaMinima();
      RutaMinima actual = new RutaMinima();
      actual.setBoletos(1);//para iniciar el recorrido necesito al menos 1 boleto

      if(grafo!=null && !grafo.esVacio()){
        boolean[] marca = new boolean [grafo.listaDeVertices().tamanio()];
        Peso pesoMinimo= new Peso();
        Peso pesoActual=new Peso();
        pesoMinimo.setDato(9999);
        pesoActual.setDato(0);
        Vertice<String> vIni = obtenerVertice(islaO, grafo);
        Vertice<String> vDes = obtenerVertice(islaD, grafo);
        caminoMasCortoRec(pesoMinimo, pesoActual, grafo, actual, resultado, vIni, vDes, marca);
      }

      int j=resultado.getRuta().tamanio()-1;//tal vez el dato no se encontro, pero la lista tiene elementos. O la lista es vacia
      if(j>=0 && resultado.getRuta().elemento(j).equals(islaD))//tal vez solo tenga agregado el destino de la ciudad1
        return resultado;
      else
        return null;
    }

    private void caminoMasCortoRec(Peso pesoMinimo, Peso pesoActual, Grafo<String> grafo, RutaMinima auxiliar, RutaMinima resultado, Vertice<String> vIni, Vertice<String> vDes, boolean[] marca){
      String islaAct = vIni.dato();
      marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
      auxiliar.getRuta().agregarFinal(islaAct);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo
      
      if(vIni.posicion()==0 && vDes.posicion()!=0){//significa que estoy en el Muelle principal
        auxiliar.setBoletos(auxiliar.getBoletos()+1);
      }
      if (islaAct.equals(vDes.dato())) {//usar equals, no ==
        if(pesoActual.getDato()<pesoMinimo.getDato())  {
          resultado.setRuta(auxiliar.getRuta().copiar());
          resultado.setBoletos(auxiliar.getBoletos());
          pesoMinimo.setDato(pesoActual.getDato());
        }
        // pesoActual.setDato(0);

      }
      else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
          ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
          adyacentes.comenzar();
          while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
              Arista<String> actual = adyacentes.proximo();
              int pos=actual.verticeDestino().posicion();
              if (!marca[pos]){
                  pesoActual.setDato(pesoActual.getDato()+actual.peso());
                  caminoMasCortoRec(pesoMinimo, pesoActual, grafo, auxiliar, resultado, actual.verticeDestino(), vDes, marca);
                  marca[pos]=false;//ahora vuelo para atras
                  pesoActual.setDato(pesoActual.getDato()-actual.peso());
                  auxiliar.getRuta().eliminarEn(auxiliar.getRuta().tamanio()-1);
                  if(vIni.posicion()==0 && vDes.posicion()!=0)//significa que estoy en el Muelle principal
                    auxiliar.setBoletos(auxiliar.getBoletos()-1);

              }
          }

          // if(auxiliar.getRuta().tamanio()>1)//no quiero eliminar el origen de la lista en caso de tener que borrarla
          //   auxiliar.getRuta().eliminarEn(auxiliar.getRuta().tamanio()-1);//estas 3 instrucciones son necesarias para ir por otros caminos
          // // Lactual.eliminarEn(actual.tamanio()-1);//no necesaria porque no calculo el peso con ella
          // // pesoActual.setDato(0); //necesario cuando tengo 2 listas de camino, que devo reiniciar
          // if(vIni.posicion()==0){//significa que estoy en el Muelle principal
          //   auxiliar.setBoletos(auxiliar.getBoletos()-1);
          // }
          
      }
    
    
  }
}

