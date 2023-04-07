public class utiles {
    
    public utiles(){

    }
    public int sumaMaximaVertical(ArbolBinario<Integer> arbol){
        int cont=0;
        return sumaMaximaVertical2(arbol, cont);
    }

    public int sumaMaximaVertical2(ArbolBinario<Integer> arbol, int cont){
        //recibe contador en cero
        //es como un pre orden, primero comparo y luego avanzo en ambas raíces
        //no comparo entre hermanos, comparo entre la suma del subarbol izq y el der
        //caso base-> hoja
        int contIzq=0, contDer=0;
        if(arbol.esVacio())//si no tiene nada ya termine y no quiero entrar en error
        //en estos casos, preguntar si es null o si es vacío es lo mismo, porque si no tiene un valor es porque es hoja
            return cont;
        
        cont=cont + arbol.getDato();
        if(arbol.esHoja())//si es hoja, al sumar su valor ya terminamos porque no hay hijos
            return cont;

        contIzq=sumaMaximaVertical(arbol.getHijoIzquierdo());//no hace falta preguntar si es null porque la misma funcion filtra los null
        contDer=sumaMaximaVertical(arbol.getHijoDerecho());//tmb podría llamar a la funcion 2, llevando en este caso a contDer

        if(contIzq<=contDer)//si no tiene uno de estos hijos no hay drama porque el contador será cero
            cont=cont+contDer;
        else
            cont=cont+contIzq;
        return cont;
    }

    public int sumaHorizontalMax(ArbolBinario<Integer> arbol){
        //recorrido por niveles
        //iterativo no recursivo
        //la cola debe ser de arboles de numeros, no de los numeros
        //una cola es una lista, que tiene métodos que me facilitan las acciones que busco
        int cont=0, cont_nivel=-1;//el primer nivel es el cero, el de la raiz
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
        ArbolBinario<Integer> nodo_act = new ArbolBinario<Integer>();

        cola.encolar(arbol);//encol raiz
        cola.encolar(null);//paso de nivel

        while(cola.esVacia()==false){
            nodo_act=cola.desencolar();
            if(nodo_act!=null){
                cont=cont+nodo_act.getDato();
                if(nodo_act.tieneHijoIzquierdo())
                    cola.encolar(nodo_act.getHijoIzquierdo());
                if(nodo_act.tieneHijoDerecho())
                    cola.encolar(nodo_act.getHijoDerecho());
            }
            else{//cambio de nivel
                cont_nivel++;
                System.out.println("suma nivel "+cont_nivel+" = "+cont);
                cont=0;               
                if (cola.esVacia()==false)//si siguen habiendo niveles sigo encolando
                    cola.encolar(null);
            }
		}

        return cont;
    }

    public ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> arbol){
        ListaGenericaEnlazada<Integer> lista_hojas = new ListaGenericaEnlazada<Integer>();
        ListaGenericaEnlazada<Integer> lista_trayectoria = new ListaGenericaEnlazada<Integer>();
        int i, raiz, padre, hijo, nivel, trayectoria=0;

        lista_hojas=arbol.frontera();
        raiz=arbol.getDato();
        for(i=0; i<lista_hojas.tamanio(); i++){
            hijo=lista_hojas.elemento(i);
            lista_trayectoria.agregarInicio(hijo);//agrego hoja
            nivel=0;
            trayectoria=0;
            while(hijo!=raiz){//voy agregando elementos a la lista hasta que llegue a la raiz
                hijo=lista_trayectoria.elemento(0);
                padre=buscarPadre(arbol, hijo);
                trayectoria=trayectoria+ padre*nivel;
                nivel++;
                System.out.println(trayectoria);
            }
            lista_trayectoria.agregarInicio(trayectoria);

        }

        return lista_trayectoria;
    }

    // public Integer buscarPadre(ArbolBinario<Integer> abinario, Integer hijo){//como buscar hoja, pero comparo a que sea distinto de un string en vez de un null
    //     int respuesta=0;

    //  //   if(abinario!=null)//chequeo si le puedo preguntar si es padre-> no necesario
    //     if( (abinario.tieneHijoIzquierdo()&&(abinario.getHijoIzquierdo().getDato()==hijo)) || (abinario.tieneHijoDerecho()&&(abinario.getHijoDerecho().getDato()==hijo)) ){//if es padre
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

    public ListaGenericaEnlazada<Integer> listaDesdeRaiz(ArbolBinario<Integer> raiz, int dato) {
        ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
        if (raiz == null) {
            return lista;
        }
        if (raiz.getDato() == dato) {
            lista.agregarFinal(raiz.getDato());
            return lista;
        }
        ListaGenericaEnlazada<Integer> listaIzquierda = listaDesdeRaiz(raiz.getHijoIzquierdo(), dato);
        if (!listaIzquierda.esVacia()) {
            listaIzquierda.agregarEn(0, raiz.getDato());
            return listaIzquierda;
        }
        ListaGenericaEnlazada<Integer> listaDerecha = listaDesdeRaiz(raiz.getHijoDerecho(), dato);
        if (!listaDerecha.esVacia()) {
            listaDerecha.agregarEn(0, raiz.getDato());
            return listaDerecha;
        }
        return lista;
    }

}
