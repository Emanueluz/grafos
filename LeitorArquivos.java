


package grafos;

    
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

 public class LeitorArquivos<Tipo extends Comparable<Tipo>>{
 

    public Grafo<> ler(String string) throws IOException{
        Grafo matriz = new Grafo();
        
        ArrayList<Aresta> lista_de_arestas = new ArrayList<Aresta>();
        Cidade cidade = new Cidade<>();
        Vertice vertice = new Vertice();
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
            cidade.setCodigo(Integer.parseInt(obj[0]));cidade.setNome(obj[1]);
            vertice.setValor(cidade);
            lista_de_Vertices.add(vertice);
        }


        /* loop que converte matriz de arestas do arquivo txt em grafo*/
 
        for (int linhas_da_matriz = 0;linhas_da_matriz <=numero_de_casos-1;linhas_da_matriz++){
            linha = buffRead.readLine();
            obj = linha.split(";");


            for (int coluna_da_matriz=0;coluna_da_matriz<=obj.length-1;coluna_da_matriz++){
                Aresta aresta = new Aresta();
                aresta.setOrigem(lista_de_Vertices.get(linhas_da_matriz));
                aresta.setDestino(lista_de_Vertices.get(linhas_da_matriz));
                aresta.setPeso(Integer.parseInt(obj[coluna_da_matriz]));
                lista_de_arestas.add(aresta);
            }


            
             
         }

         
        matriz.setarestas(lista_de_arestas);
        matriz.setvertices(lista_de_Vertices);
        matriz.setqArestas(numero_de_casos);
        buffRead.close();
        long tempo = System.currentTimeMillis() - tempoInicial;
        System.out.println("O método foi executado em " +tempo+" ms");

        return  matriz;
    }

  
}


