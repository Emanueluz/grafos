package grafos;

import java.util.ArrayList;
import java.util.Vector;

public class Dijkstra<Tipo extends Comparable>{
 
    ArrayList rotulados ;
    ArrayList não_rotulados ;
    Vertice  ultimo_rotulado = new Vertice();
    ArrayList estimativas;
    ArrayList<Vertice> lista_vertice; 



    void montar_dijkstra(Grafo grafo, Vertice origem ){
        Vertice atual =origem;
        ArrayList<Aresta> lista_de_arestas= grafo.getarestas();
        ArrayList<Vertice> lista_de_vertices = grafo.getvertices();
        ArrayList<Vertice> lista_de_precedentes = grafo.getvertices();
        ArrayList estimativas= new ArrayList<Float>();
        for(int i=0;i<grafo.getvertices().size();i++){ estimativas.add(999999);}


        ArrayList abertos =grafo.getvertices();
        ArrayList<Vertice> fechados = new ArrayList();
        
        ArrayList distancia ;// lista de vertices do grafo 
        ArrayList predecessores ;//colocar um valor inicial que indique que o predecessor n foi calculado 



        while(fechados.size()<lista_de_vertices.size()){
            for (int i = 0 ; i<lista_de_arestas.size();i++){ //pecorrendo a lista de arestas para saber quais são as cidades vizinhas
                if((Vertice)lista_de_arestas.get(i).getOrigem()==atual){
                    //marcando os VERTICES QUE ESTÃO ABERTOS
                    //marcando as ESTIMATIVAS das distancias
                    //marcando os PRECEDENTES
                    //para a marcação ocorrer, os verteces tem que estar marcadas como abertos 
                    if(lista_de_precedentes.contains((Vertice)lista_de_arestas.get(i).getOrigem()) && abertos.contains((Vertice)lista_de_arestas.get(i).getOrigem())  ) {
                        int index = lista_de_precedentes.indexOf((Vertice)lista_de_arestas.get(i).getOrigem());
                            if ((Float)estimativas.get(index)<lista_de_arestas.get(i).getPeso()){
                                lista_de_precedentes.set(index, atual); // define os precedentes dos "próximos" vertices
                                estimativas.set(index, lista_de_arestas.get(i).getPeso()); // define os pesos de um vertice a outro       
                            }}}}


            // seleciona qual dos caminhos é mais curto 
            //e fecha para selecionar o próximo vertice a ser analizado
            float vertice_com_menor_estimativa=9999999;
                
            for (int k=0;k<lista_de_precedentes.size();k++){
               
                if ((Vertice)lista_de_precedentes.get(k)==atual && (float)estimativas.get(lista_de_vertices.indexOf(atual))!=0 ){
                    float estimativa_atual= (float)estimativas.get(lista_de_vertices.indexOf(atual));
                    if (vertice_com_menor_estimativa>estimativa_atual){
                        vertice_com_menor_estimativa=estimativa_atual;
                    }
                }}
                 
            fechados.add( lista_de_vertices.get(estimativas.indexOf(vertice_com_menor_estimativa)));
            if (fechados.size()<abertos.size()){atual=lista_de_vertices.get(estimativas.indexOf(vertice_com_menor_estimativa));}
            

            }}}



       



            




        









         
    
       

