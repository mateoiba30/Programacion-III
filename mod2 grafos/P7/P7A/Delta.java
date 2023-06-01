public class Delta<T> {

    public Delta(){

    }

    public int maxIslasDistintas(Grafo<String> grafo){//Seguro tiene ciclos
        int maxIslas=0;

        if(!grafo.esVacio()){
            Peso longitud = new Peso();
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];//se inicia en false automaticamente
            longitud.setDato(0);//100 porciento necesario, porque al volver en recursion se hace lio y puede quedar la long negativa
            int maxLong=0;
            marca[0]=true;//nadie visita a MP, puede ser que voy por un adycente a MP, que tiene otro adyacente con posible destino a MP (ese caso no es un Max)

            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(grafo.vertice(0));//muelle principal = vertice 0
            adyacentes.comenzar();
            while (!adyacentes.fin()){
                Arista<String> actual = adyacentes.proximo();
                longitud.setDato(1);//inicia en 1, porque el primer adyacente ya es una isla nueva
                maxIslasDistintasRecursivo(longitud, grafo, actual.verticeDestino(), actual.verticeDestino(), marca);
                if(longitud.getDato()>maxLong)
                    maxLong=longitud.getDato();
            }
        }

        return maxIslas;
    }
    //podría mandar en recursion a longitud +1 tambien, y que sea del tipo int
    private void maxIslasDistintasRecursivo(Peso longitud, Grafo<String> grafo, Vertice<String> islaInicio, Vertice<String> islaAct, boolean[] marca) {

        if(!islaInicio.dato().equals(islaAct.dato()))//no marco en true el vertice del inicio para poder chequear el ciclo pasando po el inicio
        marca[islaAct.posicion()] = true;

        if (!(islaInicio.dato().equals(islaAct.dato())&& longitud.getDato()!=0)){//si llega a ser un grafo de enteros, me sirve equlas si uso el wrapper Integer//si volvió de donde vino y el camino fue de 4     
            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(islaAct);//no las declaro antes para no declarar al pedo
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Arista<String> actual = adyacentes.proximo();
                int pos=actual.verticeDestino().posicion();
                longitud.setDato(longitud.getDato() + 1);//puede ser que no entre al adyacente porque fue visitado antes, pero debo sumar porque desp paso a restar en caso de que tenga adyacente

                if (!marca[pos] && pos!=0){//no ir al muelle principal, me veulvo al terminar por donde vine
                    maxIslasDistintasRecursivo(longitud, grafo, islaInicio, actual.verticeDestino(), marca);
                }
                longitud.setDato(longitud.getDato() - 1);//para poder analizar otros casos, de a 1 resto en el backtracking
                marca[pos]=false;//para poder analizar otros casos
            }
        }
    }
}
