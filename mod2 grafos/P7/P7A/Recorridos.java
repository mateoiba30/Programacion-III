public class Recorridos<T> {
    public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){//recorrido en profundidas, recursicvo en preorden
        
        int cantVertices;
        cantVertices=grafo.listaDeVertices().tamanio();
        boolean[] verticesMarcados = new boolean[cantVertices];
        ListaGenerica<Vertice<T>> listaRecorrido=new ListaGenericaEnlazada<Vertice<T>>();
        
        for(int i=0; i<cantVertices; i++)
            verticesMarcados[i]=false;

        for(int i=0; i<cantVertices; i++){
            if(verticesMarcados[i]==false)
                dfs(i, grafo, verticesMarcados, listaRecorrido);
        }

        return listaRecorrido;
    }


    private void dfs(int pos, Grafo<T> grafo, boolean[] verticesMarcados,ListaGenerica<Vertice<T>> listaRecorrido){
        verticesMarcados[pos]=true;
        ListaGenerica<Arista<T>> listaAdyacentes =new ListaGenericaEnlazada<Arista<T>>();
        int j, tamanio=listaAdyacentes.tamanio();
        for(int i=0; i<tamanio; i++){
            j=listaAdyacentes.elemento(i).verticeDestino().posicion();
            if(verticesMarcados[j]==false){
                listaRecorrido.agregarFinal(grafo.vertice(j));
                dfs(j, grafo, verticesMarcados, listaRecorrido);
            }
        }
    }
}
