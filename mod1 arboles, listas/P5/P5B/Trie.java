// import java.util.List;
// import java.util.ArrayList;

public class Trie extends ArbolGeneral<Character>{

    private ArbolGeneral<Character> arbol;// lo más sencillo es hacer un dato del tipo arbolgral de char

    public ArbolGeneral<Character> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolGeneral<Character> arbol) {
        this.arbol = arbol;
    }

    
    public ListaGenerica<ListaGenerica<Character>> palabrasQueEmpiezanCon(String prefijo){

        ListaGenerica<ListaGenerica<Character>> lista_caminos= new ListaGenericaEnlazada<ListaGenerica<Character>>();
        lista_caminos=palabrasQueEmpiezanConRecursivo(this.arbol, 0, prefijo,  prefijo.length());
        // System.out.println(lista_caminos.toString());//hasta acá me devuelve todos los caminos que empiezan con el prefijo

        // ListaGenerica<StringBuilder> lista_palabras = new ListaGenericaEnlazada<StringBuilder>();

        // int reps = lista_caminos.tamanio();
        // for(int i=0; i<reps; i++){
        //     int caracts= lista_caminos.proximo().tamanio(); 
        //     StringBuilder palabra=new StringBuilder("");
        //     for(int j=0; j<caracts; j++){
        //         palabra.append(lista_caminos.elemento(i).elemento(j));
        //     }
        //     lista_palabras.elemento(i).append(palabra);
        // }

        int longitud=prefijo.length() -2;//resto uno para obtener la pos, y rtesto otro porque el ultimo me lo informa

        int reps=lista_caminos.tamanio();
        for(int i=0; i<reps; i++){
            for(int j=longitud; j>=0; j--)//cargo en revrsa poniendo el caracter del rpefijo en ala palabra
                lista_caminos.elemento(i).agregarInicio(prefijo.charAt(j));
        }

        return lista_caminos;
    }
    
    public ListaGenerica<ListaGenerica<Character>> palabrasQueEmpiezanConRecursivo(ArbolGeneral<Character> nodo_act, int pos_act, String palabra, int long_palabra){
    
        char char_act;
        int tamanio, i=0;
        ListaGenerica<ArbolGeneral<Character>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Character>>();
        ListaGenerica<ListaGenerica<Character>> lista_caminos = new ListaGenericaEnlazada<ListaGenerica<Character>>();

        if(pos_act>=long_palabra){//encontre todos los prefijos, debo mandar todas las palabras
            lista_caminos=nodo_act.todosLosCaminos();
        }
        else{
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
                return lista_caminos;//si no encuentro el prefijo me vuelvo

            pos_act++;//avanzo de caracter
            lista_caminos=palabrasQueEmpiezanConRecursivo(nodo_act, pos_act, palabra, long_palabra);
        }

    return lista_caminos;
    }

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
            // nodo_act=nuevo_nodo;//actualizo el nodo padre
        }
        else
            if(i==tamanio){//si qued'e a final no ingreso en la pos i, porque i es igual al tamanio, pero esa última pos es tamanio-1
                ArbolGeneral<Character> nuevo_nodo = new ArbolGeneral<Character>();//o le pongo Trie que es lo mismo
                nuevo_nodo.setDato(char_act);//agergo caracter porque no estaba
                hijos.agregarFinal(nuevo_nodo);//si en hijos no está, en hijos agrego
                // nodo_act=nuevo_nodo;//actualizo el nodo padre   
            }

            nodo_act=hijos.elemento(i);//encontre, me quedo con ese padre
            //si me había pasado del tamanio, ahora la i es el últmo

        pos_act++;//avanzo de caracter
        agregarPalabraRecursivo(nodo_act, pos_act, palabra, long_palabra);
    }
        
    }



