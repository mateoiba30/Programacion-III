public class Mobile {
    private String marca;
    private String sistemaOperativo;
    private String modelo;
    private double costo;

    public Mobile (String marca, String modelo, String sistemaOperativo, double costo){
        this.modelo=modelo;
        this.sistemaOperativo=sistemaOperativo;
        this.marca=marca;
        this.costo=costo;
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

    public String getMarca(){
        return this.marca;
    }

    public String getSistemaOperativo(){
        return this.sistemaOperativo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public double getCosto(){
        return this.costo;
    }

    public void devolverDatos(){
        System.out.println("Especificaciones del dispositivo:");
        System.out.println("----Marca: "+getMarca());
        System.out.println("----Modelo: "+getModelo());
        System.out.println("----Costo: "+getCosto());
        System.out.println("----Sistema Operativo: "+getSistemaOperativo());
    }

    // abstract boolean equals(Object o); abstract String toString(); YA VIENEN DE OBJECT

    @Override
    public String toString(){
        String result;
        result="Marca: "+this.getMarca()+"  Modelo: "+this.getModelo()+"  Costo: "+this.getCosto()+"  Sistema Operativo: "+this.getSistemaOperativo();
        return result;
    }
}