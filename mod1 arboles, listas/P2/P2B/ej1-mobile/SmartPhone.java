public class SmartPhone extends Mobile{
    private int numero;

    public SmartPhone (String marca, String modelo, String sistemaOperativo, double costo, int numero){
        super( marca,  modelo,  sistemaOperativo,  costo);
        this.numero=numero;
    }

    public void setNumero(int numero){

        this.numero=numero;
    
    }
    
    public int getNumero(){
        
        return numero;

    }
    @Override
    public boolean equals(Object o){
        boolean result=false;
        if((o!=null)&&(o instanceof SmartPhone)){
            SmartPhone t = (SmartPhone)o;//lleva de object a tablet
            if((t.getMarca().equals(this.getMarca()))&&
            (t.getSistemaOperativo().equals(this.getSistemaOperativo()))&&
            (t.getModelo().equals(this.getModelo()))&&
            (t.getCosto() == this.getCosto())&&
            (t.getNumero() == this.getNumero()))
                result=true;
        }
        return result;
    }
    public String toString(){
        String result;
        result= super.toString()+"  Numero: "+this.getNumero();
        return result;
    }
}