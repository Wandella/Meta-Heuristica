/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;

import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.itens;
import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.cap_max_mochila;
import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.lucro;
import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.peso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author wandella
 */
public class LeArquivo {

       
    public String LendoArquivo(){
         int contaLinhas=0;
        //Lendo arquivo
        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
          FileReader arq = new FileReader(nome);
          BufferedReader lerArq = new BufferedReader(arq);

          String linha = lerArq.readLine(); // lê a primeira linha
          // a variável "linha" recebe o valor "null" quando o processo
         // de repetição atingir o final do arquivo texto
    
          while (linha != null) {
              System.out.printf("%s\n", linha);
              if(contaLinhas==0){
                  //Na primeira linha armazena a capacidade da mochila
                  String[] teste = linha.split(" ");
                  itens = Integer.parseInt(teste[0]);
                  cap_max_mochila = Float.parseFloat(teste[1]);
                  System.out.println("Capacidade Total da mochila = "+cap_max_mochila);
                  contaLinhas++;
                  linha = lerArq.readLine(); // lê da segunda até a última linha
                  continue;
              }
              if(contaLinhas>0){
                  //System.out.println("AQuiiii");
                  String[] teste = linha.split(" ");
                  lucro.add(Float.parseFloat(teste[0]));
                  peso.add(Float.parseFloat(teste[1]));
              }
              
              
            linha = lerArq.readLine(); // lê da segunda até a última linha
          }

          arq.close();
          
            /*for (int i = 0; i < 10; i++) {
                System.out.println(""+lucro.get(i)+" - "+ peso.get(i));
            }*/
           return "Arquivo Lido com sucesso!";
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
              return "Erro Not Found!";
              
        }
    }
       
}
