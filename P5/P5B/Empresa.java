public class Empresa {
    private ArbolGeneral<Empleado> empleados;

    public void setEmpleados(ArbolGeneral<Empleado> empleados){

        this.empleados=empleados;
    
    }
    
    public ArbolGeneral<Empleado> getEmpleados(){
    
        return empleados;
    
    }

    public ListaGenerica<Integer> empleadosPorCategoria(){
        ListaGenerica<Integer> lista_empleados=new ListaGenericaEnlazada<Integer>();

        return lista_empleados;
    }

    public int cantidadTotalDeEmpleados(){
        return 0;
    }   

    public void reemplazarPresidente(){

    }

    public int categoriaConMasEmpleados(){

        
        ListaGenerica<ArbolGeneral<Empleado>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
        ColaGenerica<ArbolGeneral<Empleado>> cola= new ColaGenerica<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> arbol_aux;
        int niveles=0, contador=0, cat_max=0, cont_max=-999;//para que coincida con el nivel

		if(this.empleados.esHoja())
            return 0;

        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if(arbol_aux!=null){
                contador++;
                if (arbol_aux.tieneHijos()) {
                    hijos=arbol_aux.getHijos();//paso los hijos a la lista
                    hijos.comenzar();//empezar a recorrer por el inicio
                    while (!hijos.fin())
                        cola.encolar(hijos.proximo());//voy encolando los hijos del actual
                    //si tengo dos subgerentes no tiene sentido encolar el null, lo hago luego
                }  
            }
            else {
                    if(!cola.esVacia())//si no es vacía sigo operando
                        cola.encolar(null);//cambio de nivel
                        
                    //aunque sea vacía debo aumentar el nivel para ver si este último es el máximo
                    niveles++;//acá es donde paso de nivel, al saber que tiene hijos y los pienso cargar

                    if (contador>cont_max){
                        cont_max=contador;
                        cat_max=niveles;//el nivel de la ríz es 0, mientras que su catogoría es 1, por eso antes aumento el nivel
                        System.out.println("nueva cat max: "+cat_max+" con "+cont_max+" empleados");
                    }
                    
                    contador=0;
                
            }
            
        }

        return cat_max;
    }


    public int empleadosPorCategoria(int categoria){

        ListaGenerica<ArbolGeneral<Empleado>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
        ColaGenerica<ArbolGeneral<Empleado>> cola= new ColaGenerica<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> arbol_aux;
        int niveles=0, contador=0;
        categoria--;//para que coincida con el nivel

        if(categoria==0)
            return 1;
		if(this.empleados.esHoja())
            return 0;

        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if(arbol_aux!=null){
                if(niveles==categoria)//cuento solo si estoy en la categoría que me piden
                    contador++;
                if (arbol_aux.tieneHijos()) {
                    hijos=arbol_aux.getHijos();//paso los hijos a la lista
                    hijos.comenzar();//empezar a recorrer por el inicio
                    while (!hijos.fin())
                        cola.encolar(hijos.proximo());//voy encolando los hijos del actual
                    //si tengo dos subgerentes no tiene sentido encolar el null, lo hago luego
                }  
            }
            else if(!cola.esVacia()){//si no es vacía sigo operando
                cola.encolar(null);//cambio de nivel

                if (niveles == categoria)
                    return contador;
                niveles++;//acá es donde paso de nivel, al saber que tiene hijos y los pienso cargar
                contador=0;
            }
            
            // else
            //     niveles++;//si no era la raiz incremento el nivel
            // acá ya es tarde para cambiar de nivel
            
        }

        return contador;
    }
    // //version de mateo
    // public int empleadosPorCategoria(int categoria) {
    //     int cant = 0;
    //     int categoriaActual = 1;
    //         ArbolGeneral<Empleado> arbol = null;
    //         ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<ArbolGeneral<Empleado>>();
    //         cola.encolar(this.getEmpleados());
    //         cola.encolar(null);
    //         while (!cola.esVacia()) {
    //             arbol = cola.desencolar();
    //       if (arbol != null) {
    //                 cant++;
    //                 if (arbol.tieneHijos()) {
    //                     ListaGenerica<ArbolGeneral<Empleado>> l = arbol.getHijos();
    //                     l.comenzar();
    //                     while (!l.fin()) {
    //                         cola.encolar(l.proximo());
    //                     }
    //                 }
    //             } 
    //             else if (!cola.esVacia()) {
    //         cola.encolar(null);
    //         if (categoriaActual == categoria) {
    //           return cant;
    //         }
    //         categoriaActual++;
    //                 cant = 0;
    //             }
    //         }
    //         return cant; //Solo ocurre si no hay empleados en la categoria/Categoria erronea
    //   }

    // 

    //convinacion de mi verison y la de mate, anda joya
    // public int empleadosPorCategoria(int categoria){


    //     ColaGenerica<ArbolGeneral<Empleado>> cola= new ColaGenerica<ArbolGeneral<Empleado>>();
	// 	ArbolGeneral<Empleado> arbol_aux;
    //     int niveles=0, contador=0;
    //     categoria--;//para que coincida con el nivel

    //     if(categoria==0)
    //         return 1;
	// 	if(this.empleados.esHoja())
    //         return 0;

    //     cola.encolar(this.empleados);
    //     cola.encolar(null);
    //     while (!cola.esVacia()) {
    //         arbol_aux = cola.desencolar();
    //         if(arbol_aux!=null){
    //             contador++;
    //             if (arbol_aux.tieneHijos()) {
    //                 ListaGenerica<ArbolGeneral<Empleado>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();//cada vez genero una lista nueva
    //                 hijos=arbol_aux.getHijos();//paso los hijos a la lista
    //                 hijos.comenzar();//empezar a recorrer por el inicio
    //                 while (!hijos.fin())
    //                     cola.encolar(hijos.proximo());//voy encolando los hijos del actual
    //             }  
    //         }
    //         else if(!cola.esVacia()){//si no es vacía sigo operando
    //             cola.encolar(null);//cambio de nivel
    //             if (niveles == categoria)
    //                 return contador;
    //             niveles++;//acá es donde paso de nivel, al saber que tiene hijos y los pienso cargar
    //             contador=0;
    //         }
            
    //         // else
    //         //     niveles++;//si no era la raiz incremento el nivel
    //         // acá ya es tarde para cambiar de nivel
            
    //     }

    //     return contador;
    // }
}
