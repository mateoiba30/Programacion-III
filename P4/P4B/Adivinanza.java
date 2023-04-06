public class Adivinanza {
//elegir a alquien del ultimo nivel y poenrlo en la lista al inicio
//volver a recorrer el arbol hasta encontrar a un nodo que en uno de sus hijos tenga al último elemento de la lista
//repetir hasta que mande a la lista la raíz
    public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario){
        String raiz= new String();
        String padre= new String();
        String hijo= new String();
        ListaGenericaEnlazada<String> l = new ListaGenericaEnlazada<String>();
        ListaGenericaEnlazada<String> lista_max = new ListaGenericaEnlazada<String>();
        ArbolBinario<String> nodo_act=null;//no olvidar de inicializarlo
        ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<ArbolBinario<String>>();

        // l=abinario.frontera();//tengo lista de las hojas
        // lista_max.agregarInicio(l.elemento(0));//tengo una hoja
        //no busco con frontera ni de otra forma porque solo me sirven las hojas del ultimo nivel, recorrido por niveles
        raiz=abinario.getDato();
        lista_max.agregarInicio(buscarHoja(abinario));//agrego hoja
        

        while(hijo!=raiz){//voy agregando elementos a la lista hasta que llegue a la raiz
            hijo=lista_max.elemento(0);
            padre=buscarPadre(abinario, hijo);
            lista_max.agregarInicio(padre);
        }

        System.out.println(lista_max.toString());
        return lista_max;

    }

    public String buscarHoja(ArbolBinario<String> abinario){
        String respuesta = new String();
        if(abinario.esHoja()){
            return abinario.getDato();
        }
            
        else if(abinario.getDato()!=null){
            if (abinario.getHijoIzquierdo()!=null)
                respuesta= buscarHoja(abinario.getHijoIzquierdo());
            if (abinario.getHijoDerecho()!=null)
                respuesta= buscarHoja(abinario.getHijoDerecho());
            
        }
        return respuesta;
    }

    public String buscarPadre(ArbolBinario<String> abinario, String hijo){//como buscar hoja, pero comparo a que sea distinto de un string en vez de un null
        String respuesta = new String();

        if((abinario!=null)&&(abinario.esHoja()==false))//chequeo si le puedo preguntar si es padre
            if(( (abinario.getHijoIzquierdo().getDato()==hijo)||(abinario.getHijoDerecho().getDato()==hijo) ) )//if es padre
                return abinario.getDato();//si es el padre lo devuelvo
        
        else if(abinario.getDato()!=null){//sinó sigo buscando, asegurandome de no llegar a null
            if (abinario.getHijoIzquierdo()!=null)
                respuesta= buscarPadre(abinario.getHijoIzquierdo(), hijo);
            if (abinario.getHijoDerecho()!=null)
                respuesta= buscarPadre(abinario.getHijoDerecho(), hijo);
            
        }
        return respuesta;
    }

}

        



