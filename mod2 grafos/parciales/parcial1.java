public class parcial1 {
    

    private Vertice<Ciudad> obtenerVertice(Grafo<Ciudad> grafo, String nombre){
        Vertice<Ciudad> v=null;

        ListaGenerica<Vertice<Ciudad>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        boolean encontre = false;
        while(!vertices.fin() && encontre==false){
            v=vertices.proximo();
            if(v.dato().getNombre().equals(nombre))
                encontre=true;
        }

        if(encontre)
            return v;
        else
            return null;
    }

    public int resolver (Grafo<Ciudad> grafo, String origen, String destino, int maxControles){
        Dias diasMax=new Dias();

        diasMax.setDias(0);

        if(grafo!=null && !grafo.esVacio()){
            boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
            Vertice<Ciudad> vIni = obtenerVertice(grafo, origen);
            Vertice<Ciudad> vDes = obtenerVertice(grafo, destino);

            if(vIni!=null && vDes!=null){
                resolverRec(grafo, vIni, vDes, maxControles, 0, diasMax, marca);
            }

        }
        return diasMax.getDias();
    }

    private void resolverRec(Grafo<Ciudad> grafo, Vertice<Ciudad> vIni, Vertice<Ciudad> vDes, int maxControles, int diasAct, Dias diasMax, boolean[] marca){
        marca[vIni.posicion()]=true;

        if(vIni.dato().getNombre().equals(vDes.dato().getNombre())){
            if(diasAct>diasMax.getDias())
                diasMax.setDias(diasAct);
        }
        else{
            ListaGenerica<Arista<Ciudad>> adyacentes = new ListaGenericaEnlazada<Arista<Ciudad>>();
            Arista<Ciudad> a;
            adyacentes=grafo.listaDeAdyacentes(vIni);
            adyacentes.comenzar();
            while(!adyacentes.fin()){
                a=adyacentes.proximo();
                if(marca[a.verticeDestino().posicion()]==false && a.peso()<=maxControles)
                    resolverRec(grafo, a.verticeDestino(), vDes, maxControles, diasAct+a.verticeDestino().dato().getLimDias(), diasMax, marca);
            }
        }
        marca[vIni.posicion()]=false;
    }

}
