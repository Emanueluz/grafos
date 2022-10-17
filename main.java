package grafos;

import java.util.Scanner;

public class main <Tipo extends Comparable<Tipo>>{
	
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);

        String matricula = "";
        int menu = 0;



        while(menu!=99){
            System.out.println(
            " Obter cidades vizinhas: digite 1.\n"+ 
            "Obter todos os caminhos a partir de uma cidade:digite 2\n"+
            "Sair:digite 99\n"+
            "digite a sua escolha: ");
            menu =scanner.nextInt();
            if(menu==1){
 
            }
            else if(menu==2){
                }
 
            else if(menu==99){

            }
            else{ 
                System.out.println("DADO DE ENTRADA INVALIDO ");

            }
        


    } 


        
    }



}