public class Tablet {
    private String marca;
    private String sistemaOperativo;
    private String modelo;
    private double costo;
    private float pulgadas;

    public Tablet (String marca, String modelo, String sistemaOperativo, double costo, float pulgadas){
        this.modelo=modelo;
        this.sistemaOperativo=sistemaOperativo;
        this.marca=marca;
        this.costo=costo;
        this.pulgadas=pulgadas;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public void setSistemaOperativo(String sistemaOperativo){
        this.sistemaOperativo=sistemaOperativo;
    }

    public void setModelo(String modelo){
        this.modelo=modelo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setPulgadas(float pulgadas){
        this.pulgadas= pulgadas;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getSistemaOperativo(){
        return this.sistemaOperativo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public float getPulgadas(){
        return this.pulgadas;
    }

    public double getCosto(){
        return this.costo;
    }

    public void devolverDatos(){
        System.out.println("Especificaciones del dispositivo:");
        System.out.println("----Marca: "+getMarca());
        System.out.println("----Modelo: "+getModelo());
        System.out.println("----Costo: "+getCosto());
        System.out.println("----Pulgadas: "+getPulgadas());
        System.out.println("----Sistema Operativo: "+getSistemaOperativo());
    }
}