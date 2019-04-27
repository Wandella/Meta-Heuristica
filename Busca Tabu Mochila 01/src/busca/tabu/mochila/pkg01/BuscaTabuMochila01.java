/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;

import java.util.ArrayList;

/**
 *
 * @author wandella
 */
public class BuscaTabuMochila01 {

    //Variaveis para leituras vindas do arquivo
    public static ArrayList<Integer> lucro = new ArrayList();
    public static ArrayList<Integer> peso = new ArrayList();
    public static float cap_max_mochila;
    public static int itens;
    //Variavel para inserir a sequencia de zeros e 1s iniciais
    public static ArrayList<Integer> solucao_inicial = new ArrayList();
    
     //Variavel para inserir a sequencia de zeros e 1s iniciais de cada vez que os vizinhos sao recalculados
    public static ArrayList<Integer> solucao_corrente = new ArrayList();
    public static int lucro_corrente, peso_corrente;
    //Valor do lucro incial e do peso inicial
    public  static int lucro_inicial,peso_inicial;
    
    //Lista Tabu
    public static ArrayList<Integer> listaTabu = new ArrayList();
    public static int maximo_elementos =2;
    
    
    public static void main(String[] args) {
        //abrindo e lendo arquivo
        LeArquivo novo = new LeArquivo();
        System.out.println(novo.LendoArquivo());
        
        //Gerando o vetor com a solução inicial
        SolucaoInicial inicio = new SolucaoInicial();
        System.out.println(inicio.Verifica_Solucao());
        
        for (int i = 0; i < itens; i++) {
            System.out.print(solucao_inicial.get(i));
        }
       
              
        System.out.println("");
        
        //Tabela
        //Matriz de vizinhaça
         int linha, coluna,escolhido;
        linha = itens;
        coluna = itens + 2;
        int[][] ma = new int[linha][coluna];
        Vizinhanca vizinhos = new Vizinhanca();
        ma= vizinhos.preencheMatriz(ma);
        vizinhos.vizinhanca_solucao_inicial(ma);
        vizinhos.calculo_custos(ma);
        vizinhos.exibe_matriz(ma);
        buscaTabu tabu = new buscaTabu();
        
        for (int i = 0; i < 10; i++) {
            escolhido = tabu.linhaEscolhia(ma, itens);
            tabu.solucao_corrente(ma, escolhido);
            for (int j = 0; j < itens; j++) {
                System.out.print(solucao_corrente.get(j));
           
            }
            System.out.println("Linha ->"+escolhido);
            ma = vizinhos.preencheMatriz(ma);
            vizinhos.vizinhanca_solucao_inicial(ma);
            vizinhos.calculo_custos(ma);
            vizinhos.exibe_matriz(ma);
        }
        
        
        //System.out.println("\nLucro Total\t=\t"+inicio.funcao_soma_lucro(solucao_inicial));
        //System.out.println(" "+lucro.size()+" "+peso.size()+" "+cap_max_mochila);
        //System.out.println("\nPeso Total\t=\t"+inicio.funcao_soma_peso(solucao_inicial));
    }
    
    public void exibeCorrente(){
        for (int i = 0; i < itens; i++) {
            System.out.print(solucao_corrente.get(i));
           // System.out.println(gerador.nextInt(2));
        }
    }
}