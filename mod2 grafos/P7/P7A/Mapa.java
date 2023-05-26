public class Mapa {

    private Grafo<String> mapaCiudades;

    public void setMapa(Grafo<String> mapaCiudades){
        this.mapaCiudades=mapaCiudades;
    }

    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        int cantVertices;
        cantVertices=mapaCiudades.listaDeVertices().tamanio();
        boolean[] verticesMarcados = new boolean[cantVertices];
        for(int i=0; i<cantVertices; i++)
            verticesMarcados[i]=false;

        int pos1=0;
        while( mapaCiudades.vertice(pos1).dato().equals(ciudad1) )//obtengo posicion de la ciudad1
            pos1++;
        pos1--;//la pos es un numero menos

        // ListaGenerica<Arista<String>> listaAdyacentes =new ListaGenericaEnlazada<Arista<String>>();
        // listaAdyacentes=mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(pos1));
        // int tamanio=listaAdyacentes.tamanio();
        // System.out.println("Adeyacentes de "+mapaCiudades.vertice(pos1).dato());
        // for(int j=0; j<tamanio; j++){
        //     System.out.println(listaAdyacentes.elemento(j).verticeDestino().dato());
        // }

        devolverCaminoRec(camino, pos1, ciudad2, verticesMarcados);
        
        return camino;
    }

    private void devolverCaminoRec(ListaGenerica<String> camino, int pos, String destino, boolean[] verticesMarcados){
        ListaGenerica<Arista<String>> listaAdyacentes =new ListaGenericaEnlazada<Arista<String>>();
        listaAdyacentes=mapaCiudades.listaDeAdyacentes(mapaCiudades.vertice(pos));
        int i, tamanio=listaAdyacentes.tamanio();
        listaAdyacentes.comenzar();
        verticesMarcados[pos]=true;
        
        if(tamanio==0){
            
            return;
        }
        
        if(mapaCiudades.vertice(pos).dato().equals(destino)){
            camino.agregarFinal(mapaCiudades.vertice(pos).dato());
            return;
        }

        i=0;
        while(i<tamanio && camino.esVacia()){
            if(verticesMarcados[i]==false)
                devolverCaminoRec(camino, listaAdyacentes.elemento(i).verticeDestino().posicion(), destino, verticesMarcados );
            if(!camino.esVacia()){
                camino.agregarFinal(listaAdyacentes.elemento(i).verticeDestino().dato());
            }
            i++;
        }


    }
    
    
}
