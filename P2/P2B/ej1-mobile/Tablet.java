public class Tablet extends Mobile{
    private int pulgadas;

    public Tablet (String marca, String modelo, String sistemaOperativo, double costo, int pulgadas){
        super( marca,  modelo,  sistemaOperativo,  costo);
        this.pulgadas=pulgadas;
    }

    public void setPulgadas(int pulgadas){

        this.pulgadas=pulgadas;
    
    }
    
    public int getPulgadas(){
    
        return pulgadas;
    }

    @Override
    public boolean equals(Object o){
        boolean result=false;
        if((o!=null)&&(o instanceof Tablet)){
            Tablet t = (Tablet)o;//lleva de object a tablet
            if((t.getMarca().equals(this.getMarca()))&&
            (t.getSistemaOperativo().equals(this.getSistemaOperativo()))&&
            (t.getModelo().equals(this.getModelo()))&&
            (t.getCosto() == this.getCosto())&&
            (t.getPulgadas() == this.getPulgadas()))
                result=true;
        }
        return result;
    }

    public String toString(){
        String result;
        result= super.toString()+"  Pulgadas: "+this.getPulgadas();
        return result;
    }
}