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
    float x=10;

    if(this.red.esHoja())
        this.red.setDato(n);
    else{
		hijos=this.red.getHijos();
	    cola.encolar(this.red);
        this.red.setDato(x);
		cola.encolar(null);

		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();
            if (arbol_aux!=null && arbol_aux.tieneHijos()) {//encolo hijos y null
                arbol_aux.setDato(x);
                hijos=arbol_aux.getHijos();
                hijos.comenzar();
                elementos=0;
                while (!hijos.fin()) {
                    elementos++;
                    cola.encolar(hijos.proximo());//voy encolando los hijos del actual
                }
                cola.encolar(null);//cambio de nivel
            }
            else
                n/=elementos;//leí null, cambié de nivel
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
}
