public class ProcesadorDeArbol {
    private ArbolBinario<Character> arbol;
    public int procesar (int cont){
        cont=0;
        if(this.arbol==null)
            return cont;
        if(this.arbol.esHoja())
            return ++cont;
        if(this.arbol.tieneHijoIzquierdo()&& !this.arbol.tieneHijoDerecho()){
            this.arbol=this.arbol.getHijoIzquierdo();
            cont=this.procesar(cont);
        }

        if(this.arbol.tieneHijoDerecho()&& !this.arbol.tieneHijoIzquierdo()){
            this.arbol=this.arbol.getHijoDerecho();
            cont=this.procesar(cont);
        }
        return cont;
    }

    public void setArbol(ArbolBinario<Character> arbol){
        this.arbol=arbol;
    }


    public int procesar2 (int K){
        if(this.arbol==null){//esto es por si me llegan a mandar una r bol null de una
            if(K==0)        //no necesario pero aumenta eficiencia
                return 1;
            else
                return 0;
        }        

        int cont=0;
        if(this.arbol.esHoja()&&K==0)//si el camino cumple la condicion
            return 1;
        
        if(this.arbol.tieneHijoIzquierdo()&& !this.arbol.tieneHijoDerecho()){//el nodo cumple la condicion por izquierda
            this.arbol=this.arbol.getHijoIzquierdo();
            K--;
            cont+=this.procesar2(K);
        }
        else{
            if(this.arbol.tieneHijoDerecho()&& !this.arbol.tieneHijoIzquierdo()){//el nodo cumple la condicion con derecha
                this.arbol=this.arbol.getHijoDerecho();
                K--;
                cont+=this.procesar2(K);
            }
        }

        if(!this.arbol.esHoja()){//tiene ambos hijos
            ArbolBinario<Character> aux=this.arbol.getHijoDerecho();
            this.arbol=this.arbol.getHijoIzquierdo();
            cont+=this.procesar2(K);
            this.arbol=aux;
            cont+=this.procesar2(K);
        }

        return cont;
        
    }
    public int procesar3(int K){
        return procesarRec(this.arbol, K);
    }

    private int procesarRec(ArbolBinario<Character> arbol, int K){
        int cont=0;
        if((arbol==null || arbol.esHoja()) && K==0)
            return 1;
        if(arbol==null)
            return 0;
        if ((arbol.tieneHijoIzquierdo() && !arbol.tieneHijoDerecho())||(!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho()))
            K--;
        
        if(arbol.tieneHijoIzquierdo())
            cont+=procesarRec(arbol.getHijoIzquierdo(), K);
        if(arbol.tieneHijoDerecho())
            cont+=procesarRec(arbol.getHijoDerecho(), K);
        

        return cont;

    }

}
