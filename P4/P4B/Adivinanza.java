public class Adivinanza {
    //elegir a alquien del ultimo nivel y poenrlo en la lista al inicio
    //volver a recorrer el arbol hasta encontrar a un nodo que en uno de sus hijos tenga al último elemento de la lista
    //repetir hasta que mande a la lista la raíz

    // //VERSION MATEO, es mejor resolver así, es como hacer todo en el listaderaiz
    // public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
    //     ListaGenericaEnlazada<String> izq= new ListaGenericaEnlazada<String>();
    //     ListaGenericaEnlazada<String> der= new ListaGenericaEnlazada<String>();
    //     if (abinario.esHoja()) {
    //       ListaGenericaEnlazada<String> res = new ListaGenericaEnlazada<String>();
    //       res.agregarInicio(abinario.getDato());
    //       return res;
    //     }
    //     //tengo todos los recorridos, recorriendo recursivamente
    //     if (abinario.tieneHijoIzquierdo()) {
    //       izq = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
    //     }
    //     if (abinario.tieneHijoDerecho()) {
    //       der = secuenciaConMasPreguntas(abinario.getHijoDerecho());
    //     }

    //     if (izq.tamanio() >= der.tamanio()) {
    //     //   izq.agregarInicio("Si");
    //       izq.agregarInicio(abinario.getDato());
    //       return izq;
    //     } else {
    //     //   der.agregarInicio("No");
    //       der.agregarInicio(abinario.getDato());
    //       return der;
    //     }
    //     //devuelvo la rama más larga de cada raíz
    //   }

        public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario){
            String raiz= new String();
            String padre= new String();
            String hijo= new String();
            ListaGenericaEnlazada<String> lista_max = new ListaGenericaEnlazada<String>();
            // l=abinario.frontera();//tengo lista de las hojas
            // lista_max.agregarInicio(l.elemento(0));//tengo una hoja
            //no busco con frontera ni de otra forma porque solo me sirven las hojas del ultimo nivel, recorrido por niveles
            raiz=abinario.getDato();
            hijo=buscarHojaLejana(abinario);
            lista_max.agregarInicio(hijo);//agrego hoja
    
            // while(hijo!=null && !hijo.equals(raiz)){//voy agregando elementos a la lista hasta que llegue a la raiz
            //     hijo=lista_max.elemento(0);
            //     padre=buscarPadre(abinario, hijo);
            //     lista_max.agregarInicio(padre);
            // }
    
            // return lista_max;
            return listaDesdeRaiz(abinario, buscarHojaLejana(abinario));
        }
    
        public String buscarHojaLejana(ArbolBinario<String> abinario){
            String respuesta = new String();
            ArbolBinario<String> nodo_act=null;//no olvidar de inicializarlo
            ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
    
            respuesta="";
            cola.encolar(abinario);//encol raiz
            cola.encolar(null);//paso de nivel
    
            while(cola.esVacia()==false){
                nodo_act=cola.desencolar();
                if(nodo_act!=null){
                    if(nodo_act.tieneHijoIzquierdo())
                        cola.encolar(nodo_act.getHijoIzquierdo());
                    if(nodo_act.tieneHijoDerecho())
                        cola.encolar(nodo_act.getHijoDerecho());
                    respuesta=nodo_act.getDato();//voy cargando el elmento del nivel en el que estoy, el último cargado es del ultimo nivel
                }
                else{
                    if (cola.esVacia()==false)
                        cola.encolar(null);//para el salto del inea
                }
            }
            
            if (respuesta.isEmpty())
                respuesta = nodo_act.getDato();

            return respuesta;
        }
    //no lo uso pa nada pero anda
        // public String buscarHoja(ArbolBinario<String> abinario){
        //     String respuesta = new String();
        //     if(abinario.esHoja()){
        //         return abinario.getDato();
        //     }
                
        //     else if(abinario.getDato()!=null){
        //         if (abinario.getHijoIzquierdo()!=null)
        //             respuesta= buscarHoja(abinario.getHijoIzquierdo());
        //         if (abinario.getHijoDerecho()!=null)
        //             respuesta= buscarHoja(abinario.getHijoDerecho());
                
        //     }
        //     return respuesta;
        // }
    
        //al final esta no la uso porque anda mal
        // public String buscarPadre(ArbolBinario<String> abinario, String hijo){//como buscar hoja, pero comparo a que sea distinto de un string en vez de un null
        //     String respuesta = new String();
    
        //  //   if(abinario!=null)//chequeo si le puedo preguntar si es padre-> no necesario
        //     if( (abinario.tieneHijoIzquierdo()&&(abinario.getHijoIzquierdo().getDato().equals(hijo))) || (abinario.tieneHijoDerecho()&&(abinario.getHijoDerecho().getDato().equals(hijo))) ){//if es padre
        //             return abinario.getDato();//si es el padre lo devuelvo
        //     }
        //     else if(abinario.getDato()!=null){//sinó sigo buscando, asegurandome de no llegar a null
        //         if (abinario.getHijoIzquierdo()!=null)
        //             respuesta= buscarPadre(abinario.getHijoIzquierdo(), hijo);
        //         if (abinario.getHijoDerecho()!=null)
        //             respuesta= buscarPadre(abinario.getHijoDerecho(), hijo);
                
        //     }
        //     return respuesta;
        // }

        //recibe un dato y el arbol donde se encuentra, devuelve la lista del recorrido
        public ListaGenericaEnlazada<String> listaDesdeRaiz(ArbolBinario<String> raiz, String dato) {
            ListaGenericaEnlazada<String> lista = new ListaGenericaEnlazada<String>();
            if (raiz == null) {//si no hay nada devuelvo lista vacia
                return lista;
            }
            if (raiz.getDato().equals(dato)) {//si la raiz y el daot son lo mismo devuelvo solo la raiz
                lista.agregarFinal(raiz.getDato());
                return lista;
            }
            //voy mandando el subarbol izq y der, se van acumulando pero solo agrego cuando el nodo es igual
            // al dato, sinó busca en su izq y apila el caso de la derecha
            //al final, el único caso base es cuando un camino de los apilados encuentra el dato
            //y en el camino fui guardando su recorrido
            ListaGenericaEnlazada<String> listaIzquierda = listaDesdeRaiz(raiz.getHijoIzquierdo(), dato);
            if (!listaIzquierda.esVacia()) {//solo agrega elementos a la lista que encontró al dato
                listaIzquierda.agregarEn(raiz.getDato(), 0);
                return listaIzquierda;
            }
            ListaGenericaEnlazada<String> listaDerecha = listaDesdeRaiz(raiz.getHijoDerecho(), dato);
            if (!listaDerecha.esVacia()) {
                listaDerecha.agregarEn(raiz.getDato(), 0);
                return listaDerecha;
            }
            return lista;
        }

        
