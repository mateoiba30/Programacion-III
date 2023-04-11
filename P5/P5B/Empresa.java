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

    public int categoriaConMasEmpleados(){
        return 0;
    }

    public int cantidadTotalDeEmpleados(){
        return 0;
    }   

    public void reemplazarPresidente(){

    }


    public int empleadosPorCategoria(int categoria){

        ColaGenerica<ArbolGeneral<Empleado>> cola= new ColaGenerica<ArbolGeneral<Empleado>>();
		ArbolGeneral<Empleado> arbol_aux;
    	ListaGenerica<ArbolGeneral<Empleado>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
        int niveles=0, contador=0;
        categoria--;//para que coincida con el nivel

        if(categoria==0)
            return 1;
		if(this.empleados.esHoja())
            return 0;

        hijos=this.empleados.getHijos();
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();

            if (arbol_aux!=null && arbol_aux.tieneHijos()) {
                hijos=arbol_aux.getHijos();//paso los hijos a la lista
                hijos.comenzar();//empezar a recorrer por el inicio
                niveles++;//acá es donde paso de nivel, al saber que tiene hijos y los pienso cargar
                if(categoria==niveles)
                    while (!hijos.fin()) {
                        contador++;
                        cola.encolar(hijos.proximo());//voy encolando los hijos del actual
                    }
                else
                    while (!hijos.fin())
                        cola.encolar(hijos.proximo());//voy encolando los hijos del actual
            
                cola.encolar(null);//cambio de nivel
                
            }
            // else
            //     niveles++;//si no era la raiz incremento el nivel
            // acá ya es tarde para cambiar de nivel
            
        }

        return contador;
    }
}
