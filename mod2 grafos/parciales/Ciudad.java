public class Ciudad {
    
    private String nombre;
    private int limDias;
 
    public Ciudad(){

    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setLimDias(int dias){
        this.limDias=dias;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getLimDias(){
        return this.limDias;
    }

}
