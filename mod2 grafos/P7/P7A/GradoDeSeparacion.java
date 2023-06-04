public class GradoDeSeparacion {

    public GradoDeSeparacion(){

    }

    public int maximoGradoDeSeparacion(Grafo<String> grafo){
        int gradoMax=-1;

        ListaGenerica<Arista<String>> listaAdyacentes=new ListaGenericaEnlazada<Arista<String>>();
        ListaGenerica<Vertice<String>> listaVertices=new ListaGenericaEnlazada<Vertice<String>>();
        ColaGenerica<Vertice<String>> cola = new ColaGenerica<Vertice<String>>();
        int cantVertices;
        cantVertices=grafo.listaDeVertices().tamanio();
        boolean[] verticesMarcados = new boolean[cantVertices];
        listaVertices=grafo.listaDeVertices();
        listaVertices.comenzar();

        while(!listaVertices.fin() && gradoMax!=0){//debo chequear cada vertice por si está aislado del resto, mientras que sea conexo
            Vertice<String> vInicio = listaVertices.proximo();
            int gradoAct=0;

            if(verticesMarcados[vInicio.posicion()]==false){

                cola.encolar(vInicio);
                cola.encolar(null);

                while(!cola.esVacia()){//similar a un recorrido por niveles que visita los adyacentes y encola los destinos de los adyacentes
                    Vertice<String> verticeAct=cola.desencolar();
                    if(verticeAct!=null){//como encolo null, chequear de no estar parado en null
                        listaAdyacentes=grafo.listaDeAdyacentes(verticeAct);
                        listaAdyacentes.comenzar();//antes de recorrerla no olvidar pararme al inicio
                        
                        while(!listaAdyacentes.fin()){
                            Arista<String> aristaAct=listaAdyacentes.proximo();
                            int pos=aristaAct.verticeDestino().posicion();
                            if(verticesMarcados[pos]==false){
                                verticesMarcados[pos]=true;//maracar aca para que al querer apilarlo por alguien mas (antes de leer ese verticeAct) no pueda
                                Vertice<String> verticeApuntado =aristaAct.verticeDestino();
                                cola.encolar(verticeApuntado);
                            }
                        }//termino un nivel
                    }
                    else{
                        if(!cola.esVacia()){
                            gradoAct++;
                            cola.encolar(null);
                        }
                    }
                }//termino el recorrido desde un origen

                int i=0;
                while(i<cantVertices && gradoMax!=0){
                    if(verticesMarcados[i]==false)
                        gradoMax=0;
                    i++;
                }

                if(gradoMax!=0 && gradoAct>gradoMax)
                    gradoMax=gradoAct;
            }
            for(int i=0; i<cantVertices; i++){//debo desmarcar los vertices para analizar desde otro origen
                verticesMarcados[i]=false;
            }
        }//termino programa

        return gradoMax;
    }
    
}
