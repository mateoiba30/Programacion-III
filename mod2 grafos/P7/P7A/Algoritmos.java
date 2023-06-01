public class Algoritmos<T> {

    public Algoritmos(){

    }
    
    public boolean subgrafoCuadrado(Grafo<T> grafo){
        boolean cuadrado=false;

        if (!grafo.esVacio()) {
            Peso longitud = new Peso();
            Peso cuadradoInt = new Peso();
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];//se inicia en false automaticamente
            cuadradoInt.setDato(0);

            int reps=grafo.listaDeVertices().tamanio() - 1;
            int pos=0;
            while(cuadrado==false && pos<=reps){//porque no me anda con proximo?
                longitud.setDato(0);//100 porciento necesario, porque al volver en recursion se hace lio y puede quedar la long negativa
                subgrafoCuadradoRecursivo(cuadradoInt, longitud, grafo, grafo.listaDeVertices().elemento(pos), grafo.listaDeVertices().proximo(), marca);
                pos++;
                // ya queda la ciudad desmarcada
            }
            if(cuadradoInt.getDato()==1)
                cuadrado=true;
        }
        
        return cuadrado;
        }
    
    private void subgrafoCuadradoRecursivo(Peso cuadrado, Peso longitud, Grafo<T> grafo, Vertice<T> vIni, Vertice<T> vAct, boolean[] marca) {

        if(!vIni.dato().equals(vAct.dato()))//no marco en true el vertice del inicio para poder chequear el ciclo pasando po el inicio
            marca[vAct.posicion()] = true;

        if (vIni.dato().equals(vAct.dato())&& longitud.getDato()==4)//si llega a ser un grafo de enteros, me sirve equlas si uso el wrapper Integer//si volvió de donde vino y el camino fue de 4
            cuadrado.setDato(1);
        else{
            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vAct);//no las declaro antes para no declarar al pedo
            adyacentes.comenzar();
            while ((!adyacentes.fin()) && cuadrado.getDato()==0) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
                Arista<T> actual = adyacentes.proximo();
                int pos=actual.verticeDestino().posicion();
                longitud.setDato(longitud.getDato() + 1);//puede ser que no entre al adyacente porque fue visitado antes, pero debo sumar porque desp paso a restar en caso de que tenga adyacente

                if (!marca[pos]){
                    subgrafoCuadradoRecursivo(cuadrado, longitud, grafo, vIni, actual.verticeDestino(), marca);
                }
                longitud.setDato(longitud.getDato() - 1);//para poder analizar otros casos, de a 1 resto en el backtracking
                marca[pos]=false;//para poder analizar otros casos
            }
        }
    }

    public int getGrado(Grafo<T> grafo) {
        int gradoMax=0, gradoAct;
        if (!grafo.esVacio()) {
            int t=grafo.listaDeVertices().tamanio();
            int[] vectorAdyacencias = new int[t];//se inicializa automaticamente en cero cada pos

            for(int i=0; i<t; i++){
                Vertice<T> verticeAct=grafo.listaDeVertices().elemento(i);
                ListaGenerica<Arista<T>> adyacentes =grafo.listaDeAdyacentes(verticeAct);
                int pos;

                while(!adyacentes.fin()){//cuento entradas
                    Arista<T> aristaAct = adyacentes.proximo();
                    pos=aristaAct.verticeDestino().posicion();
                    vectorAdyacencias[pos]++;
                }
            }
            
            for(int i=0; i<t; i++){
                Vertice<T> verticeAct=grafo.listaDeVertices().elemento(i);
                ListaGenerica<Arista<T>> adyacentes =grafo.listaDeAdyacentes(verticeAct);
                gradoAct=adyacentes.tamanio();//cuento salidas

                gradoAct+=vectorAdyacencias[i];
                
                if(gradoAct>gradoMax)
                    gradoMax=gradoAct;
            }
        
        }
        return gradoMax;
    }
}
