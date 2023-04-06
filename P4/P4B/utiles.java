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
        int cont=0;
        ArbolBinario<Integer> nodo_act=null;//no olvidar de inicializarlo
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();

        cola.encolar(arbol);//encol raiz
        cola.encolar(null);//paso de nivel

        while(cola.esVacia()==false){
            nodo_act=cola.desencolar();
            if(nodo_act!=null){
                System.out.println(nodo_act.getDato());
                if(arbol.tieneHijoIzquierdo())
                    cola.encolar(nodo_act.getHijoIzquierdo());
                if(nodo_act.tieneHijoDerecho())
                    cola.encolar(nodo_act.getHijoDerecho());
            }
            else{
                System.out.println(" // ");
                if (cola.esVacia()==false)
                    cola.encolar(null);//para el salto del inea
            }
        return cont;
    }

}
