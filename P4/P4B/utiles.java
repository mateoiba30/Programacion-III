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
        int i, trayectoria;
        lista_hojas=arbol.frontera();
        //la raiz en todos casos es la misma, por eso mando arbol
        for(i=0; i<lista_hojas.tamanio(); i++){
            trayectoria=CalculoTrayectoria(arbol, lista_hojas.elemento(i));
           // System.out.println("hoja: "+lista_hojas.elemento(i)+" con trayectoria: "+trayectoria); //pa debuguear
            lista_trayectoria.agregarInicio(trayectoria);
        }

        return lista_trayectoria;
    }

    public int CalculoTrayectoria(ArbolBinario<Integer> raiz, int dato){
        int cont=0;
        return CalculoTrayectoriaRecursivo(cont, raiz, dato);
    }

    //conviene mientras recorro ya ir aumentando el contador, en lugar de hacer una lista del recorrido 
    //y luego ir contando
    public int CalculoTrayectoriaRecursivo(int cont, ArbolBinario<Integer> raiz, int dato) {
        int contIzq=0, contDer=0;
        if (raiz == null) {
            return cont;
        }
        if (raiz.getDato() == dato) {
            cont=cont+dato;//indica que encontró
            return cont;
        }
         contIzq = CalculoTrayectoriaRecursivo(contIzq, raiz.getHijoIzquierdo(), dato);
        if (contIzq>0) {//solo aumenta si es del recorrido que encontró al dato
            contIzq=contIzq+raiz.getDato();
           // System.out.println(contIzq);
            return contIzq;
        }
         contDer = CalculoTrayectoriaRecursivo(contDer, raiz.getHijoDerecho(), dato);
        if (contDer>0) {
            contDer=contDer+raiz.getDato();
          //  System.out.println(contDer);
            return contDer;
        }
        return cont;
    }

}
