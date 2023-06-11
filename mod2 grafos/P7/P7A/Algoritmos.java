import java.util.Arrays;//para get grado 2

public class Algoritmos<T> {

    public Algoritmos(){

    }
    
    public boolean subgrafoCuadrado(Grafo<T> grafo){
        boolean cuadrado=false;

        if (grafo!=null && !grafo.esVacio()) {
            Peso cuadradoInt = new Peso();
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];//se inicia en false automaticamente
            cuadradoInt.setDato(0);

            int reps=grafo.listaDeVertices().tamanio() - 1;
            int pos=0;
            while(cuadrado==false && pos<=reps){
                subgrafoCuadradoRecursivo(cuadradoInt, 0, grafo, grafo.listaDeVertices().elemento(pos), grafo.listaDeVertices().proximo(), marca);
                pos++;
            }
            if(cuadradoInt.getDato()==1)
                cuadrado=true;
        }
        return cuadrado;
        }
    
    private void subgrafoCuadradoRecursivo(Peso cuadrado, int longitud, Grafo<T> grafo, Vertice<T> vIni, Vertice<T> vAct, boolean[] marca) {

        if(!vIni.dato().equals(vAct.dato()))//no marco en true el vertice del inicio para poder chequear el ciclo pasando po el inicio
            marca[vAct.posicion()] = true;

        if (vIni.dato().equals(vAct.dato())&& longitud==4)//si llega a ser un grafo de enteros, me sirve equlas si uso el wrapper Integer//si volvió de donde vino y el camino fue de 4
            cuadrado.setDato(1);
        else{
            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vAct);//no las declaro antes para no declarar al pedo
            adyacentes.comenzar();
            while ((!adyacentes.fin()) && cuadrado.getDato()==0) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
                Arista<T> actual = adyacentes.proximo();
                int pos=actual.verticeDestino().posicion();
                if (!marca[pos])
                    subgrafoCuadradoRecursivo(cuadrado, longitud+1, grafo, vIni, actual.verticeDestino(), marca);
            }
        }
        marca[vAct.posicion()]=false;//para poder analizar otros casos
    }

    public int getGrado(Grafo<T> grafo) {
        int gradoMax=0, gradoAct;
        if (!grafo.esVacio() && grafo!=null) {
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
    //otra forma más eficiente
    public int getGrado2(Grafo<T> grafo) {
        int grados[] = new int[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
          Vertice<T> vertice = grafo.listaDeVertices().elemento(i);
          ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vertice);
          ady.comenzar();
          grados[i] += ady.tamanio();
          while (!ady.fin()) {
            grados[ady.proximo().verticeDestino().posicion()]++;
          }
        }
        return Arrays.stream(grados).max().getAsInt();
      }

    public boolean tieneCiclo(Grafo<T> grafo){//como ver si es cuadrado, pero si llego al origen simplemente chequeo que no sea en la 1ra vez que entro a al funcion
    boolean ciclo=false;

    if (!grafo.esVacio() && grafo!=null) {
        Peso cicloInt = new Peso();
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];//se inicia en false automaticamente
        cicloInt.setDato(0);
        Vertice<T> v;

        while(ciclo==false && !grafo.listaDeVertices().fin()){//porque no me anda con proximo?
            v=grafo.listaDeVertices().proximo();
            tieneCicloRecursivo(cicloInt, 0, grafo, v, v, marca);
        }
        if(cicloInt.getDato()==1)
            ciclo=true;
    }
    
    return ciclo;
    }
    
    private void tieneCicloRecursivo(Peso ciclo, int longitud, Grafo<T> grafo, Vertice<T> vIni, Vertice<T> vAct, boolean[] marca) {

        if(!vIni.dato().equals(vAct.dato()))//no marco en true el vertice del inicio para poder chequear el ciclo pasando po el inicio
            marca[vAct.posicion()] = true;

        if (vIni.dato().equals(vAct.dato())&& longitud!=0)//si llega a ser un grafo de enteros, me sirve equlas si uso el wrapper Integer//si volvió de donde vino y el camino fue de 4
            ciclo.setDato(1);
        else{
            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vAct);//no las declaro antes para no declarar al pedo
            adyacentes.comenzar();
            while ((!adyacentes.fin()) && ciclo.getDato()==0) {//mejor un while que un for, me aseguro de estar preguntando con el vertice que quiero
                Arista<T> actual = adyacentes.proximo();
                int pos=actual.verticeDestino().posicion();
                if (!marca[pos]){
                    tieneCicloRecursivo(ciclo, longitud+1, grafo, vIni, actual.verticeDestino(), marca);
                }
            }
        }
        marca[vIni.posicion()]=false;
    }

}
