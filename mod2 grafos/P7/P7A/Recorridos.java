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
                dfs(i, grafo.vertice(i), verticesMarcados, listaRecorrido);
        }

        return listaRecorrido;
    }


    private void dfs(int pos, Vertice<T> vertice, boolean[] verticesMarcados,ListaGenerica<Vertice<T>> listaRecorrido){
        verticesMarcados[pos]=true;
    }
}
