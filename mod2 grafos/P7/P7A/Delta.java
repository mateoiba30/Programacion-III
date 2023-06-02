import java.util.Arrays;//para maxislasdistintas 2


public class Delta<T> {

    public Delta(){

    }

    public int maxIslasDistintas(Grafo<String> grafo){//Seguro tiene ciclos
        int t=grafo.listaDeVertices().tamanio();
        Peso max = new Peso();
        max.setDato(0);

        if(!grafo.esVacio()){
            int visitadasDesde=0;//como es int, en el backtracking vuelve a su estado anterior
            boolean[] marca = new boolean[t];//se inicia en false automaticamente
            marca[0]=true;//nadie visita a MP, puede ser que voy por un adycente a MP, que tiene otro adyacente con posible destino a MP (ese caso no es un Max)

            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(grafo.vertice(0));//muelle principal = vertice 0
            adyacentes.comenzar();
            while (!adyacentes.fin()){
                Arista<String> actual = adyacentes.proximo();
                visitadasDesde=1;//inicia en 1, porque el primer adyacente ya es una isla nueva
                maxIslasDistintasRecursivo(max, visitadasDesde, grafo, actual.verticeDestino(), actual.verticeDestino(), marca);
            }
        }

        return max.getDato();//devuelve el maximo de un vector
    }
    //podría mandar en recursion a longitud +1 tambien, y que sea del tipo int
    private void maxIslasDistintasRecursivo(Peso max, int visitadasDesde, Grafo<String> grafo, Vertice<String> islaInicio, Vertice<String> islaAct, boolean[] marca) {
        marca[islaAct.posicion()] = true;//si marco el vertice de inicio no cambia
   
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(islaAct);//no las declaro antes para no declarar al pedo
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> actual = adyacentes.proximo();
            int pos=actual.verticeDestino().posicion();
            if (!marca[pos] && pos!=0){//no ir al muelle principal, me veulvo al terminar por donde vine
                visitadasDesde++;
                maxIslasDistintasRecursivo(max, visitadasDesde, grafo, islaInicio, actual.verticeDestino(), marca);
            }
            if(visitadasDesde>max.getDato())
                max.setDato(visitadasDesde);
        }
    }

    public int maxIslasDistintas2(Grafo<T> grafo) {
        Vertice<T> v = grafo.listaDeVertices().elemento(0);
        int[] islas = new int[grafo.listaDeAdyacentes(v).tamanio()];
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        marca[0] = true;
        int i = 0;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
          Arista<T> arista = ady.proximo();
        //   if (!marca[arista.verticeDestino().posicion()]) //no necesario
            maxIslasDistintas3(grafo, arista.verticeDestino(), marca, islas, i);
          
          islas[i]++;//lo malo es que guardo 1 contador por cada vertice, mejor la anterior solucion
          i++;//la i no representa exactamente la pósicion del vertice actual. Es como si ahora cada vertice tiene un nuevo id que es la posicion elk la lista de adyacencias del muelle principal
        }
        return Arrays.stream(islas).max().getAsInt();//devuelve el maximo de un vector de numeros
      }
    
      private void maxIslasDistintas3(Grafo<T> grafo, Vertice<T> v, boolean[] marca, int[] islas, int i) {
        marca[v.posicion()] = true;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
          Arista<T> arista = ady.proximo();
          if (!marca[arista.verticeDestino().posicion()]) {
            islas[i]++;
            maxIslasDistintas3(grafo, arista.verticeDestino(), marca, islas, i);
          }
        }
      }
}
