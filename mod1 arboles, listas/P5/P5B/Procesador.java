public class Procesador {

    private ArbolBinario<Integer> arbol;

    public void setArbol(ArbolBinario<Integer> arbol){
        this.arbol=arbol;
    }

    public ListaGenerica<ArbolBinario<Integer>> procesarArbol (){
        ListaGenerica<ArbolBinario<Integer>> lista_arboles= new  ListaGenericaEnlazada<ArbolBinario<Integer>>();
        lista_arboles.comenzar();
        if(this.arbol!=null)
            procesarArbolRecursivo(lista_arboles, this.arbol);
        return lista_arboles;
    }

    private void procesarArbolRecursivo(ListaGenerica<ArbolBinario<Integer>> lista_arboles, ArbolBinario<Integer> arbol){
        if(arbol==null)
            return;
        if(arbol.esHoja()&&arbol.getDato()==0){
            lista_arboles.agregarFinal(arbol);
            return;
        }
        int suma=0;
        if(arbol.tieneHijoIzquierdo())
            suma+=arbol.getHijoIzquierdo().getDato();
        if(arbol.tieneHijoDerecho())
            suma+=arbol.getHijoDerecho().getDato();
        if(arbol.getDato()<=suma)
            lista_arboles.agregarFinal(arbol);
        
        procesarArbolRecursivo(lista_arboles, arbol.getHijoIzquierdo());
        procesarArbolRecursivo(lista_arboles, arbol.getHijoDerecho());

    }
    
}
