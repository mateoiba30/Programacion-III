public class Gematria {
    public int contar(ArbolGeneral<Integer> arbol, int valor){
        int cont_c=0;
        if(arbol!=null)
            cont_c=contarRecursivo( arbol, valor);
        return cont_c;
    }

    private int contarRecursivo( ArbolGeneral<Integer> arbol, int valor){
        int cont_act =0;
        cont_act+= arbol.getDato();

        if(arbol.esHoja() && cont_act==valor)
            return 1;
        if(arbol.esHoja())
            return 0;

        int cont_c=0;
        if(cont_c>0){
            ListaGenerica<ArbolGeneral<Integer>> lHijos = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
            lHijos=arbol.getHijos();
            int reps=lHijos.tamanio();
            for(int i=0; i<reps; i++){
                ArbolGeneral<Integer> aux = lHijos.elemento(i);
                if(cont_act<=valor)
                    cont_c+=contarRecursivo(aux, valor);
            }
        }
        
        return cont_c;
    }
    
}
