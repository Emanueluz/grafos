package grafos;

import java.util.ArrayList;
import java.util.Vector;

public class Dijkstra<Tipo extends Comparable>{
 
    ArrayList rotulados ;
    ArrayList não_rotulados ;
    Vertice  ultimo_rotulado = new Vertice();
    ArrayList estimativas;
    ArrayList<Vertice> lista_vertice; 



    public void montar_dijkstra(Grafo grafo, Cidade origem ){
        Vertice atual =new Vertice();
        for (int i=0;i<grafo.getvertices().size();i++){
            if (((Vertice)grafo.getvertices().get(i)).getValor()==origem){
                atual = (Vertice)grafo.getvertices().get(i);
            }

        }
        
        ArrayList<Aresta> lista_de_arestas= grafo.getarestas();
        ArrayList<Vertice>  lista_de_precedentes= new ArrayList<Vertice>();//colocar um valor inicial que indique que o predecessor n foi calculado 
        ArrayList estimativas= new ArrayList();
        
        for(int u =0;u<grafo.getvertices().size();u++){estimativas.add(u, 99999);lista_de_precedentes.add((Vertice)grafo.getvertices().get(u));}
        ArrayList abertos =grafo.getvertices();
        ArrayList<Vertice> fechados = new ArrayList(); 

        
        int t=0;
         ArrayList<Vertice> lista_de_vertices = grafo.getvertices();// lista de vertices do grafo
        int aux=0;    
      
        System.out.println(estimativas.size());    
        estimativas.set(aux,0);
        estimativas.set(lista_de_vertices.indexOf(atual),0);
        lista_de_precedentes.set(lista_de_vertices.indexOf(atual),atual);
        fechados.add(atual);
        while(fechados.size()<lista_de_vertices.size() || t ==1){

            for ( int i = 0 ; i<lista_de_arestas.size();i++){ //pecorrendo a lista de arestas para saber quais são as cidades vizinhas
                if((Vertice)lista_de_arestas.get(i).getOrigem()==atual && fechados.contains(fechados)==false){
                    //marcando os VERTICES QUE ESTÃO ABERTOS
                    //marcando as ESTIMATIVAS das distancias
                    //marcando os PRECEDENTES
                    //para a marcação ocorrer, os verteces tem que estar marcadas como abertos 
                    int index = lista_de_precedentes.indexOf((Vertice)lista_de_arestas.get(i).getOrigem());
                    if ((int)estimativas.get(index)<(int)lista_de_arestas.get(i).getPeso()){
                         
                            lista_de_precedentes.set(index, atual); // define os precedentes dos "próximos" vertices
                        
                            estimativas.set(index, lista_de_arestas.get(i).getPeso()); // define os pesos de um vertice a outro       
                            System.out.println("CIDADE : "+(((Cidade)atual.getValor()).getNome())+"   ESTIMATIVA  : "+lista_de_arestas.get(i).getPeso()+"   PRECEDENTES  : "+((Cidade)lista_de_precedentes.get(i).getValor()).getNome());
                        }}}}
                            t=1;}} 


            // seleciona qual dos caminhos é mais curto 
            //e fecha para selecionar o próximo vertice a ser analizado
            /*
            float vertice_com_menor_estimativa=99999;
                
            for (int k=0;k<lista_de_precedentes.size();k++){
               
                if ((Vertice)lista_de_precedentes.get(k)==atual && (int)estimativas.get(lista_de_vertices.indexOf(atual))!=0 ){
                    float estimativa_atual= (int)estimativas.get(lista_de_vertices.indexOf(atual));
                    if (vertice_com_menor_estimativa>estimativa_atual){
                        vertice_com_menor_estimativa=estimativa_atual;
                    }
                }}
             fechados.add( lista_de_vertices.get(estimativas.indexOf(vertice_com_menor_estimativa)));
            if (fechados.size()<abertos.size()){atual=lista_de_vertices.get(estimativas.indexOf(vertice_com_menor_estimativa));}
                 */

            


       



            




        









         
    
       

