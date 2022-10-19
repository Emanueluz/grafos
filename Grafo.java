/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

import java.util.ArrayList;
import Grafos.Vertice.*;
import Grafos.Aresta.*;

public class Grafo<Tipo extends Comparable>{
    private   ArrayList<Aresta<Tipo>>  arestas ;
    private ArrayList<Vertice<Tipo>> vertices;
    int qArestas;
    
    Grafo( int q){
        this.arestas = new ArrayList<Aresta<Tipo>>();
        this.vertices = new ArrayList<Vertice<Tipo>>();
        this.qArestas = q;
    }
    
    public ArrayList<ArrayList<Aresta<Tipo>>> getarestas(){
        return this.arestas;
    }
    public ArrayList<ArrayList<Aresta<Tipo>>> setarestas(ArrayList<ArrayList<Aresta<Tipo>>> A)
    {
         this.arestas=A;
    }
    public ArrayList<Vertice<Tipo>> getvertices(){
        return this.arestas;
    }
    public ArrayList<Vertice<Tipo>> setvertices(ArrayList<Aresta<Tipo>> A)
    {
         this.arestas=A;
    }
    public int getqArestas(){
        return this.arestas;
    }
    public int setqArestas(int A)
    {
         this.arestas=A;
    }
    public retornar_aresta(int linha, int coluna){
        return this.arestas[linha][coluna];
    }
    
}

