public class Viaje {

    private ListaGenerica<String> ruta;
    private int menorPeso;

    public Viaje(){
        this.ruta=new ListaGenericaEnlazada<String>();
        this.menorPeso=9999;
    }

    public ListaGenerica<String> getRuta(){
        return this.ruta;
    }

    public int getMenorPeso(){
        return this.menorPeso;
    }

    public void setRuta(ListaGenerica<String> caminos){
        this.ruta=caminos;
    }

    public void setMenorPeso(int menorPeso){
        this.menorPeso=menorPeso;
    }
    
}
