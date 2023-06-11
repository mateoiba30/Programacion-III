public class OrdenTopologico<T> {
    
    public OrdenTopologico(){

    }

    public ListaGenerica<Vertice<T>> or(Grafo<T> grafo){//recorrido en profundidas, recursicvo en preorden
        
        int cantVertices;
        cantVertices=grafo.listaDeVertices().tamanio();
        boolean[] verticesMarcados = new boolean[cantVertices];
        ListaGenerica<Vertice<T>> listaRecorrido=new ListaGenericaEnlazada<Vertice<T>>();
        ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();

        for(int i=0; i<cantVertices; i++)
            verticesMarcados[i]=false;

        for(int i=0; i<cantVertices; i++){//entra a preguntar por cada vertice
            if(verticesMarcados[i]==false){
                listaRecorrido.agregarFinal(grafo.vertice(i));//no olvidar de mandar el 1er elemento
                dfsRec(cola, i, grafo, verticesMarcados, listaRecorrido);//voy guardando en la cola el resultado
            }
        }

        while(!cola.fin())//voy desencolando y guardando en el resultado
            listaRecorrido.agregarFinal(cola.desencolar());
            
        return listaRecorrido;
    }

    private void dfsRec(ColaGenerica<Vertice<T>> cola, int pos, Grafo<T> grafo, boolean[] verticesMarcados,ListaGenerica<Vertice<T>> listaRecorrido){
        
        verticesMarcados[pos]=true;
        ListaGenerica<Arista<T>> listaAdyacentes =new ListaGenericaEnlazada<Arista<T>>();
        listaAdyacentes=grafo.listaDeAdyacentes(grafo.vertice(pos));
        int j, tamanio=listaAdyacentes.tamanio();

        for(int i=0; i<tamanio; i++){
            j=listaAdyacentes.elemento(i).verticeDestino().posicion();
            // System.out.println("j: "+j+"\n");

            if(verticesMarcados[j]==false){
                dfsRec(cola, j, grafo, verticesMarcados, listaRecorrido);
                cola.encolar(grafo.vertice(i));//encolo en post orden
            }
        }
    }
}
