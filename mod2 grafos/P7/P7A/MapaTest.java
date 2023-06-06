

public class MapaTest{

	public static void main(String[] args) {//30
//		Buenos Aires <------ >Africa <------> Mexico City
//		 <|10        20    10   10|                3    400||>60
//		  |>30                    |>                      <||
//		Madrid               Sydney                  New York
//   100 |  |>10               60|                        150||>60
//		<|  |   4   5            |>   3              40     <||
//	 Jacobacci <------> Rome    Brasil <------> Beijing<---->London
//	  30 |  |>20      30|>     230/  \ 10     30         360  3||>10
//		<|  |     30    |        />   \>                      <||
//		Dubai------>Bariloche  Seoul  LaPlata               Paris
//	   10|                    90| |>50                   90 ||>30
//		 |>      70            <| |        20              <||
//		Tokyo ----------------> Berlin ------------- > Toronto

		        // Crear instancia del grafo
		        Grafo<String> grafo = new GrafoImplListAdy<>();

		        // Crear algunos vértices (ciudades)
		        Vertice<String> buenosAires = new VerticeImplListAdy<>("Buenos Aires");
		        Vertice<String> madrid = new VerticeImplListAdy<>("Madrid");
		        Vertice<String> tokyo = new VerticeImplListAdy<>("Tokyo");
		        Vertice<String> sydney = new VerticeImplListAdy<>("Sydney");
		        Vertice<String> newYork = new VerticeImplListAdy<>("New York");
		        Vertice<String> berlin = new VerticeImplListAdy<>("Berlin");
		        Vertice<String> dubai = new VerticeImplListAdy<>("Dubai");
		        Vertice<String> rome = new VerticeImplListAdy<>("Rome");
		        Vertice<String> london = new VerticeImplListAdy<>("London");
		        Vertice<String> paris = new VerticeImplListAdy<>("Paris");
		        Vertice<String> toronto = new VerticeImplListAdy<>("Toronto");
		        Vertice<String> mexicoCity = new VerticeImplListAdy<>("Mexico City");
		        Vertice<String> africa = new VerticeImplListAdy<>("Africa");
		        Vertice<String> beijing = new VerticeImplListAdy<>("Beijing");
		        Vertice<String> seoul = new VerticeImplListAdy<>("Seoul");
		        Vertice<String> jacobacci = new VerticeImplListAdy<>("Jacobacci");
		        Vertice<String> laPlata = new VerticeImplListAdy<>("La Plata");
		        Vertice<String> brasil = new VerticeImplListAdy<>("Brasil");
		        Vertice<String> bariloche = new VerticeImplListAdy<>("Bariloche");

		        // Añadir vértices al grafo
		        grafo.agregarVertice(buenosAires);
		        grafo.agregarVertice(jacobacci);
		        grafo.agregarVertice(madrid);
		        grafo.agregarVertice(bariloche);
		        grafo.agregarVertice(brasil);
		        grafo.agregarVertice(tokyo);
		        grafo.agregarVertice(sydney);
		        grafo.agregarVertice(newYork);
		        grafo.agregarVertice(berlin);
		        grafo.agregarVertice(dubai);
		        grafo.agregarVertice(rome);
		        grafo.agregarVertice(london);
		        grafo.agregarVertice(paris);
		        grafo.agregarVertice(toronto);
		        grafo.agregarVertice(mexicoCity);
		        grafo.agregarVertice(africa);
		        grafo.agregarVertice(beijing);
		        grafo.agregarVertice(seoul);
		        grafo.agregarVertice(laPlata);

		        // (conexiones entre ciudades)
		        grafo.conectar(dubai, bariloche,30);
		        grafo.conectar(bariloche, rome,30);
		        grafo.conectar(rome, jacobacci,4);
		        grafo.conectar(buenosAires, madrid,30);
		        grafo.conectar(buenosAires, africa,10);
		        grafo.conectar(madrid, jacobacci,10);
		        grafo.conectar(madrid, buenosAires,10);
		        grafo.conectar(brasil, laPlata,10);
		        grafo.conectar(brasil, seoul,230);
		        grafo.conectar(brasil, beijing,40);
		        grafo.conectar(tokyo, berlin,70);
		        grafo.conectar(sydney, brasil,60);
		        grafo.conectar(newYork, london,150);
		        grafo.conectar(newYork, mexicoCity,60);
		        grafo.conectar(jacobacci, rome,5);
		        grafo.conectar(jacobacci, dubai,30);
		        grafo.conectar(jacobacci, madrid,10);
		        grafo.conectar(berlin, toronto,20);
		        grafo.conectar(berlin, seoul,50);
		        grafo.conectar(dubai, jacobacci,20);
		        grafo.conectar(dubai, tokyo,10);
		        grafo.conectar(london, paris,10);
		        grafo.conectar(london, beijing,40);
		        grafo.conectar(london, newYork,60);
		        grafo.conectar(paris, toronto,30);
		        grafo.conectar(paris, london,10);
		        grafo.conectar(toronto, paris,210);
		        grafo.conectar(mexicoCity, africa,30);
		        grafo.conectar(mexicoCity, newYork,400);
		        grafo.conectar(africa, buenosAires,20);
		        grafo.conectar(africa, sydney,10);
		        grafo.conectar(africa, mexicoCity,3);
		        grafo.conectar(beijing, brasil,10);
		        grafo.conectar(beijing, london,360);
		        grafo.conectar(seoul, berlin,90);
		        
		        
		        
		        ListaGenerica<String> ciudadesExceptuadas = new ListaGenericaEnlazada<String>();
		        ciudadesExceptuadas.agregarFinal("Madrid");
		        ciudadesExceptuadas.agregarFinal("Mexico City");

		        // Crea el objeto Mapa y le pasa el grafo
		        Mapa mapa = new Mapa(grafo);		        
		        ListaGenerica<String> camino = mapa.devolverCamino("Buenos Aires", "Berlin");
		        
		        // camino.comenzar();
		        // System.out.println("devolver camino cualquiera:");
		        // while (!camino.fin()) {
		        //     System.out.print(" ---> "+camino.proximo());
		        // }

		        // // Busca un camino desde Bogotá a Roma exceptuando las ciudades especificadas
		        // camino = mapa.devolverCaminoExceptuando("Buenos Aires", "Berlin", ciudadesExceptuadas);

		        // // Imprime el camino
		        // camino.comenzar();
		        // System.out.println(".");
		        // System.out.println("devolver camino exceptuando:");
		        // while (!camino.fin()) {
		        // 	System.out.print(" ---> "+camino.proximo());
		        // }
		        
		        camino=mapa.devolverCaminoCorto("Buenos Aires", "New York");
		        camino.comenzar();
		        System.out.println(".");
		        System.out.println("devolver camino mas corto:");
		        while (!camino.fin()) {
		        	System.out.print(" ---> "+camino.proximo());
		        }
		        
		        // camino=mapa.caminoSinCargarCombustible("Buenos Aires", "London",500);
		        // camino.comenzar();
		        // System.out.println(".");
		        // System.out.println("camino con 500 litros:");
		        // while (!camino.fin()) {
		        // 	System.out.print(" ---> "+camino.proximo());
		        // }

		    }

     }
