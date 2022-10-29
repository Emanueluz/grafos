/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

import java.util.ArrayList;
import grafos.Vertice.*;
import grafos.Aresta.*;

public class Grafo<Tipo extends Comparable<Tipo>>{
    private ArrayList<Aresta<Tipo>>  arestas ;
    private ArrayList<Vertice<Tipo>> vertices;
    private int qArestas;
    
    Grafo( ){
        this.arestas = new ArrayList<Aresta<Tipo>>();
        this.vertices = new ArrayList<Vertice<Tipo>>();
     }
    
    public ArrayList<Aresta<Tipo>> getarestas(){
        return this.arestas;
    }
    public void setarestas(ArrayList<Aresta<Tipo>> A)
    {
            this.arestas=A;
    }
    public ArrayList<Vertice<Tipo>> getvertices(){
        return this.vertices;
    }
    public void setvertices(ArrayList<Vertice<Tipo>> A)
    {
         this.vertices= A;
    }
    public int getqArestas(){
        return this.qArestas;
    }
    public void setqArestas(int A)
    {
         this.qArestas=A;
    }
    public retornar_aresta(int linha, int coluna){
        return (this.arestas.get(linha)).get(coluna);
    }
    
    



    public ArrayList<Aresta<Tipo>>  arestas_da_origem(Vertice vertice){

         ArrayList<Aresta<Tipo>> vizinhas= new ArrayList<Aresta<Tipo>>();
   
         for(int i=0;i==this.arestas.size();i++){
            if ((this.arestas.get(i)).getOrigem()==vertice){
                vizinhas.add((this.arestas.get(i)));
            
                
            
               }
    }
        return vizinhas;
     }
}

