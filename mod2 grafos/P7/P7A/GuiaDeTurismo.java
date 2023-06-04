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
        return verticeActual;
      }

    public ListaGenerica <String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String puntoInteresDestino){
        Viaje viajeRes = new Viaje();
  
        if(grafo!=null && !grafo.esVacio()){
          boolean[] marca = new boolean [grafo.listaDeVertices().tamanio()];
          Viaje viajeAct = new Viaje();

          Vertice<String> vIni = obtenerVertice(puntoInteresOrigen, grafo);
          Vertice<String> vDes = obtenerVertice(puntoInteresDestino, grafo);

          caminoConMenorNrodeViajesRec(grafo, viajeAct, viajeRes, vIni, vDes, marca);
        }
  
        int j=viajeRes.getRuta().tamanio()-1;//tal vez el dato no se encontro, pero la lista tiene elementos. O la lista es vacia
        if(j>=0 && viajeRes.getRuta().elemento(j).equals(puntoInteresDestino))//tal vez solo tenga agregado el destino de la ciudad1
          return viajeRes.getRuta();
        else
          return null;
    }
      
    private void caminoConMenorNrodeViajesRec(Grafo<String> grafo, Viaje viajeAct, Viaje viajeRes, Vertice<String> vIni, Vertice<String> vDes, boolean[] marca){
        String islaAct = vIni.dato();
        marca[vIni.posicion()] = true;//marco y nunca desenmarco, ya que si no pude llegar a destino en resurción con este vertice ya queda descartado
        viajeAct.getRuta().agregarFinal(islaAct);//inicio agregando la siguiente, por lo cual debo agregar a Buenos aires en el algoritmo iterativo
        
        if (islaAct.equals(vDes.dato())) {//usar equals, no ==
          if(viajeAct.getMenorPeso() < viajeRes.getMenorPeso())  {
            viajeRes.setRuta(viajeAct.getRuta().copiar());
            viajeAct.setMenorPeso(viajeAct.getMenorPeso());
          }
        }
        else{//no usar tamanio, usar fin() y proximo() que es mas eficiente y menos confuso
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vIni);//no las declaro antes para no declarar al pedo
            adyacentes.comenzar();
            while (!adyacentes.fin()) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero //no pregunto que resultado no sea vacio porque sino me corta la primera vez
                Arista<String> actual = adyacentes.proximo();
                int pos=actual.verticeDestino().posicion();
                if (!marca[pos]){
                    pesoActual.setDato(pesoActual.getDato()+actual.peso());
                    caminoConMenorNrodeViajesRec(pesoMinimo, pesoActual, grafo, auxiliar, resultado, actual.verticeDestino(), vDes, marca);
                    marca[pos]=false;//ahora vuelo para atras
                    pesoActual.setDato(pesoActual.getDato()-actual.peso());
                    auxiliar.getRuta().eliminarEn(auxiliar.getRuta().tamanio()-1);  
                }
            }
            if(vIni.posicion()==0 && vDes.posicion()!=0)//si elmuelle tiene muchos backtrackins significa que resta varias veces. Fuera del while pasa lo que quiero que suceda
            auxiliar.setBoletos(auxiliar.getBoletos()-1);          
        }      
    }
}
