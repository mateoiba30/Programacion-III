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
                dfs(i, grafo, verticesMarcados, listaRecorrido);
            }
        }

        return listaRecorrido;
    }


    private void dfs(int pos, Grafo<T> grafo, boolean[] verticesMarcados,ListaGenerica<Vertice<T>> listaRecorrido){
        
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
                dfs(j, grafo, verticesMarcados, listaRecorrido);
            }
        }
    }
}