//version de Mateo, es mejor resolver así
  public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntas2(ArbolBinario<String> abinario) {
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> izq = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> der = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> res = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
    //todos son lista de caminos

    if (abinario.esHoja()) {
      ListaGenericaEnlazada<String> res1 = new ListaGenericaEnlazada<String>();
      res1.agregarInicio(abinario.getDato());
      res.agregarInicio(res1);//cargo lista de listas
      return res;
    }
    if (abinario.tieneHijoIzquierdo()) {
      izq = secuenciaConMasPreguntas2(abinario.getHijoIzquierdo());
    }
    if (abinario.tieneHijoDerecho()) {
      der = secuenciaConMasPreguntas2(abinario.getHijoDerecho());
    }
//hasta acá igual que antes, tengo todos los recorridos almacenados

    izq.comenzar();
    der.comenzar();

    //para agregar la raíz a las listas
    //si no son null y la izq es mayor en su 1er camino
    if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() > der.elemento(0).tamanio())) {
      int i = 0;
      while (izq.elemento(i)!=null) {
        // izq.elemento(i).agregarInicio("Si");//no es necesario cargarle el "si"
        izq.elemento(i).agregarInicio(abinario.getDato());
        i++;
      }
      return izq;
      
      //si no son null y la der es mayor en su 1er camino
    } else if ((izq.elemento(0)!=null && der.elemento(0)!=null) && (izq.elemento(0).tamanio() < der.elemento(0).tamanio())){
        int i = 0;
        while (der.elemento(i)!=null) {
        //   der.elemento(i).agregarInicio("Si");
          der.elemento(i).agregarInicio(abinario.getDato());
          i++;
        }
        return der;
      } 

      //si son iguales o null
      else {
        int i = 0;
        while (izq.elemento(i) != null) {
         // izq.elemento(i).agregarInicio("Si"); los si no son necesarios, pero siempre el camino más largo es por la respuesta si
          izq.elemento(i).agregarInicio(abinario.getDato());//voy cargando las raíces, que en la recursion son los padres
          res.agregarFinal(izq.elemento(i));//en res voy cargando los caminos
          i++;
        }
        i = 0;
        while (der.elemento(i)!=null) {
       //   der.elemento(i).agregarInicio("Si");
          der.elemento(i).agregarInicio(abinario.getDato());//voy cargando las raíces, que en la recursion son los padres
          res.agregarFinal(der.elemento(i));//en res voy cargando los caminos
          i++;
        }
      return res;//devuelve res que tiene tanto a der como izq
    }
  }
        public ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasVersion2(ArbolBinario<String> abinario){
            ListaGenericaEnlazada<ListaGenericaEnlazada<String>> lista_secuencias = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
            ListaGenericaEnlazada<String> lista_hojas = new ListaGenericaEnlazada<String>();
            int tamanio, i;

            listaHojaLejana(abinario, lista_hojas);//lista hojas tiene las hojas lejanas
            tamanio=lista_hojas.tamanio();
            for(i=0; i<tamanio; i++){//voy cargando la lista de listas de recorridos
                lista_secuencias.agregarFinal( listaDesdeRaiz(abinario, lista_hojas.elemento(i)) );
                System.out.println("secuencia de la hoja "+lista_hojas.elemento(i)+" = "+listaDesdeRaiz(abinario, lista_hojas.elemento(i)) );
            }
            return lista_secuencias;
        }

        public ListaGenericaEnlazada<String> listaHojaLejana(ArbolBinario<String> abinario,ListaGenericaEnlazada<String> lista_hojas){
            ArbolBinario<String> nodo_act=null;//no olvidar de inicializarlo
            ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
            int profundidad_max=0;

            profundidad_max=calcularProfundidadMax(abinario) - 1;//lo podría haber e¿hecho en el recorrido por niveles
            System.out.println("max prof "+profundidad_max);
            cola.encolar(abinario);//encol raiz
            cola.encolar(null);//paso de nivel
    
            while(cola.esVacia()==false){
                nodo_act=cola.desencolar();
                if(nodo_act!=null){
                    if(nodo_act.tieneHijoIzquierdo())
                        cola.encolar(nodo_act.getHijoIzquierdo());
                    if(nodo_act.tieneHijoDerecho())
                        cola.encolar(nodo_act.getHijoDerecho());
                    if(calcularProfundidad(abinario, nodo_act.getDato())==profundidad_max){
                        lista_hojas.agregarFinal(nodo_act.getDato());//voy cargando el elmento del nivel en el que estoy, el último cargado es del ultimo nivel
                        System.out.println("nodo lejano: "+nodo_act.getDato());
                    }
                }
                else{
                    if (cola.esVacia()==false)
                        cola.encolar(null);//para el salto del inea
                }
            }


            return lista_hojas;
        }

        public int calcularProfundidadMax(ArbolBinario<String> arbol){
            int profundidad=0;
            ArbolBinario<String> nodo_act=null;//no olvidar de inicializarlo
            ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
    
            cola.encolar(arbol);//encol raiz
            cola.encolar(null);//paso de nivel
    
            while(cola.esVacia()==false){
                nodo_act=cola.desencolar();
                if(nodo_act!=null){
                    if(nodo_act.tieneHijoIzquierdo())
                        cola.encolar(nodo_act.getHijoIzquierdo());
                    if(nodo_act.tieneHijoDerecho())
                        cola.encolar(nodo_act.getHijoDerecho());
                }
                else{
                    profundidad++;
                    if (cola.esVacia()==false)
                        cola.encolar(null);//para el salto del inea
                }
            }
    
            return profundidad;
        }
    

        public int calcularProfundidad(ArbolBinario<String> arbol, String dato){
            int profundidad=0;
            ArbolBinario<String> nodo_act=null;//no olvidar de inicializarlo
            ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();
    
            cola.encolar(arbol);//encol raiz
            cola.encolar(null);//paso de nivel
    
            while(cola.esVacia()==false && (nodo_act==null || nodo_act.getDato()!=dato)){
                nodo_act=cola.desencolar();
                if(nodo_act!=null){
                    if(nodo_act.tieneHijoIzquierdo())
                        cola.encolar(nodo_act.getHijoIzquierdo());
                    if(nodo_act.tieneHijoDerecho())
                        cola.encolar(nodo_act.getHijoDerecho());
                }
                else{
                    profundidad++;
                    if (cola.esVacia()==false)
                        cola.encolar(null);//para el salto del inea
                }
            }
    
            return profundidad;
        }
}
    
    
