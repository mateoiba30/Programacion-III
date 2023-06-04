public class Recorridos<T> {


    public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){//recorrido en profundidas, recursicvo en preorden
        
        int cantVertices;
        cantVertices=grafo.listaDeVertices().tamanio();
        boolean[] verticesMarcados = new boolean[cantVertices];
        ListaGenerica<Vertice<T>> listaRecorrido=new ListaGenericaEnlazada<Vertice<T>>();


        for(int i=0; i<cantVertices; i++)
            verticesMarcados[i]=false;

        for(int i=0; i<cantVertices; i++){//entra a preguntar por cada vertice
            if(verticesMarcados[i]==false){
                // System.out.println(grafo.vertice(i).dato()+"->");
                listaRecorrido.agregarFinal(grafo.vertice(i));//no olvidar de mandar el 1er elemento
                dfsRec(i, grafo, verticesMarcados, listaRecorrido);
            }
        }

        return listaRecorrido;
    }

    private void dfsRec(int pos, Grafo<T> grafo, boolean[] verticesMarcados,ListaGenerica<Vertice<T>> listaRecorrido){
        
        verticesMarcados[pos]=true;
        ListaGenerica<Arista<T>> listaAdyacentes =new ListaGenericaEnlazada<Arista<T>>();
        listaAdyacentes=grafo.listaDeAdyacentes(grafo.vertice(pos));
        int j, tamanio=listaAdyacentes.tamanio();

        for(int i=0; i<tamanio; i++){
            j=listaAdyacentes.elemento(i).verticeDestino().posicion();
            // System.out.println("j: "+j+"\n");

            if(verticesMarcados[j]==false){

                listaRecorrido.agregarFinal(grafo.vertice(j));
                // System.out.println(grafo.vertice(j).dato()+"->");
                dfsRec(j, grafo, verticesMarcados, listaRecorrido);
            }
        }
    }

    public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo){

        ListaGenerica<Arista<T>> listaAdyacentes=new ListaGenericaEnlazada<Arista<T>>();
        ListaGenerica<Vertice<T>> listaRecorrido=new ListaGenericaEnlazada<Vertice<T>>();
        ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
        int cantVertices;
        cantVertices=grafo.listaDeVertices().tamanio();
        boolean[] verticesMarcados = new boolean[cantVertices];

        for(int i=0; i<cantVertices; i++){//debo chequear cada vertice por si está aislado del resto
            if(verticesMarcados[i]==false){

                cola.encolar(grafo.vertice(i));//encolo vertice de la lsita del grafo
                // cola.encolar(null);

                while(!cola.esVacia()){//similar a un recorrido por niveles que visita los adyacentes y encola los destinos de los adyacentes
                    Vertice<T> verticeAct=cola.desencolar();
                    // int p=verticeAct.posicion();
                    // verticesMarcados[p]=true;//si marco acá me guarda 2 veces un vertice que sea destino de varios en otros niveles
                    // System.out.println(verticeAct.dato()+"->");

                    listaRecorrido.agregarFinal(verticeAct);//agregar el que desencolo, no antes de este while porque sino solo guarda el vertice de la posicion que diga el for principal
                    listaAdyacentes=grafo.listaDeAdyacentes(verticeAct);
                    listaAdyacentes.comenzar();//antes de recorrerla no olvidar pararme al inicio
                    
                    while(!listaAdyacentes.fin()){
                        Arista<T> aristaAct=listaAdyacentes.proximo();
                        int pos=aristaAct.verticeDestino().posicion();
                        if(verticesMarcados[pos]==false){
                            verticesMarcados[pos]=true;//maracar aca para que al querer apilarlo por alguien mas (antes de leer ese verticeAct) no pueda
                            Vertice<T> verticeApuntado =aristaAct.verticeDestino();
                            cola.encolar(verticeApuntado);
                        }
                    }
                    // if(!cola.esVacia()){
                    //     //nivle ++
                    //     cola.encolar(null);
                    // }
                }

            }
        }
        return listaRecorrido;
    }
}
