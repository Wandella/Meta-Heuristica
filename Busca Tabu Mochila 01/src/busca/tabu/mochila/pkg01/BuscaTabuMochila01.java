/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    //Variavel para a solucao do problema
    public static ArrayList<Integer> solucao_inicial = new ArrayList();
    
    //Melhor solução
    public  static int melhor_solucao;
    
    //Lista Tabu
    public static ArrayList<Integer> listaTabu = new ArrayList();

    public static void main(String[] args) {
        //abrindo e lendo arquivo
        LeArquivo novo = new LeArquivo();
        System.out.println(novo.LendoArquivo());
        
        //Gerando o vetor com a solução inicial
        SolucaoInicial inicio = new SolucaoInicial();
        inicio.solucaoInicial(itens);
        melhor_solucao = inicio.Funcao_soma_lucro(solucao_inicial);
        System.out.println("Melhor solucao"+melhor_solucao);
        //System.out.println("capacidade mochila="+cap_max_mochila);
        //System.out.println("Itens ="+itens);
        /*System.out.println(""+solucao_inicial);*/
        for (int i = 0; i < itens; i++) {
            System.out.print(solucao_inicial.get(i));
           // System.out.println(gerador.nextInt(2));
        }
        System.out.println("");

        //Tabela
        //Matriz de vizinhaça
        int linha, coluna;
        linha = itens;
        coluna = itens + 2;
        int[][] ma = new int[linha][coluna];
        //System.out.println("aqui o "+ma.length);
        Vizinhanca vizinhos = new Vizinhanca();
        vizinhos.preencheMatriz(ma);
        //vizinhos.exibe_matriz(ma);
        vizinhos.vizinhanca_solucao_inicial(ma);
        vizinhos.calculo_custos(ma);
        //vizinhos.exibe_matriz(ma);
        //System.out.println("\nLucro Total\t=\t"+inicio.funcao_soma_lucro(solucao_inicial));
        //System.out.println(" "+lucro.size()+" "+peso.size()+" "+cap_max_mochila);
        //System.out.println("\nPeso Total\t=\t"+inicio.funcao_soma_peso(solucao_inicial));
    }
}
