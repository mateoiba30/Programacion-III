public class Trie extends ArbolGeneral<Character>{

    private ArbolGeneral<Character> arbol;// lo más sencillo es hacer un dato del tipo arbolgral de char

    public ArbolGeneral<Character> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolGeneral<Character> arbol) {
        this.arbol = arbol;
    }

    
    public ListaGenerica<StringBuilder> palabrasQueEmpiezanCon(String prefijo)

        //tengo un nodo, verifico si el caracter que estoy analizando se encuentra entre sus hijos
        //si se encuentra avanzo de caracter y llamo a la función con el nodo padre, si no encontré el padre lo creo
        //recursion con nodo act, pos de la palabra, palabra

        // System.out.println(palabra.length());
        agregarPalabraRecursivo(this.arbol, 0, prefijo,  prefijo.length());
    }
    
    public ListaGenerica<ListaGenerica<Character>> palabrasQueEmpiezanConRecursivo(ArbolGeneral<Character> nodo_act, int pos_act, String palabra, int long_palabra){
    
        char char_act;
        int tamanio, i=0;
        ListaGenerica<ArbolGeneral<Character>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Character>>();

        if(pos_act>=long_palabra){//encontre todos los prefijos, debo mandar todas las palabras

		    ListaGenerica<ListaGenerica<Character>> lista_caminos = new ListaGenericaEnlazada<ListaGenerica<Character>>();
            nodo_act.todosLosCaminos(lista_caminos);
            return lista_caminos;
        }

        char_act=palabra.charAt(pos_act);//veo caracter actual
        hijos=nodo_act.getHijos();//lista de hijos
        tamanio=hijos.tamanio();//uso el tamanio para no llegar a null

        hijos.comenzar();
        while(i<tamanio && hijos.elemento(i).getDato() != char_act)//cada vez que quiero ver un dato en una lista, primero ver que no sea null o asegurar me de no pasarme del tamanio
            i++;

        if(i<tamanio){//encontre, debo seguir
            nodo_act=hijos.elemento(i);//encontre, me quedo con ese padre y sigo terminando el prefijo
        }
        else
            return;//si no encuentro el prefijo me vuelvo

        pos_act++;//avanzo de caracter
        agregarPalabraRecursivo(nodo_act, pos_act, palabra, long_palabra);
    }
        
    
    // public ListaGenerica<StringBuilder> palabrasQueEmpiezanCon(String prefijo){

    //     ListaGenerica<StringBuilder> lista_palabras = new ListaGenericaEnlazada<StringBuilder>();
    //     StringBuilder x = new StringBuilder();
    //     x.append("");
    //     lista_palabras.agregarInicio(x);


    //     return lista_palabras;
    // }

    // private ListaGenerica<StringBuilder> palabrasQueEmpiezanConRec(String prefijo){


    // }

    public void agregarPalabra(String palabra){
        //tengo un nodo, verifico si el caracter que estoy analizando se encuentra entre sus hijos
        //si se encuentra avanzo de caracter y llamo a la función con el nodo padre, si no encontré el padre lo creo
        //recursion con nodo act, pos de la palabra, palabra

        // System.out.println(palabra.length());
        agregarPalabraRecursivo(this.arbol, 0, palabra,  palabra.length());
    }
    
    public void agregarPalabraRecursivo(ArbolGeneral<Character> nodo_act, int pos_act, String palabra, int long_palabra){
    
        char char_act;
        int tamanio, i=0;
        ListaGenerica<ArbolGeneral<Character>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Character>>();

        if(pos_act>=long_palabra )//caso base termine con la palabra
            return;

        char_act=palabra.charAt(pos_act);//veo caracter actual
        hijos=nodo_act.getHijos();//lista de hijos
        tamanio=hijos.tamanio();//uso el tamanio para no llegar a null

        hijos.comenzar();
        while(i<tamanio && hijos.elemento(i).getDato() < char_act)//cada vez que quiero ver un dato en una lista, primero ver que no sea null o asegurar me de no pasarme del tamanio
            i++;

        if(i<tamanio && hijos.elemento(i).getDato() != char_act){//no encontre, debo crear
            ArbolGeneral<Character> nuevo_nodo = new ArbolGeneral<Character>();//o le pongo Trie que es lo mismo
            nuevo_nodo.setDato(char_act);//agergo caracter porque no estaba
            hijos.agregarEn(nuevo_nodo, i);//si en hijos no está, en hijos agrego
            nodo_act=nuevo_nodo;//actualizo el nodo padre
        }
        else
            if(i==tamanio){//si qued'e a final no ingreso en la pos i, porque i es igual al tamanio, pero esa última pos es tamanio-1
                ArbolGeneral<Character> nuevo_nodo = new ArbolGeneral<Character>();//o le pongo Trie que es lo mismo
                nuevo_nodo.setDato(char_act);//agergo caracter porque no estaba
                hijos.agregarFinal(nuevo_nodo);//si en hijos no está, en hijos agrego
                nodo_act=nuevo_nodo;//actualizo el nodo padre   
            }

            nodo_act=hijos.elemento(i);//encontre, me quedo con ese padre

        pos_act++;//avanzo de caracter
        agregarPalabraRecursivo(nodo_act, pos_act, palabra, long_palabra);
    }
        
    }



