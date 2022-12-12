/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

import java.util.ArrayList;
 

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
    @Override
    public Grafo clone(){
        Grafo copia = new Grafo<>();
        copia.setarestas(this.getarestas());
        copia.setvertices(this.getvertices());
        copia.setqArestas(this.getqArestas());
        return copia;
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

    public void prim(){
        ArrayList v_vertices= new ArrayList<>();
        ArrayList v_aretas= new ArrayList<>();
        Vertice v_atual= this.vertices.get(0);
        Aresta a_atual= this.arestas.get(0);
        float soma= 0; 
        v_vertices.add(v_atual); // lista de vertices visitados 
        while(this.vertices.size() > v_vertices.size()){
            float f_aux=(float) 999999;
            for(int i =0; i<this.arestas.size();i++){
                if(this.arestas.get(i).getPeso()<f_aux && v_vertices.contains(this.arestas.get(i).getOrigem())==true && v_vertices.contains(this.arestas.get(i).getDestino())==false){
                    f_aux = this.arestas.get(i).getPeso();
                    v_atual=this.arestas.get(i).getDestino();
                    a_atual=this.arestas.get(i);
                    
                }
            }
            if(v_vertices.contains(v_atual)==false) {
                soma=soma+f_aux;
                v_vertices.add(v_atual);
                v_aretas.add(a_atual);
                System.out.println("origem:"+((Cidade)a_atual.getOrigem().getValor()).getNome()+"     destino:"+((Cidade)a_atual.getDestino().getValor()).getNome()+"   peso:"+a_atual.getPeso());
            }
        }
        System.out.println("soma total dos pesos: " +soma);
    }

    public ArrayList<ArrayList<Aresta>> lista_de_caminhos(Vertice origem){
        Grafo copia = this.clone();
        ArrayList<ArrayList<Aresta>> caminhos_possiveis= new ArrayList<ArrayList<Aresta>>();
        ArrayList<ArrayList<Vertice>> exclusivos= new ArrayList<ArrayList<Vertice>>();

        ArrayList<Aresta> caminho= new ArrayList<>();
        ArrayList<Vertice> passados = new ArrayList<Vertice>();
        ArrayList<Aresta> aux_de_caminho  = new ArrayList<Aresta>();
        
        Vertice atual =  origem;
        int fim_do_caminho=0;
        int contar_caminho=0;

        for (int k=0 ;k<copia.arestas.size();k++){
        for (int j=0 ;j<copia.arestas.size();j++){ // loop para começar e/ou marcar um caminho como pecorrido
            if (fim_do_caminho==copia.arestas.size() && caminhos_possiveis.contains(aux_de_caminho)==false){ // verifica se um caminho chegou ao seu fim 
                contar_caminho=contar_caminho+1;
               // System.out.print("CAMINHO "+contar_caminho+": ");   

                for(int a =0;a<passados.size();a++){ // se chegou ao fim, o programa printa o caminho 
                   System.out.print(((Cidade)passados.get(a).getValor()).getNome() +"   ");   
                   //aux_de_caminho.add(copia.arestas.get(a));
                   
                }
                fim_do_caminho++;
                System.out.println( );
                caminhos_possiveis.add(aux_de_caminho); // marca o caminho como já classificado, para n se repetir 
                exclusivos.add(passados);
                atual=origem;
                aux_de_caminho= new ArrayList<Aresta>();
                passados= new ArrayList<Vertice>();

            }

 
            if (passados.size()==0){// caso vá começar um novo caminho 
                passados.add(origem);
            }
            fim_do_caminho=0; // variavel axiliar para que o próximo loop consiga ser usado
                              // para definir se houve ou não uma marcação 
            
            for(int i=0 ;i<copia.arestas.size();i++){ // loop para verificar qual será o prócimo vertisse do caminho 
                if((((Aresta)copia.arestas.get(i)).getOrigem())==atual  &&
                passados.contains(((Aresta)copia.arestas.get(i)).getDestino())==false){
                    aux_de_caminho.add((Aresta)copia.arestas.get(i)); // caminho auxiliar 
 
                    if(caminhos_possiveis.contains(aux_de_caminho)==false){
                    atual=(((Aresta)copia.arestas.get(i)).getDestino());
                    passados.add(atual);}
                     else{( aux_de_caminho).remove((int)aux_de_caminho.size()-1);
                    fim_do_caminho=fim_do_caminho+1;}
                    
                }
                else{fim_do_caminho=fim_do_caminho+1;} // verificador se não houve nenhum vertisse elegivel para compor o caminho 
            }
        }}
        /*for (int f=0;f<caminhos_possiveis.size();f++){
            if(exclusivos.contains(caminhos_possiveis.get(f))==false){
                exclusivos.add(caminhos_possiveis.get(f));
                for(int l=0;l<caminhos_possiveis.get(f).size();l++){
                    System.out.print(((Cidade)((caminhos_possiveis.get(f)).get(l).getOrigem()).getValor()).getNome() +"-"+((Cidade)((caminhos_possiveis.get(f)).get(l).getDestino()).getValor()).getNome()+" " );
                }
                System.out.println();
            }
        }*/
        return caminhos_possiveis;
    }

    public void fmaximo(Vertice origem, Vertice destino){
        Grafo copia = this.clone();
        ArrayList<Aresta<Tipo>>  lista_de_arestas =copia.arestas;
        float fmax = 0;
        ArrayList<Vertice<Tipo>> ver_bloqueados = new ArrayList<Vertice<Tipo>> ();
        ArrayList<Aresta<Tipo>>  ares_bloqueados =new ArrayList<Aresta<Tipo>>();
        int wer=0;

        while(ver_bloqueados.contains(origem)==false){
            
            float fluxo_atual=9999999;
            ArrayList<Vertice<Tipo>> passados = new ArrayList<Vertice<Tipo>> ();
            Vertice atual = origem;
            ArrayList caminho = new ArrayList() ;
            System.out.println( );
            int i =0;
            while(atual!=destino){ //Caminhar o grafo até chegar ao destino
                
                if(passados.size()==0){
                    atual=origem;
                    passados.add(atual);
                }
                for (int j =0;j<lista_de_arestas.size();j++){
                    if ((lista_de_arestas.get(j).getOrigem()==atual) &&  //Caso vertice atual esteja no comeco de dado caminho 
                    (lista_de_arestas.get(j).getPeso() >0) &&  //e estar incluso em um arco positivo
                    passados.contains(lista_de_arestas.get(j).getDestino())==false && //e o caminho para o vizinho nao tenha sido percorrido
                    ver_bloqueados.contains(lista_de_arestas.get(j).getDestino())==false&&
                    ares_bloqueados.contains(lista_de_arestas.get(j))==false)  //Adiciona o indice do atual ao caminho
                    {
                        if (fluxo_atual==9999999){
                            fluxo_atual=lista_de_arestas.get(j).getPeso();
                        }// dá a variavel axiliar o valor de fluxo da primeira aresta 
                        System.out.print(((Cidade)atual.getValor()).getNome()+"-");

                        atual=lista_de_arestas.get(j).getDestino(); //Atual recebe o vizinho

                        System.out.print(((Cidade)atual.getValor()).getNome()+"-");
                        passados.add(atual); //Novo atual incluso na lista de percorridos
                        caminho.add(j); //Adiciona o indice do atual ao caminho
                        System.out.print(((Cidade)atual.getValor()).getNome()+"   ");
                        if(fluxo_atual>lista_de_arestas.get(j).getPeso()){
                            fluxo_atual=lista_de_arestas.get(j).getPeso();  //Fluxo maximo atualizado com o peso do arco
                        }
                          
                    }   
                    
                }
            
        }

        
        // atualisa o valor de fluxo das arestas que formam o caminho 
        if (atual==destino){
            fmax+=fluxo_atual; // incremento do fluxo máximo
            for (int y =0;y<caminho.size();y++){
            
            lista_de_arestas.get((int) caminho.get(y)).setPeso(lista_de_arestas.get((int) caminho.get(y)).getPeso()-fluxo_atual);
            if (lista_de_arestas.get((int) caminho.get(y)).getPeso()==0){
                ares_bloqueados.add(lista_de_arestas.get((int)caminho.get(y)));
            System.out.println(((Cidade)lista_de_arestas.get((int) caminho.get(y)).getOrigem().getValor()).getNome() +" === === == "+((Cidade)lista_de_arestas.get((int) caminho.get(y)).getDestino().getValor()).getNome());}
          }}
        
        atual=origem; 
        
        //determina quais arestas e vertices nao podem mais ser usados para fazer caminhos
        for(int k=0; k<copia.vertices.size();k++){
            int aux_ver=0;
            int conta_ares=0;
           // System.out.println("verificando outro vertice ");

            for(int l=0; l<lista_de_arestas.size();l++){
                if(lista_de_arestas.get(l).getOrigem()==copia.vertices.get(k)){
                    if(lista_de_arestas.get(l).getPeso()==0){
                        conta_ares=conta_ares+1;
                    }
                    aux_ver=aux_ver+1;
                   // System.out.println(aux_ver);
                }
            }
            if(aux_ver==conta_ares && aux_ver!=0){
                
                ver_bloqueados.add((Vertice) copia.vertices.get(k));
                 for(int q=0; q<lista_de_arestas.size();q++){
                    if(ver_bloqueados.contains(lista_de_arestas.get(q).getDestino())==true){
                        ares_bloqueados.add(lista_de_arestas.get(q));
                     }
                }
            }
            
        }
 
        wer=wer+1;
        if(wer==10){ver_bloqueados.add(atual);}
    }   System.out.println("O FLUXO MAXIMO DE "+((Cidade) origem.getValor()).getNome()+" até "+((Cidade) destino.getValor()).getNome()+" É "+ fmax);
           
    }


    public void fluxo_maximo(Vertice origem, Vertice destino){
        ArrayList<ArrayList<Aresta>> caminhos_possiveis= new ArrayList<ArrayList<Aresta>>();
        ArrayList<ArrayList<Aresta>> caminhos_totais= lista_de_caminhos(origem);
        float fluxo_maximo=0;
        for(int i =0;i<caminhos_totais.size();i++){
            if (caminhos_totais.get(i).size()!=0){    
            if (caminhos_totais.get(i).get(0).getOrigem()==origem && 
            caminhos_totais.get(i).get(caminhos_totais.get(i).size()-1).getDestino()==destino){
                caminhos_possiveis.add(caminhos_totais.get(i));
            }}
        } 

        for (int j=0; j<caminhos_possiveis.size();j++){// lista de caminhos 
            Boolean atualizar=true;
            float fluxo_atual=0;
           for(int k=0; k<caminhos_possiveis.get(j).size();k++){//percorendo o próximo caminho
            if (fluxo_atual==0 || (caminhos_possiveis.get(j).get(k)).getPeso()<fluxo_atual){ fluxo_atual= (caminhos_possiveis.get(j).get(k)).getPeso();}
            if ((caminhos_possiveis.get(j).get(k)).getPeso()==0){ atualizar=false;}
           }
           if (atualizar){ fluxo_maximo=fluxo_maximo+fluxo_atual;
                for(int k=0; k<caminhos_possiveis.get(j).size();k++){// att fluxo das arestas
                    caminhos_possiveis.get(j).get(k).setPeso(
                    caminhos_possiveis.get(j).get(k).getPeso()-fluxo_atual);}
            }
        }
        System.out.println("Fluxo Máximo: "+fluxo_maximo);
    }

}
 

