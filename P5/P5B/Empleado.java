public class Empleado {
    private String nombre;
    private int categoria;
    private int antiguedad;

    public void setNombre(String nombre){

        this.nombre=nombre;
    
    }
    
    public String getNombre(){
    
        return nombre;
    
    }
    
    public void setAntiguedad(int antiguedad){
    
        this.antiguedad=antiguedad;
    
    }
    
    public int getAntiguedad(){
    
        return antiguedad;
    
    }
    
    public void setCategoria(int categoria){
    
        this.categoria=categoria;
    
    }
    
    public int getCategoria(){
    
        return categoria;
    
    }

}
