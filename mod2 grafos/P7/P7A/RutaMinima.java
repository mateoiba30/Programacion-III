public class RutaMinima {

    private ListaGenerica<String> ruta;

    private int boletosNecesarios;

    public RutaMinima(){
        this.ruta=new ListaGenericaEnlazada<String>();
        this.boletosNecesarios=0;
    }

    public ListaGenerica<String> getRuta(){
        return this.ruta;
    }

    public int getBoletos(){
        return this.boletosNecesarios;
    }

    public void setRuta(ListaGenerica<String> ruta){
        this.ruta=ruta;
    }

    public void setBoletos(int boletos){
        this.boletosNecesarios=boletos;
    }
    
}
