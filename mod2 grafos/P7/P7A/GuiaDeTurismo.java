public class GuiaDeTurismo {

    public GuiaDeTurismo(){

    }
    private Vertice<String> obtenerVertice(String ciudad1, Grafo<String> grafo) {//conviene pasar el grafo y no usar la variable de la clase
        Vertice<String> verticeActual = null;
        ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
        int i=0, reps=vertices.tamanio() - 1;
        
        verticeActual = vertices.elemento(i);
        while(i<reps && !verticeActual.dato().equals(ciudad1)){
          i++;
          verticeActual = vertices.elemento(i);
  
        }

        if(!verticeActual.dato().equals(ciudad1))
          return null;
        return verticeActual;
      }

    public ListaGenerica <String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String puntoInteresDestino){
        Viaje viajeRes = new Viaje();
        viajeRes.setMenorPeso(0);
  
        if(grafo!=null && !grafo.esVacio()){
          boolean[] marca = new boolean [grafo.listaDeVertices().tamanio()];
          ListaGenerica<String> actual = new ListaGenericaEnlazada<String>();

          Vertice<String> vIni = obtenerVertice(puntoInteresOrigen, grafo);
          Vertice<String> vDes = obtenerVertice(puntoInteresDestino, grafo);

          caminoConMenorNrodeViajesRec(grafo, actual, 9999, viajeRes, vIni, vDes, marca);
        }
        return viajeRes.getRuta();
    }
      
    private void caminoConMenorNrodeViajesRec(Grafo<String> grafo, ListaGenerica<String> auxiliar, int menorPeso, Viaje viajeRes, Vertice<String> vIni, Vertice<String> vDes, boolean[] marca){
        String puntoAct = vIni.dato();
        marca[vIni.posicion()] = true;
        auxiliar.agregarFinal(puntoAct);
        
        if(!(menorPeso<viajeRes.getMenorPeso()) ){

          if (puntoAct.equals(vDes.dato())) {//usar equals, no ==
            if(menorPeso > viajeRes.getMenorPeso())  {//me debo quedar con el mayor!!
              viajeRes.setRuta(auxiliar.copiar());
              viajeRes.setMenorPeso(menorPeso);
            }
          }
          else{
              ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
              adyacentes.comenzar();
              while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
                  Arista<String> actual = adyacentes.proximo();
                  int pos=actual.verticeDestino().posicion();
                  if (!marca[pos]){
                      if(actual.peso() < menorPeso)
                          menorPeso=actual.peso();
                      caminoConMenorNrodeViajesRec(grafo, auxiliar, menorPeso, viajeRes, actual.verticeDestino(), vDes, marca);
                  }
              }
          }    
          marca[vIni.posicion()]=false;//ahora vuelo para atras
          auxiliar.eliminarEn(auxiliar.tamanio()-1);   
        } 
    }
}
