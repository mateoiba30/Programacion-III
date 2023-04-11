import java.util.Scanner;
public class EmpresaTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //declaro la empresa
        Empresa emp1=new Empresa();

        //declaro nodos
        ArbolGeneral<Empleado> nodo_presidente = new ArbolGeneral<Empleado>();

        ArbolGeneral<Empleado> nodo_gerente = new ArbolGeneral<Empleado>();
        ArbolGeneral<Empleado> nodo_subgerente = new ArbolGeneral<Empleado>();
        ArbolGeneral<Empleado> nodo_subgerente2 = new ArbolGeneral<Empleado>();

        ArbolGeneral<Empleado> nodo_empleado1 = new ArbolGeneral<Empleado>();
        ArbolGeneral<Empleado> nodo_empleado2 = new ArbolGeneral<Empleado>();
        ArbolGeneral<Empleado> nodo_empleado3 = new ArbolGeneral<Empleado>();
        ArbolGeneral<Empleado> nodo_empleado4 = new ArbolGeneral<Empleado>();

        //declaro elemento dentro de nodos
        Empleado e1=new Empleado();
        Empleado e2=new Empleado();
        Empleado e3=new Empleado();
        Empleado e4=new Empleado();
        Empleado e5=new Empleado();
        Empleado e6=new Empleado();
        Empleado e7=new Empleado();
        Empleado e8=new Empleado();

        //cargo datos en nodos
        nodo_presidente.setDato(e1);
        nodo_gerente.setDato(e2);
        nodo_subgerente.setDato(e3);
        nodo_empleado1.setDato(e4);
        nodo_empleado2.setDato(e5);
        nodo_subgerente2.setDato(e6);
        nodo_empleado3.setDato(e7);
        nodo_empleado4.setDato(e8);



        //junto nodos, creo arbol de empleados
        nodo_presidente.agregarHijo(nodo_gerente);
        nodo_gerente.agregarHijo(nodo_subgerente);
        nodo_gerente.agregarHijo(nodo_subgerente2);
        nodo_subgerente.agregarHijo(nodo_empleado1);
        nodo_subgerente.agregarHijo(nodo_empleado2);
        nodo_subgerente2.agregarHijo(nodo_empleado3);
        nodo_subgerente2.agregarHijo(nodo_empleado4);



        //llevo el arbol a la empresa
        emp1.setEmpleados(nodo_presidente);

        //      presi -> null
        //       /
        //      gerente -> null
        //      / 
        //      subgerente --------------------> subgerente2 -> null
        //      /                               /
        //      emp1 -> emp2 -> null           emp3 -> emp4 -> null
        
        // int aux=emp1.getEmpleados().ancho();
        // System.out.println("el ancho maximo de la empresa es: "+aux);

        System.out.println("categoria a contar: ");
        int x=in.nextInt();
        int cont= emp1.empleadosPorCategoria(x);
        System.out.println("la categoria tiene "+cont+" empleados");


        in.close();
    }
    
}
