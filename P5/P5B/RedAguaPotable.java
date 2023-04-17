public class RedAguaPotable {
    private float litros;
    private ArbolGeneral<Float> red = new ArbolGeneral<Float>();

    public void setLitros(float litros){

        this.litros=litros;
    
    }
    
    public float getLitros(){
    
        return litros;
    
    }
    
    public void setRed(ArbolGeneral<Float> red){
    
        this.red=red;
    
    }
    
    public ArbolGeneral<Float> getRed(){
    
        return red;
    
    }


public void recibirConfiguracion(float n, ArbolGeneral<Float> configuracion){
    this.setRed(configuracion);

    //pregunto cuantos hijos tiene, paso de nivel
    //hago un recorrido por nieveles e incerto el valor del padre/hijos
    //hasta llegar al último nivel
    //en cada nivel todos tienen el mismo valor

    ColaGenerica<ArbolGeneral<Float>> cola= new ColaGenerica<ArbolGeneral<Float>>();
    ArbolGeneral<Float> arbol_aux  = new ArbolGeneral<Float>();
    ListaGenerica<ArbolGeneral<Float>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Float>>();
    int elementos=0;

    if(this.red.esHoja())
        this.red.setDato(n);
    else{
		hijos=this.red.getHijos();
	    cola.encolar(this.red);
        this.red.setDato(n);
		cola.encolar(null);
        n/=hijos.tamanio();

		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
            if(arbol_aux!=null)
                arbol_aux.setDato(n); 
            else
                n/=elementos; 
            if (arbol_aux!=null && arbol_aux.tieneHijos()) {//encolo hijos y null, no cargar datos acá, porque se fija además si tiene hijos
                hijos=arbol_aux.getHijos();
                hijos.comenzar();
                elementos=0;
                while (!hijos.fin()) {
                    elementos++;
                    cola.encolar(hijos.proximo());//voy encolando los hijos del actual
                }
                cola.encolar(null);//cambio de nivel
            }
            // else
            //     n/=elementos;//leí null, cambié de nivel
			}
		}
    }


    public void imprimirRed(){
	ColaGenerica<ArbolGeneral<Float>> cola= new ColaGenerica<ArbolGeneral<Float>>();
    ArbolGeneral<Float> arbol_aux  = new ArbolGeneral<Float>();
    ListaGenerica<ArbolGeneral<Float>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Float>>();

    if(this.red.esHoja())
        System.out.println(this.red.getDato());
    else{
		hijos=this.red.getHijos();
	    cola.encolar(this.red);
		cola.encolar(null);

		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
            if (arbol_aux!=null && arbol_aux.tieneHijos()) {//encolo hijos y null
                System.out.println(arbol_aux.getDato());
                hijos=arbol_aux.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.encolar(hijos.proximo());//voy encolando los hijos del actual
                }
                cola.encolar(null);//cambio de nivel
            }
            else
                System.out.println("----------------");//leí null, cambié de nivel
			}
		}
}

    public float minimo(){
        float min=9999;
        //el minimo está seguro en el último nivel-> NO
        //el minimo es una hoja, pero no se cual
        ColaGenerica<ArbolGeneral<Float>> cola= new ColaGenerica<ArbolGeneral<Float>>();
        ArbolGeneral<Float> arbol_aux  = new ArbolGeneral<Float>();
        ListaGenerica<ArbolGeneral<Float>> hijos =new ListaGenericaEnlazada<ArbolGeneral<Float>>();
    
        if(this.red.esHoja())
            System.out.println(this.red.getDato());
        else{
            hijos=this.red.getHijos();
            cola.encolar(this.red);
            cola.encolar(null);
    
            while (!cola.esVacia()) {
                arbol_aux = cola.desencolar();
                if (arbol_aux!=null && arbol_aux.tieneHijos()) {//encolo hijos y null
                    hijos=arbol_aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());//voy encolando los hijos del actual
                    }
                    cola.encolar(null);//cambio de nivel
                }
                else
                    if(arbol_aux!=null && !arbol_aux.tieneHijos()){
                        if(arbol_aux.getDato()<=min)
                            min=arbol_aux.getDato();

                    }
                    
                }
            }



        return min;
    }

    //otra forma de hacerlo
    // public static double minCaudal(ArbolGeneral<Double> a , double n) {
    //     if(a.esHoja())
    //       return n;
        
    //     double min = Double.MAX_VALUE;
    //     double m = n / a.getHijos().tamanio();
    //       for (int i = 0; i < a.getHijos().tamanio(); i++) {
    //         double l = minCaudal(a.getHijos().elemento(i), m); //mando a recursion a todos los hijos
    //         if (l < min) {si es mínimo actualizo
    //           min = l;
    //         }
    //       }
    //     return min; 
    //   }
      
    // }

    //otra forma

//     public Double litrosMin(Double l) {
//         Double min = calc(red, l);
//         return min;
//     }

//     /*El caso base para este metodo recursivo es que el la hoja actual sea una hoja perteneciente al ultimo nivel del arbol, en ese caso se asume que se recorrio el camino 
//     mas largo para llegar a ella y por lo tanto la mayor cantidad de subdiviciones que se pueden hacer se hicieron*/ 

//     public double calc(ArbolGeneral<Double> arbol,  double l) {
//         if (arbol.esHoja()) {
//             return l;
//         }else {
//             ListaGenerica<ArbolGeneral<Double>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Double>>();
//             Double minCaudal = Double.MAX_VALUE;
//             hijos = arbol.getHijos();
//             while (!hijos.fin()) {
//                 arbol = hijos.proximo();
//                 Double calcMin = calc(arbol,(l/hijos.tamanio()));
//                 minCaudal = Math.min(calcMin, minCaudal);
//             }
//             return minCaudal;
//         }
//        
//     }
}
