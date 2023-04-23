public class CodigoZigZag {
    public ListaGenerica<Character> descifrarCodigo( ArbolBinario<Character> arbol, ListaGenerica<String> secuencias){
        ListaGenerica<Character> respuesta = new ListaGenericaEnlazada<Character>();
        int cantStrings = secuencias.tamanio();

        for(int i=0; i<cantStrings; i++){
            String string_act = secuencias.elemento(i);
            int caracteres = string_act.length();
            ArbolBinario<Character> nodo_act=arbol;

            for(int j=0; j<caracteres; j++){
                if(string_act.charAt(j)=='0')
                    nodo_act=nodo_act.getHijoIzquierdo();
                else
                    nodo_act=nodo_act.getHijoDerecho();
            }

            respuesta.agregarFinal(nodo_act.getDato());
        }
        return respuesta;
    }
}
