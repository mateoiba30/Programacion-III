
public class PerroGrande extends Perro {
    @Override
    public void saludo() {
        System.out.println("Guauuuuuu!");
    }
    @Override
    public void saludo(Perro otro) {
        System.out.println("Guauuuuuu! Guauuuuuu!");
    }
    public boolean esMasBuenoQue(Animal otro){
        return true;
    }
}