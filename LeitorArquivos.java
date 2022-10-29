package grafos;

import grafos.Grafo;
import grafos.Aresta;
import grafos.Vertice;   
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

 public class LeitorArquivos<Tipo extends Comparable<Tipo>>{
    Grafo matriz =new Grafo() ;
     Vertice vertice = new Vertice( );
    public Grafo<Tipo> ler(String string) throws IOException{
        
        
        ArrayList<Aresta> lista_de_arestas = new ArrayList<Aresta>();
        
        ArrayList<Vertice> lista_de_Vertices = new ArrayList<Vertice>();
        
        long tempoInicial = System.currentTimeMillis();
        String linha = ""; 
        BufferedReader buffRead =new BufferedReader(new FileReader(string));
        linha = buffRead.readLine();
        int numero_de_casos = Integer.parseInt(linha);
        System.out.println(numero_de_casos);
        String[] obj;

        // Percorre as linhas do arquivo txt responsáveis por indicar o código e o nome da cidade
        for (int i=0;i <=numero_de_casos-1;i++){
            linha = buffRead.readLine();
            obj = linha.split(";");
            Cidade  cidade= new Cidade(Integer.parseInt(obj[0]), obj[1]);
            this.vertice.setValor(cidade);
            lista_de_Vertices.add(this.vertice);
        }


        /* loop que converte matriz de arestas do arquivo txt em grafo*/
 
        for (int linhas_da_matriz = 0;linhas_da_matriz <=numero_de_casos-1;linhas_da_matriz++){
            linha = buffRead.readLine();
            obj = linha.split(";");


            for (int coluna_da_matriz=0;coluna_da_matriz<=obj.length-1;coluna_da_matriz++){
                Aresta aresta = new Aresta();
                aresta.setOrigem(lista_de_Vertices.get(linhas_da_matriz));
                aresta.setDestino(lista_de_Vertices.get(linhas_da_matriz));
                aresta.setPeso(Float.parseFloat((obj[coluna_da_matriz]).replace(",", ".")));
                lista_de_arestas.add(aresta);
            }


            
             
         }

         
        this.matriz.setarestas(lista_de_arestas);
        this.matriz.setvertices(lista_de_Vertices);
        this.matriz.setqArestas(numero_de_casos);
        buffRead.close();
        long tempo = System.currentTimeMillis() - tempoInicial;
        System.out.println("O método foi executado em " +tempo+" ms");
         
        return  this.matriz;
    }

  
}


