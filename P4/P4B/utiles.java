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
        if(arbol==null)//si no tiene nada ya termine y no quiero entrar en error
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
}
